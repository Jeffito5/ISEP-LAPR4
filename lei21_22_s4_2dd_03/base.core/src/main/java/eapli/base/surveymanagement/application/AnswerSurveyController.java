package eapli.base.surveymanagement.application;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.Code;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.domain.Email;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.productmanagement.domain.BrandName;
import eapli.base.surveymanagement.builders.AnswerBuilder;
import eapli.base.surveymanagement.domain.*;
import eapli.base.surveymanagement.domain.survey.Survey;
import eapli.base.surveymanagement.domain.survey.SurveyCode;
import eapli.base.surveymanagement.dto.SurveyDTO;
import eapli.base.surveymanagement.grammar.answerverifier.AnswerValidator;
import eapli.base.surveymanagement.mapper.SurveyMapper;
import javax.naming.directory.InvalidAttributesException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

/**
 * Author: 1201180 - Guilherme Sencadas
 */

public class AnswerSurveyController {

    private Customer customer;

    public AnswerSurveyController() {

    }


    public AnswerSurveyController(String email) {
        this.customer = getCustomer(email);
    }

    private final RepositoryFactory repositoryFactory = PersistenceContext.repositories();

    /**Answers a previously exported survey
     * <p>
     *     Defines the current AnswerValidator.customer and validates the grammar
     *
     *
     * @param path Path to the exported survey file
     * @throws IOException Thrown by AnswerValidator.validate
     */
    public void answerSurvey(String path) throws IOException {
        AnswerValidator.customer = customer;
        new AnswerValidator(this).validate(path);
    }


    /**Exports a given survey to text file.
     *
     * @param option Index of the survey list
     * @return Path to the generated file
     * @throws IOException Thrown by FileWriter
     */
    public String exportSurvey(int option) throws IOException {
        List<SurveyDTO> list = getSurveys();
        SurveyDTO chosen = list.get(option);

        JpaRepository<Survey, Long> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        Survey survey = repo.findById(chosen.id);
        File file = new File("survey-" + survey.code().code() + ".txt");

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(survey.presentString());
        fileWriter.close();
        return file.getPath();
    }

    /**Gets the List of items to repeat the sections.
     * <p>Used to export the survey.<br>
     * Finds all the supported types and stores their names
     *
     * @param repeatability Given Section repeatability, stores all codes
     * @return List with all the Objects' names
     */
    public List<String> getRepeatabilityItems(Repeatability repeatability) {
        if (repeatability == Repeatability.NONE)
            return null;
        List<String> result = new ArrayList<>();
        switch (repeatability) {
            case BRAND:
                for (BrandName brandName : repositoryFactory.products().findBrands())
                    result.add(brandName.brandName());
                return result;

            case CATEGORY:
                JpaRepository<Category, Code> repo = new JpaRepository<>() {
                    @Override
                    protected String persistenceUnitName() {
                        return null;
                    }
                };
                for (Category category : repo.findAll()) {
                    result.add(category.code().valueOf());
                }
                return result;
            default:
                throw new UnsupportedOperationException("ERROR: Repeatability '" + repeatability + "' not supported!");
        }
    }

    /**Finds a survey by its code
     *
     * @param code Survey Code to be used in the search
     * @return Found entity of Survey
     */
    public Survey findSurvey(String code) {
        return repositoryFactory.surveys().findSurveyByCode(new SurveyCode(code));
    }

    /**Finds the Questionnaire associated to a given survey
     * <p> Compare if the provided code is the same associated to the survey
     * @param survey Survey associated to a questionnaire
     * @param code Questionnaire Code to compare
     * @return Instance of Questionnaire associated to a survey if found, else returns null
     */
    public Questionnaire findQuestionnaire(Survey survey, String code) {
        Questionnaire questionnaire = survey.questionnaire();
        if (questionnaire.questionnaireId().equals(code))
            return questionnaire;
        return null;
    }

    /**Finds a Section within a Questionnaire by a code
     * <p> Searches all the sections available in the Questionnaire and compare its code
     * @param questionnaire Questionnaire to use in the search
     * @param code Section Code to compare
     * @return Instance of Section associated to the questionnaire if found, else return null
     */
    public Section findSection(Questionnaire questionnaire, String code) {
        List<Section> sections = questionnaire.sections();

        for (Section section : sections) {
            if (section.sectionId().equals(code))
                return section;
        }
        return null;
    }


    /**Finds a Question within a Section by a code
     * <p> Searches all the questions available in the SEction and compare its code
     * @param section Section to use in the search
     * @param code Question Code to compare
     * @return Instance of Question associated to the section if found, else return null
     */

    public Question findQuestion(Section section, String code) {
        List<Question> questions = section.questions();

        for (Question question : questions) {
            if (question.questionId().equals(code))
                return question;
        }
        return null;
    }

    /**Finds all the available surveys to a given Customer
     *
     * @return List with all the SurveyDTO to show in the UI
     */
    public String getSurveysString() {
        StringBuilder sb = new StringBuilder();
        List<SurveyDTO> list = getSurveys();
        for (SurveyDTO dto : list){
            sb.append(dto.toString).append("//////////////\n");
        }
        return sb.toString();
    }

    public List<SurveyDTO> getSurveys(){
        return new SurveyMapper().toDTO((repositoryFactory.surveys().findSurveysByCustomer(customer, Calendar.getInstance().getTime())));
    }

    /**Cretes a new instance of Answer and stores it in the repository
     *
     * @param survey Survey being answered
     * @param section Section being answered
     * @param question Question being answered.
     * @param options List of options with either the answer text or the different selected options.
     * @return New instance of Answer
     * @throws InvalidAttributesException Thrown by AnswerBuilder
     */
    public Answer createAnswer(Survey survey, Section section, Question question, List<String> options) throws InvalidAttributesException {
        Answer answer = new AnswerBuilder(true).withSurvey(survey).withSection(section).withQuestion(question).withText(options).withCustomer(customer).build();
        if (answer!=null) {
            JpaRepository<Answer, Long> repo = new JpaRepository<>() {
                @Override
                protected String persistenceUnitName() {
                    return null;
                }
            };
            repo.add(answer);
        }
        return answer;
    }

    /**Finds a customer by it's Email Address
     *
     * @param emailAddress Customer's email
     * @return Instance of customer if found, null otherwise
     */
    public Customer getCustomer(String emailAddress) {
        Optional<Customer> customer = repositoryFactory.customers().findByEmail(Email.valueOf(emailAddress));
        return customer.orElse(null);
    }

    /**Finds if a given customer has already answered given question.
     *
     * @param customer Customer answering
     * @param survey Survey being answered
     * @param section Section being answered
     * @param question Question being answered
     * @return True if the customer has answered the question, False otherwise
     */
    public boolean hasAnswered(Customer customer, Survey survey, Section section, Question question){
        List<Answer> answers = repositoryFactory.answers().findAnswerByAttributes(customer,survey,section,question);
        return answers.size() > 0;
    }

}
