package by.sazanchuk.geometricConstructor.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @JoinColumn(name = "picture_id")
    @ManyToOne
    protected Picture picture;

    @Column(name = "order_number")
    protected int orderNumber;
}
