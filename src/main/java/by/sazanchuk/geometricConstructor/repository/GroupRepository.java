package by.sazanchuk.geometricConstructor.repository;

import by.sazanchuk.geometricConstructor.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query(nativeQuery = true,  value = "select g.id, g.picture_id, g.root_group, g.order_number from group_table g where g.picture_id = :pictureId")
    List<Group> findAllByPictureId(Long pictureId);

    Optional<Group> findById(Long id);
}
