package eapli.base.surveymanagement.repositories;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.domain.Gender;
import eapli.base.surveymanagement.domain.survey.Survey;
import eapli.base.surveymanagement.domain.survey.SurveyCode;
import eapli.base.surveymanagement.domain.survey.TargetType;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Date;
import java.util.List;

public interface SurveyRepository extends DomainRepository<Long, Survey> {
    Survey findSurveyByCode(SurveyCode code);

    List<Survey> findSurveysByCustomer(Customer customer, Date date);

    int universeSizeOfSurvey(SurveyCode surveyCode);

    int numberOfQuestions(SurveyCode surveyCode);
}
