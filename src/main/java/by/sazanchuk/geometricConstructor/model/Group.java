package by.sazanchuk.geometricConstructor.model;

import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "group_table")
@NoArgsConstructor
public class Group extends Component {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rootGroup")
    private Group rootGroup;
//
//    @OneToMany(mappedBy = "rootGroup", cascade = CascadeType.ALL)
//    private Set<Group> groups = new HashSet<>();
}
