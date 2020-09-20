package by.sazanchuk.geometricConstructor.model.figure;

import by.sazanchuk.geometricConstructor.model.Figure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Square extends Figure {

    @Column(name = "symbol")
    private char Symbol;
}
