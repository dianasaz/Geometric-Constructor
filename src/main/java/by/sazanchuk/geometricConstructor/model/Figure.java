package by.sazanchuk.geometricConstructor.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Figure extends Component{

    @JoinColumn(name="group_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Group group;
}
