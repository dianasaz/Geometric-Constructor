package by.sazanchuk.geometricConstructor.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @JoinColumn(name = "picture_id")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    protected Picture picture;

    @Column(name = "order_number")
    protected int orderNumber;
}
