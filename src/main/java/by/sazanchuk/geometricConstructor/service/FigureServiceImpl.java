package by.sazanchuk.geometricConstructor.service;

import by.sazanchuk.geometricConstructor.model.Figure;
import by.sazanchuk.geometricConstructor.model.Group;
import by.sazanchuk.geometricConstructor.model.dto.FigureDTO;
import by.sazanchuk.geometricConstructor.model.dto.GroupDTO;
import by.sazanchuk.geometricConstructor.repository.FigureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FigureServiceImpl {

    @Autowired
    private FigureRepository figureRepository;

    public List<FigureDTO> findAllByGroup(Long groupId) {
        List<Figure> figures = figureRepository.findAllByGroupId(groupId);

        return toDTO(figures);
    }

    private List<FigureDTO> toDTO(List<Figure> figures) {
        return figures.stream()
                .map(Figure::toDTO)
                .collect(Collectors.toList());
    }
}
