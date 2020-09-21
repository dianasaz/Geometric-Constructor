package by.sazanchuk.geometricConstructor.model.dto;

import by.sazanchuk.geometricConstructor.model.Group;
import by.sazanchuk.geometricConstructor.model.Picture;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class PictureDTO implements Serializable {

    private Long id;

    private String title;

    private LocalDateTime creationDate;

    private LocalDateTime lastEditDate;

    private List<GroupDTO> groups;

    public PictureDTO(Long id, String title, LocalDateTime creationDate, LocalDateTime lastEditDate) {
        this.id = id;
        this.title = title;
        this.creationDate = creationDate;
        this.lastEditDate = lastEditDate;
    }
//
//    public Picture toEntity() {
//        Picture picture = new Picture();
//
//        picture.setGroups(this.groups);
//        picture.setCreationDate(this.creationDate);
//        picture.setLastEditDate(this.lastEditDate);
//        picture.setId(this.id);
//        picture.setTitle(this.title);
//
//        return picture;
//    }
}
