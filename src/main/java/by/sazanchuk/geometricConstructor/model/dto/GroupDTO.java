package by.sazanchuk.geometricConstructor.model.dto;

import by.sazanchuk.geometricConstructor.model.Component;
import by.sazanchuk.geometricConstructor.model.Picture;
import lombok.Data;

import java.util.List;

@Data
public class GroupDTO {
    private Long id;

    private Picture picture;

    private int orderNumber;

    private List<Component>

}
