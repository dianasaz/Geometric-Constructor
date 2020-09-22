package by.sazanchuk.geometricConstructor.repository;

import by.sazanchuk.geometricConstructor.model.Figure;
import by.sazanchuk.geometricConstructor.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FigureRepository extends JpaRepository<Figure, Long> {

    List<Figure> findAllByGroupId (Long groupId);

    void deleteAllByPicture (Picture picture);
}
