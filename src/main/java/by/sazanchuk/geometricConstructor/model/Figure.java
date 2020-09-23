package by.sazanchuk.geometricConstructor.model;

import by.sazanchuk.geometricConstructor.model.dto.FigureDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "figure")
@NoArgsConstructor
public class Figure extends Component{

    @Column(name = "figure_type")
    @Enumerated(EnumType.STRING)
    private FigureType figureType;

    @Column(name = "border_type")
    @Enumerated(EnumType.STRING)
    private CircleBorderType borderType;

    @Column(name = "symbol")
    private Character symbol;

    @Column(name = "color")
    private String color;

    @JoinColumn(name="group_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Group group;

    public Figure(Picture picture, FigureType figureType, Group group) {
        this.picture = picture;
        this.figureType = figureType;
        this.group = group;
    }

    public FigureDTO toDTO() {
        return new FigureDTO(this.id, this.figureType, this.borderType, this.symbol, this.color);
    }
}
