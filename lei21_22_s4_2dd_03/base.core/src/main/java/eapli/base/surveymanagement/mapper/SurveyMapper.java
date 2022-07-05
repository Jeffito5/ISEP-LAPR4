package eapli.base.surveymanagement.mapper;

import eapli.base.surveymanagement.domain.survey.Survey;
import eapli.base.surveymanagement.dto.SurveyDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class SurveyMapper {

    public SurveyDTO toDTO(Survey survey){
        return new SurveyDTO(survey.id(),survey.toString());
    }

    public List<SurveyDTO> toDTO(List<Survey> surveys){
        List<SurveyDTO> result = new ArrayList<>();
        for (Survey survey : surveys){
            result.add(toDTO(survey));
        }
        return result;
    }
}
