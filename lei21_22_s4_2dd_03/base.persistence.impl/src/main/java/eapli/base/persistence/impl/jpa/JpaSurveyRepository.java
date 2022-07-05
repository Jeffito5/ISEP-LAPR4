package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.surveymanagement.domain.Section;
import eapli.base.surveymanagement.domain.survey.Survey;
import eapli.base.surveymanagement.domain.survey.SurveyCode;
import eapli.base.surveymanagement.repositories.SurveyRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lombok.SneakyThrows;

import javax.naming.OperationNotSupportedException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class JpaSurveyRepository extends JpaAutoTxRepository<Survey, String, String> implements SurveyRepository {

    public JpaSurveyRepository(final TransactionalContext transactionalContext) {
        super(transactionalContext, "id");
    }

    public JpaSurveyRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "id");
    }


    @Override
    public Survey findSurveyByCode(SurveyCode code) {
        Query query = entityManager().createQuery(
                "SELECT s FROM Survey s WHERE code = ?1");
        query.setParameter(1, code);
        return (Survey) query.getResultList().get(0);
    }

    @Override
    public List<Survey> findSurveysByCustomer(Customer customer, Date date) {
        List<Survey> surveys = new ArrayList<>();
        for (Survey survey : findAll()) {
            for (Customer findCustomer : survey.audience()) {
                if (survey.timeInterval().inInterval(date) && findCustomer.identity() == customer.identity() && !surveys.contains(survey)) {
                    surveys.add(survey);
                }
            }
        }
        return surveys;
    }

    @Override
    public Optional<Survey> ofIdentity(Long id) {
        return Optional.empty();
    }

    @SneakyThrows
    @Override
    public void deleteOfIdentity(Long entityId) {
        throw new OperationNotSupportedException("ERROR: Operation not supported yet!");
    }

    @Override
    public int universeSizeOfSurvey(SurveyCode surveyCode){
        return findSurveyByCode(surveyCode).audience().size();
    }

    @Override
    public int numberOfQuestions(SurveyCode surveyCode){
        Survey survey = findSurveyByCode(surveyCode);
        int size = 0;

        for(Section section : survey.questionnaire().sections()){
            size += section.questions().size();
        }

        return size;
    }
}
