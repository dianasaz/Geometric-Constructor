package by.sazanchuk.geometricConstructor.controller;

import by.sazanchuk.geometricConstructor.model.dto.PictureDTO;
import by.sazanchuk.geometricConstructor.service.exception.NoEntityException;
import by.sazanchuk.geometricConstructor.service.PictureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/pictures")
public class PictureController {

    @Autowired
    private PictureServiceImpl pictureService;

    @GetMapping(value = "/sorted")
    public List<PictureDTO> findAllPicturesSorted() {
        return pictureService.findAllSortedByLastEditDateDesc();
    }

    @GetMapping()
    public List<PictureDTO> findAllPictures() {
        return pictureService.findAll();
    }

    @PostMapping
    public PictureDTO savePicture (@Valid @RequestBody PictureDTO pictureDTO) {
        return pictureService.save(pictureDTO);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deletePicture(@PathVariable Long id) throws NoEntityException {
        return pictureService.delete(id);
    }

    @PutMapping
    public PictureDTO updatePicture  (@RequestBody PictureDTO pictureDTO) {
        return pictureService.save(pictureDTO);
    }
}
