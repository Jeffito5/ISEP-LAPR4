package eapli.base.reportmanagement.domain;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class ReportTimeIntervalTest {

    /**
     * Method that tests the method that verifies if one date is in the interval of the two preivous dates
     */
    @Test
    public void inInterval() {
        //Arrange
        Date firstDate = new Date("22/05/2022");
        Date secondDate = new Date("24/05/2022");
        ReportTimeInterval reportTimeInterval = new ReportTimeInterval(firstDate, secondDate);
        //Assert
        assertTrue(reportTimeInterval.inInterval(new Date("23/05/2022")));
    }

    /**
     * Test that verifies if a certain timer interval is valid
     * @throws ParseException
     */
    @Test
    public void validReportTimeIntervalTest() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date firstDate = formatter.parse("22/05/2022");
        Date secondDate = formatter.parse("23/05/2022");
        ReportTimeInterval reportTimeInterval = new ReportTimeInterval(firstDate, secondDate);
        assertEquals("[22/05/2022] - [23/05/2022]", reportTimeInterval.toString());
    }
}