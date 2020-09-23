package by.sazanchuk.geometricConstructor.model.dto;

import by.sazanchuk.geometricConstructor.model.CircleBorderType;
import by.sazanchuk.geometricConstructor.model.FigureType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FigureDTO implements Serializable {

    private Long id;

    @NotNull
    private FigureType figureType;

    private CircleBorderType borderType;

    private Character symbol;

    private String color;

    @JsonIgnore
    private GroupDTO rootGroup;

    public FigureDTO(Long id, @NonNull FigureType figureType, CircleBorderType borderType, Character symbol, String color) {
        this.id = id;
        this.figureType = figureType;
        this.borderType = borderType;
        this.symbol = symbol;
        this.color = color;
    }

    @Override
    public String toString() {
        return "FigureDTO{" +
                "id=" + id +
                ", figureType=" + figureType +
                ", borderType=" + borderType +
                ", symbol=" + symbol +
                ", color='" + color +
                '}';
    }
}
