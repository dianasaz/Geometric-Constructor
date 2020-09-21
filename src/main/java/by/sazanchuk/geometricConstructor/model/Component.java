package by.sazanchuk.geometricConstructor.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @JoinColumn(name = "picture_id")
    @ManyToOne(cascade = CascadeType.ALL)
    protected Picture picture;

    @Column(name = "order_number")
    protected int orderNumber;
}
