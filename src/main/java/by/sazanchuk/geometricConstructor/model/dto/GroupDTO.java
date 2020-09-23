package by.sazanchuk.geometricConstructor.model.dto;

import by.sazanchuk.geometricConstructor.model.IllustrationMethod;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class GroupDTO implements Serializable {
    private Long id;

    @NotNull
    private int orderNumber;

    private List<GroupDTO> groups;

    private List<FigureDTO> figures;

    @NotNull
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
