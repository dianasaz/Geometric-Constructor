package by.sazanchuk.geometricConstructor.service;

import by.sazanchuk.geometricConstructor.model.Picture;
import by.sazanchuk.geometricConstructor.model.dto.GroupDTO;
import by.sazanchuk.geometricConstructor.model.dto.PictureDTO;
import by.sazanchuk.geometricConstructor.repository.PictureRepository;
import by.sazanchuk.geometricConstructor.service.exception.NoEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public PictureDTO save(PictureDTO dto) {
        Picture picture;
        LocalDateTime now = LocalDateTime.now();

        if (!isNull(dto.getId()) && pictureRepository.existsById(dto.getId())) {
            picture = pictureRepository.findById(dto.getId()).get();
        } else {
            picture = new Picture();
            picture.setCreationDate(now);
        }

        picture.setTitle(dto.getTitle());
        picture.setLastEditDate(now);

        picture = pictureRepository.save(picture);

        if (!isNull(dto.getGroups()) && !dto.getGroups().isEmpty()) {
            groupService.saveAll(dto.getGroups(), picture);
        }

        PictureDTO pictureDTO = picture.toDTO();
        fillDTOWithGroups(pictureDTO);

        return pictureDTO;
    }

    @Transactional
    public boolean delete(Long pictureId) throws NoEntityException {
        if (!isNull(pictureId) && pictureRepository.existsById(pictureId)) {
            Picture picture = pictureRepository.findById(pictureId).orElseThrow(() -> new NoEntityException("No such picture"));
            groupService.removeAllByPicture(picture);
            pictureRepository.delete(picture);

            return true;
        }

        return false;
    }

    @Transactional
    public List<PictureDTO> findAllSortedByLastEditDateDesc() {
        List<Picture> pictures = pictureRepository.findAllByOrderByLastEditDateDesc();

        List<PictureDTO> dto = toDTO(pictures);
        fillDTOWithGroups(dto);

        return dto;
    }

    @Transactional
    public List<PictureDTO> findAll() {
        List<Picture> pictures = pictureRepository.findAll();

        List<PictureDTO> dto = toDTO(pictures);
        dto = fillDTOWithGroups(dto);

        return dto;
    }

    private List<PictureDTO> toDTO(List<Picture> pictures) {
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

    private PictureDTO fillDTOWithGroups(PictureDTO dto) {
        List<GroupDTO> groups = groupService.findAllByPictureId(dto.getId());
        dto.setGroups(groups);
        return dto;
    }
}
