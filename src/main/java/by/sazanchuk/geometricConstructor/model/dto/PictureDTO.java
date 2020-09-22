package by.sazanchuk.geometricConstructor.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class PictureDTO implements Serializable {

    private Long id;

    @NonNull
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

}
