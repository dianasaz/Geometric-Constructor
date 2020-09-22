package by.sazanchuk.geometricConstructor.model.dto;

import by.sazanchuk.geometricConstructor.model.CircleBorderType;
import by.sazanchuk.geometricConstructor.model.FigureType;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Transient;
import java.io.Serializable;

@Data
public class FigureDTO implements Serializable {

    private Long id;

    @NonNull
    private FigureType figureType;

    private CircleBorderType borderType;

    private char symbol;

    private String color;

    @Transient
    private GroupDTO rootGroup;

    public FigureDTO(Long id, @NonNull FigureType figureType, CircleBorderType borderType, char symbol, String color) {
        this.id = id;
        this.figureType = figureType;
        this.borderType = borderType;
        this.symbol = symbol;
        this.color = color;
    }
}
