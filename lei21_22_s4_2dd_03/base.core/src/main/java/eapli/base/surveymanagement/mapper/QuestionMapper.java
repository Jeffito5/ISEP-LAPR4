package eapli.base.surveymanagement.mapper;

import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.dto.QuestionDTO;
import eapli.base.surveymanagement.dto.QuestionnaireDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class QuestionMapper {

    public QuestionDTO toDTO(Question question){
        return new QuestionDTO(question.questionId(),question.toString(),question.options());
    }

    public List<QuestionDTO> toDTO(List<Question> questions){
        List<QuestionDTO> result = new ArrayList<>();
        for (Question question : questions)
            result.add(toDTO(question));
        return result;
    }
}
