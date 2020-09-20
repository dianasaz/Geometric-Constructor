package by.sazanchuk.geometricConstructor.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorColumn(name = "figure_type")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Figure extends Component{

    @JoinColumn(name="group_id")
    @ManyToOne
    private Group group;
}
