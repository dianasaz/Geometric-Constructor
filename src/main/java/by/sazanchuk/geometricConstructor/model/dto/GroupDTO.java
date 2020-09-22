package by.sazanchuk.geometricConstructor.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Transient;
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

    @Transient
    private GroupDTO rootGroup;

    public GroupDTO(Long id, int orderNumber) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.figures = new ArrayList<>();
        this.groups = new ArrayList<>();
    }
}
