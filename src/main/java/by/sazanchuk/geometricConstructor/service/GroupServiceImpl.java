package by.sazanchuk.geometricConstructor.service;

import by.sazanchuk.geometricConstructor.model.Group;
import by.sazanchuk.geometricConstructor.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl {
    @Autowired
    private CircleServiceImpl circleService;

    @Autowired
    private SquareServiceImpl squareService;

    @Autowired
    private TriangleServiceImpl triangleService;

    @Autowired
    private GroupRepository groupRepository;

    public Group save (Group group) {
        return groupRepository.save(group);
    }

    public List<Group> findAllByPictureId (Long pictureId) {
        return groupRepository.findAllByPictureId(pictureId);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group findById (Long id) {
        return groupRepository.findById(id).get();
    }
}
