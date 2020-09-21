package by.sazanchuk.geometricConstructor.repository;

import by.sazanchuk.geometricConstructor.model.Component;
import by.sazanchuk.geometricConstructor.model.Figure;
import by.sazanchuk.geometricConstructor.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FigureRepository extends JpaRepository<Figure, Long> {

    List<Figure> findAllByGroupId (Long groupId);
}
