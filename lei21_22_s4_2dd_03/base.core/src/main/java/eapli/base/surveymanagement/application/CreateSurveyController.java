package eapli.base.surveymanagement.application;

import eapli.base.categorymanagement.mapper.dto.CategoryDTO;
import eapli.base.categorymanagement.mapper.CategoryMapper;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.Code;
import eapli.base.countrymanagement.domain.Country;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.domain.events.UpdatedOrderToDeliveredEvent;
import eapli.base.ordermanagement.mapper.dto.OrderDTO;
import eapli.base.productmanagement.mapper.dto.ProductDTO;
import eapli.base.productmanagement.mapper.ProductMapper;
import eapli.base.productmanagement.domain.BrandName;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.base.surveymanagement.builders.SurveyBuilder;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.survey.Survey;
import eapli.base.surveymanagement.domain.survey.TargetType;
import eapli.base.surveymanagement.dto.QuestionnaireDTO;
import eapli.base.surveymanagement.dto.SurveyDTO;
import eapli.base.surveymanagement.eventhandlers.NewSurveyEvent;
import eapli.base.surveymanagement.mapper.QuestionnaireMapper;
import eapli.base.surveymanagement.mapper.SurveyMapper;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;

import javax.naming.directory.InvalidAttributesException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Author: Guilherme Sencadas - 1201180
 */

public class CreateSurveyController {

    /**
     * Creates a new instance of Survey
     * @param code             Survey Code to be used
     * @param description      Survey Description to be used
     * @param targetAudience   Survey Target Type to be used
     * @param codes            Survey List of codes for the Target Audience. Contains a list of brands or categories or products etc.
     * @param targetFirstDate  Defines the Time Interval for the Target Audience
     * @param targetSecondDate Defines the Time Interval for the Target Audience
     * @param firstDate        First Date of the Time Interval
     * @param secondDate       Second Date of the Time Interval
     * @param dto              Questionnaire to be used by the Survey
     * @return An instance of SurveyDTO with the new Survey's toString()
     * @throws InvalidAttributesException Thrown by SurveyBuilder
     */
    public SurveyDTO createSurvey(String code, String description,
                                  TargetType targetAudience, List<String> codes, Date targetFirstDate, Date targetSecondDate, Date firstDate, Date secondDate,
                                  QuestionnaireDTO dto) throws InvalidAttributesException {

        Questionnaire questionnaire = convertDTO(dto);

        SurveyBuilder builder = new SurveyBuilder(true);

        Survey survey = builder
                .withCode(code)
                .withDescription(description)
                .withTargetAudience(targetAudience, codes, targetFirstDate, targetSecondDate)
                .withTimeInterval(firstDate, secondDate)
                .withQuestionnaire(questionnaire)
                .withAudience(PersistenceContext.repositories().customers().findByTarget(builder.targetAudience))
                .build();

        JpaRepository<Survey, Long> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        repo.add(survey);
        publishEvent(survey);
        return new SurveyMapper().toDTO(survey);
    }

    /**
     * Converts a QuestionnaireDTO into a Questionnaire
     * <p>
     * Searches for the Questionnaire ID within the DataBase
     *
     * @param questionnaire QuestionnaireDTO with the needed information.
     * @return Questionnaire stored in the database with the given ID
     */
    public Questionnaire convertDTO(QuestionnaireDTO questionnaire) {
        JpaRepository<Questionnaire, Long> questionRepo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        return questionRepo.findById(questionnaire.id);
    }

    /**
     * Searches the DataBase to get the list of questionnaires and converts them all into QuestionnaireDTO
     *
     * @return List with the converted Questionnaires
     */
    public List<QuestionnaireDTO> getQuestionnaires() {
        JpaRepository<Questionnaire, Long> questionRepo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };

        List<QuestionnaireDTO> questionnaires = new ArrayList<>();

        QuestionnaireMapper mapper = new QuestionnaireMapper();
        for (Questionnaire questionnaire : questionRepo.findAll())
            questionnaires.add(mapper.toDTO(questionnaire));

        return questionnaires;
    }

    /**
     * Converts the values of the ENUM TargetType into a list
     *
     * @return List with all TargetType's values.
     */
    public List<TargetType> targetTypeList() {
        return Arrays.asList(TargetType.values());
    }

    /**
     * Searches the DataBase for every Category and converts them all into CategoryDTO
     *
     * @return List with all CategoryDTO
     */
    public List<CategoryDTO> categories() {
        JpaRepository<Category, Code> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        return new CategoryMapper().toDTO(repo.findAll());
    }

    /**
     * Searches the DataBase for every Product and converts them into ProductDTO.
     *
     * @return List with all ProductDTO
     */
    public List<ProductDTO> products() {
        JpaRepository<Product, InternalCode> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        return new ProductMapper().basicToDTO(repo.findAll());
    }

    /**
     * Searches the DataBase for every Country and stores only their names.
     *
     * @return List with all Country names.
     */
    public List<String> countries() {
        JpaRepository<Country, Long> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        List<Country> countries = repo.findAll();
        List<String> names = new ArrayList<>();
        for (Country country : countries) {
            names.add(country.name());
        }
        return names;
    }

    /**
     * Searches the DataBase for every Brand and stores their names.
     *
     * @return List with all the Brand names.
     */
    public List<String> brands() {
        List<String> result = new ArrayList<>();

        for (BrandName brandName : PersistenceContext.repositories().products().findBrands())
            result.add(brandName.brandName());

        return result;
    }

    /**
     * Creates a List with all supported Genders
     *
     * @return List with all Genders
     */
    public List<String> genders() {
        List<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        genders.add("Other");
        return genders;
    }

    public void publishEvent(Survey survey){
        final DomainEvent event = new NewSurveyEvent(survey);
        InProcessPubSub.publisher().publish(event);
    }
}
