package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.surveymanagement.domain.Answer;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Section;
import eapli.base.surveymanagement.domain.survey.Survey;
import eapli.base.surveymanagement.domain.survey.SurveyCode;
import eapli.base.surveymanagement.repositories.AnswerRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lombok.SneakyThrows;

import javax.naming.OperationNotSupportedException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Luís Araújo
 */
public class JpaAnswerRepository extends JpaAutoTxRepository<Answer, String, String> implements AnswerRepository {

    public JpaAnswerRepository(final TransactionalContext transactionalContext) {
        super(transactionalContext, "id");
    }

    public JpaAnswerRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public Optional<Answer> ofIdentity(Long id) {
        return Optional.empty();
    }

    @SneakyThrows
    @Override
    public void deleteOfIdentity(Long entityId) {
        throw new OperationNotSupportedException("ERROR: Operation not supported yet!");
    }

    @Override
    public int numberOfResponsesObtained(SurveyCode surveyCode) {
        List<Answer> answerList = new ArrayList<>();

        for (Answer answer : findAll()) {
            if (answer.survey().code().code().equals(surveyCode.code()))
                answerList.add(answer);
        }
        return answerList.size();
    }

    @Override
    public List<Answer> findAnswersWithQuestionsOfFT(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = new ArrayList<>();

        for (Answer answer : findAll()) {
            if (answer.survey().code().code().equals(surveyCode.code()) && answer.question().questionId().equals(question.questionId()))
                answerList.add(answer);
        }

        return answerList;
    }

    @Override
    public List<Answer> findAnswersWithQuestionsOfNumeric(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = new ArrayList<>();

        for (Answer answer : findAll()) {
            if (answer.survey().code().code().equals(surveyCode.code()) && answer.question().questionId().equals(question.questionId()))
                answerList.add(answer);
        }

        return answerList;
    }

    @Override
    public List<Answer> findAnswersWithQuestionsOfSC(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = new ArrayList<>();

        for (Answer answer : findAll()) {
            if (answer.survey().code().code().equals(surveyCode.code()) && answer.question().questionId().equals(question.questionId()))
                answerList.add(answer);
        }

        return answerList;
    }

    @Override
    public List<Answer> findAnswersWithQuestionsOfSCIV(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = new ArrayList<>();

        for (Answer answer : findAll()) {
            if (answer.survey().code().code().equals(surveyCode.code()) && answer.question().questionId().equals(question.questionId()))
                answerList.add(answer);
        }

        return answerList;
    }

    @Override
    public List<Answer> findAnswersWithQuestionsOfMC(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = new ArrayList<>();

        for (Answer answer : findAll()) {
            if (answer.survey().code().code().equals(surveyCode.code()) && answer.question().questionId().equals(question.questionId()))
                answerList.add(answer);
        }

        return answerList;
    }

    @Override
    public List<Answer> findAnswersWithQuestionsOfMCIV(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = new ArrayList<>();

        for (Answer answer : findAll()) {
            if (answer.survey().code().code().equals(surveyCode.code()) && answer.question().questionId().equals(question.questionId()))
                answerList.add(answer);
        }

        return answerList;
    }

    @Override
    public List<Answer> findAnswersWithQuestionsOfSorting(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = new ArrayList<>();

        for (Answer answer : findAll()) {
            if (answer.survey().code().code().equals(surveyCode.code()) && answer.question().questionId().equals(question.questionId()))
                answerList.add(answer);
        }

        return answerList;
    }

    @Override
    public List<Answer> findAnswersWithQuestionsOfScaling(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = new ArrayList<>();

        for (Answer answer : findAll()) {
            if (answer.survey().code().code().equals(surveyCode.code()) && answer.question().questionId().equals(question.questionId()))
                answerList.add(answer);
        }

        return answerList;
    }

    @Override
    public List<Answer> findAnswerByAttributes(Customer customer, Survey survey, Section section, Question question) {
        Query query = entityManager().createQuery(
                "SELECT a FROM Answer a WHERE (a.customer = ?1 AND a.survey = ?2 AND a.section = ?3 AND a.question = ?4)");
        query.setParameter(1,customer);
        query.setParameter(2,survey);
        query.setParameter(3,section);
        query.setParameter(4,question);

        return query.getResultList();
    }
}
