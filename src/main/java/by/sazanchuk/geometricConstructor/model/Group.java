package by.sazanchuk.geometricConstructor.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group_table")
public class Group extends Component {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rootGroup")
    private Group rootGroup;

    @OneToMany(mappedBy = "rootGroup")
    private Set<Group> groups = new HashSet<>();
}
