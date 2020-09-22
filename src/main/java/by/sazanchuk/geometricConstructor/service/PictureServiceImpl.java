package by.sazanchuk.geometricConstructor.service;

import by.sazanchuk.geometricConstructor.model.Group;
import by.sazanchuk.geometricConstructor.model.Picture;
import by.sazanchuk.geometricConstructor.model.dto.GroupDTO;
import by.sazanchuk.geometricConstructor.model.dto.PictureDTO;
import by.sazanchuk.geometricConstructor.repository.PictureRepository;
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
    public PictureDTO save (PictureDTO dto) {
        Picture picture = null;
        LocalDateTime now = LocalDateTime.now();

        if (!isNull(dto.getId()) && pictureRepository.existsById(dto.getId())) {
            picture = pictureRepository.findById(dto.getId()).get();
        }
        else {
            picture = new Picture();
            picture.setCreationDate(now);
        }

        picture.setTitle(dto.getTitle());
        picture.setLastEditDate(now);

        picture = pictureRepository.save(picture);

        if (!isNull(dto.getGroups()) && !dto.getGroups().isEmpty()) {
            groupService.saveAll(dto.getGroups(), picture);
        }

        return picture.toDTO();
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

        List<PictureDTO> dto = convertToDTO(pictures);
        dto = fillDTOWithGroups(dto);

        return dto;
    }

    @Transactional
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
