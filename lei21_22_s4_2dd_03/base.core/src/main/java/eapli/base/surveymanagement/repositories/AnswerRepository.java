package eapli.base.surveymanagement.repositories;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.surveymanagement.domain.Answer;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.Section;
import eapli.base.surveymanagement.domain.survey.Survey;
import eapli.base.surveymanagement.domain.survey.SurveyCode;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

/**
 * @author Luís Araújo
 */
public interface AnswerRepository extends DomainRepository<Long, Answer> {
    int numberOfResponsesObtained(SurveyCode surveyCode);

    List<Answer> findAnswersWithQuestionsOfFT(SurveyCode surveyCode, Question question);

    List<Answer> findAnswersWithQuestionsOfNumeric(SurveyCode surveyCode, Question question);

    List<Answer> findAnswersWithQuestionsOfSC(SurveyCode surveyCode, Question question);

    List<Answer> findAnswersWithQuestionsOfSCIV(SurveyCode surveyCode, Question question);

    List<Answer> findAnswersWithQuestionsOfMC(SurveyCode surveyCode, Question question);

    List<Answer> findAnswersWithQuestionsOfMCIV(SurveyCode surveyCode, Question question);

    List<Answer> findAnswersWithQuestionsOfSorting(SurveyCode surveyCode, Question question);

    List<Answer> findAnswersWithQuestionsOfScaling(SurveyCode surveyCode, Question question);

    List<Answer> findAnswerByAttributes(Customer customer, Survey survey, Section section, Question question);

}
