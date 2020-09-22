package by.sazanchuk.geometricConstructor.model;

import by.sazanchuk.geometricConstructor.model.dto.FigureDTO;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "figure")
public class Figure extends Component{

    @Column(name = "figure_type")
    @Enumerated(EnumType.STRING)
    private FigureType figureType;

    @Column(name = "border_type")
    @Enumerated(EnumType.STRING)
    private CircleBorderType borderType;

    @Column(name = "symbol")
    @Pattern(regexp = "#[0-9a-fA-F]{6}",
            message = "Color must be in HEX format")
    private char symbol;

    @Column(name = "color")
    @Pattern(regexp = "[0-9a-zA-Zа-яФ-Я]{1}",
            message = "Should be one symbol")
    private String color;

    @JoinColumn(name="group_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Group group;

    public FigureDTO toDTO() {
        return new FigureDTO(this.id, this.figureType, this.borderType, this.symbol, this.color);
    }
}
