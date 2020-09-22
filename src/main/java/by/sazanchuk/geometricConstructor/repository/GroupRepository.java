package by.sazanchuk.geometricConstructor.repository;

import by.sazanchuk.geometricConstructor.model.Group;
import by.sazanchuk.geometricConstructor.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Group> findAllByPictureIdAndRootGroupIsNull (Long pictureId);

    Optional<Group> findById (Long id);

    List<Group> findAllByRootGroupId (Long groupId);

    void deleteAllByPicture (Picture picture);
}
