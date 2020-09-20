package by.sazanchuk.geometricConstructor.model.figure;

import by.sazanchuk.geometricConstructor.model.Figure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Circle extends Figure {

    @Column(name = "border_type")
    @Enumerated(EnumType.STRING)
    private CircleBorderType borderType;
}
