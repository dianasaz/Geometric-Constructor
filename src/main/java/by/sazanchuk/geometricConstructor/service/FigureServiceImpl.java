package by.sazanchuk.geometricConstructor.service;

import by.sazanchuk.geometricConstructor.model.Figure;
import by.sazanchuk.geometricConstructor.model.Group;
import by.sazanchuk.geometricConstructor.model.Picture;
import by.sazanchuk.geometricConstructor.model.dto.FigureDTO;
import by.sazanchuk.geometricConstructor.repository.FigureRepository;
import by.sazanchuk.geometricConstructor.service.exception.NoEntityException;
import by.sazanchuk.geometricConstructor.service.exception.NotValidEntity;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Log
@Service
public class FigureServiceImpl {

    @Autowired
    private FigureRepository figureRepository;

    public List<FigureDTO> findAllByGroup(Long groupId) {
        List<Figure> figures = figureRepository.findAllByGroupId(groupId);

        return toDTO(figures);
    }

    @Transactional
    public void save(FigureDTO dto, Group group, Picture picture) throws NoEntityException, NotValidEntity {
        boolean isDTOValid = validate(dto);
        if (isDTOValid) {
            Figure figure = null;

            if (!isNull(dto.getId()) && figureRepository.existsById(dto.getId())) {
                figure = figureRepository.findById(dto.getId()).orElseThrow(() -> new NoEntityException("No group found"));
            } else {
                figure = new Figure(picture, dto.getFigureType(), group);
            }

            switch (figure.getFigureType()) {
                case CIRCLE:
                    figure.setBorderType(dto.getBorderType());
                    break;
                case SQUARE:
                    figure.setSymbol(dto.getSymbol());
                    break;
                case TRIANGLE:
                    figure.setColor(dto.getColor());
                    break;
            }

            figureRepository.save(figure);
        }
        else throw new NotValidEntity("Figure is not valid");
    }

    @Transactional
    public void saveAll (List<FigureDTO> figureDTOS, Group group, Picture picture) {
        figureDTOS
                .forEach(
                        figureDTO -> {
                            try {
                                save(figureDTO, group, picture);
                            } catch (NoEntityException e) {
                                log.info("No figure found with such id");
                            } catch (NotValidEntity notValidEntity) {
                               log.info("Not valid figure");
                            }
                        }
                );
    }

    @Transactional
    public void removeAllByPicture (Picture picture) {
        figureRepository.deleteAllByPicture(picture);
    }

    private List<FigureDTO> toDTO(List<Figure> figures) {
        return figures.stream()
                .map(Figure::toDTO)
                .collect(Collectors.toList());
    }

    private boolean validate (FigureDTO figure) {
        Pattern pattern;
        Matcher matcher;
        boolean result =  false;

        switch (figure.getFigureType()) {
            case TRIANGLE:
                pattern = Pattern.compile("^#[0-9a-fA-F]{6}$");
                matcher = pattern.matcher(figure.getColor());
                if (matcher.find()) result = true;
                break;
            case SQUARE:
                pattern = Pattern.compile("^[0-9A-Z]{1}$");
                matcher = pattern.matcher(figure.getSymbol().toString());
                if (matcher.find()) result = true;
                break;
            case CIRCLE:
                result = true;
        }

        return result;
    }
}
