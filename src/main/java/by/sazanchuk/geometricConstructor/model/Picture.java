package by.sazanchuk.geometricConstructor.model;

import by.sazanchuk.geometricConstructor.model.converter.LocalDateTimeAttributeConverter;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "create_on")
    private LocalDateTime creationDate;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "edit_on")
    private LocalDateTime lastEditDate;
}
