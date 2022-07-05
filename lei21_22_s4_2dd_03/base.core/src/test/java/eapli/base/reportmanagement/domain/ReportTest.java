package eapli.base.reportmanagement.domain;

import org.junit.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class ReportTest {
    /**
     * Instance of reportID
     */
    ReportId reportId = new ReportId("1");
    /**
     * Two dates of the report
     */
    Date date1 = new Date("24/02/2021");
    Date date2 = new Date("25/02/2021");
    ReportTimeInterval firstDate = new ReportTimeInterval(date1, date2);
    /**
     * Report's information
     */
    String data = "data";
    /**
     * Instance of report
     */
    Report report = new Report(reportId, firstDate, null, data);

    /**
     * Method that tests the method that returns the reportID
     */
    @Test
    public void reportId() {
        //Assert
        assertEquals(reportId, report.reportId());
    }
}