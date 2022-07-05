package eapli.base.surveymanagement.mapper;

import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.dto.QuestionnaireDTO;

/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class QuestionnaireMapper {

    public QuestionnaireDTO toDTO(Questionnaire questionnaire){
        return new QuestionnaireDTO(questionnaire.id(),questionnaire.toString());
    }
}
