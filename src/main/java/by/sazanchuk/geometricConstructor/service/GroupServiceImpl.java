package by.sazanchuk.geometricConstructor.service;

import by.sazanchuk.geometricConstructor.model.Group;
import by.sazanchuk.geometricConstructor.model.dto.GroupDTO;
import by.sazanchuk.geometricConstructor.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private FigureServiceImpl figureService;

    public Group save (Group group) {
        return groupRepository.save(group);
    }

    public List<GroupDTO> findAllByPictureId (Long pictureId) {
        List<Group> groups = groupRepository.findAllByPictureIdAndRootGroupIsNull(pictureId);

        List<GroupDTO> dto = toDTO(groups);
        dto
                .forEach(
                        group -> {
                            List<GroupDTO> innerGroups = toDTO(groupRepository.findAllByRootGroupId(group.getId()));

                            group.setGroups(innerGroups);
                            group.setFigures(figureService.findAllByGroup(group.getId()));
                        }
                );

        return dto;
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group findById (Long id) {
        return groupRepository.findById(id).get();
    }

    private List<GroupDTO> findAllRootGroupsInPicture (Long pictureId) {
        List<Group> groups = groupRepository.findAllByPictureIdAndRootGroupIsNull(pictureId);

        return toDTO(groups);
    }

    private List<GroupDTO> toDTO(List<Group> groups) {
        return groups.stream()
                .map(Group::toDTO)
                .collect(Collectors.toList());
    }
}
