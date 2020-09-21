package by.sazanchuk.geometricConstructor.repository;

import by.sazanchuk.geometricConstructor.model.figure.Triangle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriangleRepository extends JpaRepository<Triangle, Long>  {
}
