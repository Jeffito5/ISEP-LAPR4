package eapli.base.reportmanagement.domain;

import eapli.base.surveymanagement.domain.survey.Survey;

import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * @author Luís Araújo
 */
public class Report implements Serializable {
    /**
     * Instance of ReportId
     */
    private final ReportId reportId;
    /**
     * Instance of ReportTimeInterval
     */
    private final ReportTimeInterval reportTimeInterval;
    /**
     * Instance of Survey
     */
    @OneToOne
    private final Survey survey;
    /**
     * Data of the report
     */
    private final String data;

    /**
     * Constructor that initializes all the variables
     *
     * @param reportId
     * @param reportTimeInterval
     * @param survey
     * @param data
     */
    public Report(ReportId reportId, ReportTimeInterval reportTimeInterval, Survey survey, String data) {
        this.reportId = reportId;
        this.reportTimeInterval = reportTimeInterval;
        this.survey = survey;
        this.data = data;
    }

    /**
     * Method that returns the report id
     *
     * @return report id
     */
    public ReportId reportId() {
        return reportId;
    }

    @Override
    public String toString() {
        return "\nREPORT INFORMATION:\n" +
                "ID: " + reportId + "\n" +
                reportTimeInterval + "\n" +
                "Survey Code: " + survey.identity() + "\n" +
                "Data: \n" + data + "\n";
    }
}
