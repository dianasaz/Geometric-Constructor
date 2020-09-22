package by.sazanchuk.geometricConstructor.service;

import by.sazanchuk.geometricConstructor.model.Group;
import by.sazanchuk.geometricConstructor.model.Picture;
import by.sazanchuk.geometricConstructor.model.dto.GroupDTO;
import by.sazanchuk.geometricConstructor.repository.GroupRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Log
@Service
public class GroupServiceImpl {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private FigureServiceImpl figureService;

    @Transactional
    public void save (GroupDTO dto, Picture picture) throws NoEntityException {
        Group group = null;

        if (dto.getId() != null && groupRepository.existsById(dto.getId())) {
            group = groupRepository.findById(dto.getId()).get();
        }
        else {
            group = new Group();
            group.setPicture(picture);
        }

        group.setOrderNumber(dto.getOrderNumber());
        if (dto.getRootGroup() != null) {
            Group rootGroup = groupRepository.findById(dto.getRootGroup().getId()).orElseThrow(() -> new NoEntityException("No group found"));
            group.setRootGroup(rootGroup);
        }

        group = groupRepository.save(group);

        if (!dto.getFigures().isEmpty()) {
            figureService.saveAll(dto.getFigures(), group, picture);
        }

        if (!dto.getGroups().isEmpty()) {
            saveInnerGroups(dto.getGroups(), group, picture);
        }
    }

    @Transactional
    public void saveAll (List<GroupDTO> rootGroups, Picture picture) {
        rootGroups
                .forEach(
                        groupDTO -> {
                            try {
                                save(groupDTO, picture);
                            } catch (NoEntityException e) {
                                log.info("No figure found with such id");
                            }
                        }
                );
    }

    @Transactional
    public List<GroupDTO> findAllByPictureId (Long pictureId) {
        List<Group> groups = groupRepository.findAllByPictureIdAndRootGroupIsNull(pictureId);

        List<GroupDTO> dto = toDTO(groups);
        fillAllGroups(dto);

        return dto;
    }

    @Transactional
    public void removeAllByPicture (Picture picture) {
        figureService.removeAllByPicture(picture);
        groupRepository.deleteAllByPicture(picture);
    }

    private void fillAllGroups(List<GroupDTO> dto) {
        for (GroupDTO group : dto) {
            List<GroupDTO> innerGroups = toDTO(groupRepository.findAllByRootGroupId(group.getId()));

            group.setGroups(innerGroups);
            group.setFigures(figureService.findAllByGroup(group.getId()));

            if (!innerGroups.isEmpty()) {
                fillAllGroups(innerGroups);
            }
        }
    }

    private void saveInnerGroups (List<GroupDTO> groupDTOS, Group group, Picture picture) {
        groupDTOS
                .forEach(
                        groupDTO -> {
                            try {
                                groupDTO.setRootGroup(group.toDTO());
                                save(groupDTO, picture);
                            } catch (NoEntityException e) {
                                log.info("No figure found with such id");
                            }
                        }
                );
    }

    private List<GroupDTO> toDTO(List<Group> groups) {
        return groups.stream()
                .map(Group::toDTO)
                .collect(Collectors.toList());
    }

}
