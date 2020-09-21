package by.sazanchuk.geometricConstructor.model;

import by.sazanchuk.geometricConstructor.model.dto.GroupDTO;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "group_table")
@NoArgsConstructor
public class Group extends Component {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rootGroup")
    private Group rootGroup;

    public GroupDTO toDTO() {
        return new GroupDTO(this.id, this.orderNumber);
    }
}
