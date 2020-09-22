package by.sazanchuk.geometricConstructor.model;

import by.sazanchuk.geometricConstructor.model.dto.PictureDTO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "create_on")
    private LocalDateTime creationDate;

    @Column(name = "edit_on")
    private LocalDateTime lastEditDate;

    @Transient
    private List<Group> groups;

    public PictureDTO toDTO() {
        PictureDTO dto = new PictureDTO();

        dto.setCreationDate(this.creationDate);
        dto.setLastEditDate(this.lastEditDate);
        dto.setTitle(this.title);
        dto.setId(this.id);

        return dto;
    }
}
