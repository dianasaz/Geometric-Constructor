package by.sazanchuk.geometricConstructor.model;

import by.sazanchuk.geometricConstructor.model.dto.FigureDTO;
import by.sazanchuk.geometricConstructor.model.dto.GroupDTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    private char symbol;

    @Column(name = "color")
    private String color;

    @JoinColumn(name="group_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Group group;

    public FigureDTO toDTO() {
        return new FigureDTO(this.id, this.figureType, this.borderType, this.symbol, this.color, this.group);
    }
}
