package by.sazanchuk.geometricConstructor.controller;

import by.sazanchuk.geometricConstructor.model.Group;
import by.sazanchuk.geometricConstructor.model.Picture;
import by.sazanchuk.geometricConstructor.service.GroupServiceImpl;
import by.sazanchuk.geometricConstructor.service.PictureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pictures")
public class PictureController {
    @Autowired
    private PictureServiceImpl pictureService;

    @Autowired
    private GroupServiceImpl groupService;

    @GetMapping(value = "/sorted")
    public List<Picture> findAllPicturesSorted() {
        return pictureService.findAllSortedByLastEditDateDesc();
    }


    @GetMapping(value = "/all")
    public Group findAllPictures() {
        Group group = groupService.findById(new Long(1));
        return group;
    }

    @GetMapping(value = "/{id}/groups")
    public List<Group> findAllGroupsByPicture(@PathVariable Long id) {
        return groupService.findAllByPictureId(id);
    }
}
