package by.sazanchuk.geometricConstructor.repository;

import by.sazanchuk.geometricConstructor.model.figure.Square;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquareRepository extends JpaRepository<Square, Long>  {
}
