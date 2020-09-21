package by.sazanchuk.geometricConstructor.model.dto;

import by.sazanchuk.geometricConstructor.model.Group;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PictureDTO {
    private Long id;

    private String title;

    private LocalDateTime creationDate;

    private LocalDateTime lastEditDate;

    private List<Group> groups;
}
