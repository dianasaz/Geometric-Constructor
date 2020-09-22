package by.sazanchuk.geometricConstructor.model.dto;

import by.sazanchuk.geometricConstructor.model.IllustrationMethod;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class GroupDTO implements Serializable {
    private Long id;

    @NonNull
    private int orderNumber;

    private List<GroupDTO> groups;

    private List<FigureDTO> figures;

    @NonNull
    private IllustrationMethod illustrationMethod;

    @JsonIgnore
    private GroupDTO rootGroup;

    public GroupDTO(Long id, int orderNumber, IllustrationMethod illustrationMethod) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.figures = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.illustrationMethod = illustrationMethod;
    }

    public GroupDTO(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GroupDTO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", groups=" + groups +
                ", figures=" + figures +
                ", illustrationMethod=" + illustrationMethod +
                '}';
    }
}
