package eapli.base.reportmanagement.application;

import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.reportmanagement.auxiliary.ReportPercentagesCalculator;
import eapli.base.reportmanagement.domain.Report;
import eapli.base.reportmanagement.domain.ReportId;
import eapli.base.reportmanagement.domain.ReportTimeInterval;
import eapli.base.reportmanagement.mapper.ReportMapper;
import eapli.base.reportmanagement.mapper.dto.ReportDTO;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Section;
import eapli.base.surveymanagement.domain.survey.Survey;
import eapli.base.surveymanagement.domain.survey.SurveyCode;
import eapli.base.surveymanagement.dto.SurveyDTO;
import eapli.base.surveymanagement.mapper.SurveyMapper;
import eapli.base.surveymanagement.repositories.SurveyRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Luís Araújo
 */
public class SeeReportController {
    /**
     * Instance of SurveyRepository
     */
    private final SurveyRepository surveyRepository;

    /**
     * Instance of SurveyMapper
     */
    private final SurveyMapper surveyMapper;

    /**
     * Instance of ReportPercentagesCalculator
     */
    private final ReportPercentagesCalculator reportPercentagesCalculator;

    /**
     * Instance of ReportMapper
     */
    private final ReportMapper reportMapper;

    /**
     * Constructor that initializes all variables
     */
    public SeeReportController() {
        surveyRepository = PersistenceContext.repositories().surveys();
        surveyMapper = new SurveyMapper();
        reportPercentagesCalculator = new ReportPercentagesCalculator();
        reportMapper = new ReportMapper();
    }

    /**
     * Method that finds all surveys and converts them to SurveyDTO
     *
     * @return all surveys and converts them to SurveyDTO
     */
    public List<SurveyDTO> findSurveys() {
        JpaRepository<Survey, Serializable> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        return surveyMapper.toDTO(repo.findAll());
    }

    /**
     * Method that calculates all percentages of the survey to do the report and returns the instance of a report
     * converted to DTO
     *
     * @param surveyCode
     * @param firstDate
     * @param secondDate
     * @param id
     * @return instance of a report converted to DTO
     */
    public ReportDTO calculateReportPercentages(SurveyCode surveyCode, Date firstDate, Date secondDate, String id) {
        reportPercentagesCalculator.universeSizeOfSurvey(surveyCode);
        reportPercentagesCalculator.numberOfResponsesObtained(surveyCode);
        reportPercentagesCalculator.percentageOfResponsesObtained(surveyCode);

        List<Section> sectionList = new ArrayList<>();
        List<Question> questionList = new ArrayList<>();
        Survey surveyAux = surveyRepository.findSurveyByCode(surveyCode);

        Questionnaire questionnaireAux = surveyAux.questionnaire();

        for (Section section : questionnaireAux.sections())
            sectionList.add(section);

        for (Section section : sectionList) {
            for (Question question : section.questions())
                questionList.add(question);
        }

        reportPercentagesCalculator.calculatePercentages(surveyCode, questionList);
        reportPercentagesCalculator.writeAllDataOfTheReport();
        String data = reportPercentagesCalculator.toString();
        ReportId reportId = new ReportId(id);
        ReportTimeInterval reportTimeInterval = new ReportTimeInterval(firstDate, secondDate);
        Report report = new Report(reportId, reportTimeInterval, surveyAux, data);
        return reportMapper.toDTO(report);
    }
}
