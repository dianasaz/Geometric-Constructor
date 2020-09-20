package by.sazanchuk.geometricConstructor.model.figure;

import by.sazanchuk.geometricConstructor.model.Figure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Triangle extends Figure {

    @Column(name = "color")
    private String color;
}
