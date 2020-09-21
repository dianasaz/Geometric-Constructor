package by.sazanchuk.geometricConstructor.model.dto;

import by.sazanchuk.geometricConstructor.model.CircleBorderType;
import by.sazanchuk.geometricConstructor.model.FigureType;
import by.sazanchuk.geometricConstructor.model.Group;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class FigureDTO implements Serializable {

    private Long id;

    @NonNull
    private FigureType figureType;

    private CircleBorderType borderType;

    private char Symbol;

    private String color;

    @NonNull
    private Group group;

    public FigureDTO(Long id, @NonNull FigureType figureType, CircleBorderType borderType, char symbol, String color, @NonNull Group group) {
        this.id = id;
        this.figureType = figureType;
        this.borderType = borderType;
        Symbol = symbol;
        this.color = color;
        this.group = group;
    }
}
