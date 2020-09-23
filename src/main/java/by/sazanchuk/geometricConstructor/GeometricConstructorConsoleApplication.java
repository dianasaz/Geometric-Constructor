package by.sazanchuk.geometricConstructor;

import by.sazanchuk.geometricConstructor.model.CircleBorderType;
import by.sazanchuk.geometricConstructor.model.FigureType;
import by.sazanchuk.geometricConstructor.model.IllustrationMethod;
import by.sazanchuk.geometricConstructor.model.dto.FigureDTO;
import by.sazanchuk.geometricConstructor.model.dto.GroupDTO;
import by.sazanchuk.geometricConstructor.model.dto.PictureDTO;
import by.sazanchuk.geometricConstructor.service.PictureServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
@Log
public class GeometricConstructorConsoleApplication implements CommandLineRunner {
    @Autowired
    final private PictureServiceImpl pictureService;

    public static void main(String[] args) {
        SpringApplication.run(GeometricConstructorConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        FigureDTO circle = new FigureDTO(null, FigureType.CIRCLE, CircleBorderType.DASHED, null, null);
        FigureDTO triangle = new FigureDTO(null, FigureType.TRIANGLE, null, null, "#386646");
        List<FigureDTO> figureDTOS = new ArrayList<>();
        figureDTOS.add(circle);
        figureDTOS.add(triangle);

        GroupDTO rootGroup = new GroupDTO(null, 1, IllustrationMethod.COLUMN);
        GroupDTO group = new GroupDTO(null, 1, IllustrationMethod.LINE);
        group.setRootGroup(rootGroup);

        PictureDTO picture = new PictureDTO(null, "title", null, null);

        group.setFigures(figureDTOS);

        List<GroupDTO> groupDTOS = new ArrayList<GroupDTO>();
        groupDTOS.add(group);

        rootGroup.setGroups(groupDTOS);
        List<GroupDTO> rootGroups = new ArrayList<>();
        rootGroups.add(rootGroup);
        picture.setGroups(rootGroups);

        picture = pictureService.save(picture);

        log.info(picture.toString());
    }
}
