package by.sazanchuk.geometricConstructor.model;

import by.sazanchuk.geometricConstructor.model.dto.GroupDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "group_table")
@NoArgsConstructor
public class Group extends Component {

    @NonNull
    @Column(name = "illustration_method")
    @Enumerated(EnumType.STRING)
    private IllustrationMethod illustrationMethod;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "rootGroup")
    private Group rootGroup;

    public GroupDTO toDTO() {
        return new GroupDTO(this.id, this.orderNumber, this.illustrationMethod);
    }
}
