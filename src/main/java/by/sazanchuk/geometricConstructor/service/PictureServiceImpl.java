package by.sazanchuk.geometricConstructor.service;

import by.sazanchuk.geometricConstructor.model.Picture;
import by.sazanchuk.geometricConstructor.model.dto.GroupDTO;
import by.sazanchuk.geometricConstructor.model.dto.PictureDTO;
import by.sazanchuk.geometricConstructor.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class PictureServiceImpl {

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private GroupServiceImpl groupService;

    public Picture save(Picture picture) {
        LocalDateTime now = LocalDateTime.now();
        picture.setLastEditDate(now);

        Long id = picture.getId();

        if (isNull(id) || !pictureRepository.existsById(id)) {
            picture.setCreationDate(now);
        }

        return pictureRepository.save(picture);
    }

    public boolean delete(Long id) {
        if (pictureRepository.existsById(id)) {
            pictureRepository.deleteById(id);

            return true;
        }

        return false;
    }

    public List<PictureDTO> findAllSortedByLastEditDateDesc() {

        List<Picture> pictures = pictureRepository.findAllByOrderByLastEditDateDesc();

        List<PictureDTO> dto = convertToDTO(pictures);
        dto = fillDTOWithGroups(dto);

        return dto;
    }

    public List<PictureDTO> findAll() {
        List<Picture> pictures = pictureRepository.findAll();

        List<PictureDTO> dto = convertToDTO(pictures);
        dto = fillDTOWithGroups(dto);

        return dto;
    }

    private List<PictureDTO> convertToDTO(List<Picture> pictures) {
        return pictures.stream()
                .map(Picture::toDTO)
                .collect(Collectors.toList());
    }

    private List<PictureDTO> fillDTOWithGroups(List<PictureDTO> dto) {
        dto
                .forEach(pictureDTO -> {
                    List<GroupDTO> groups = groupService.findAllByPictureId(pictureDTO.getId());
                    pictureDTO.setGroups(groups);
                });

        return dto;
    }

}
