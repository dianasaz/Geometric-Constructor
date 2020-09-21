package by.sazanchuk.geometricConstructor.model.dto;

import by.sazanchuk.geometricConstructor.model.Component;
import by.sazanchuk.geometricConstructor.model.Figure;
import by.sazanchuk.geometricConstructor.model.Group;
import by.sazanchuk.geometricConstructor.model.Picture;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class GroupDTO implements Serializable {
    private Long id;

    private int orderNumber;

    private List<GroupDTO> groups;

    private List<FigureDTO> figures;

    public GroupDTO(Long id, int orderNumber) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.figures = new ArrayList<>();
        this.groups = new ArrayList<>();
    }
}
