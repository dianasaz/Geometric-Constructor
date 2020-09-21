package by.sazanchuk.geometricConstructor.repository;

import by.sazanchuk.geometricConstructor.model.Picture;
import by.sazanchuk.geometricConstructor.model.dto.PictureDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

//    @Query(nativeQuery = true, value = "select p.id as id, p.title as title, p.create_on as creationDate, p.edit_on as lastEditDate from picture p order by p.edit_on desc")
    List<Picture> findAllByOrderByLastEditDateDesc();

}
