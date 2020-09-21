package by.sazanchuk.geometricConstructor.service;

import by.sazanchuk.geometricConstructor.model.Group;
import by.sazanchuk.geometricConstructor.model.Picture;
import by.sazanchuk.geometricConstructor.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class PictureServiceImpl {

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private GroupServiceImpl groupService;

    public Picture save (Picture picture) {
        LocalDateTime now = LocalDateTime.now();
        picture.setLastEditDate(now);

        Long id = picture.getId();

        if (isNull(id) || !pictureRepository.existsById(id)) {
            picture.setCreationDate(now);
        }

        return pictureRepository.save(picture);
    }

    public boolean delete (Long id) {
        if (pictureRepository.existsById(id)) {
            pictureRepository.deleteById(id);

            return true;
        }

        return false;
    }

    public List<Picture> findAllSortedByLastEditDateDesc () {
        return pictureRepository.findAllByOrderByLastEditDateDesc();
    }

    public List<Picture> findAll () {
        List<Picture> pictures = pictureRepository.findAll();

        pictures
                .forEach(picture -> {
                    List<Group> groups = groupService.findAllByPictureId(picture.getId());
                    picture.setGroups(groups);
                });

        return pictures;
    }

}
