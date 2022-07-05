package eapli.base.surveymanagement.domain.survey;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeIntervalTest {

    @Test
    public void validTimeIntervalTest() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date firstDate = formatter.parse("22/05/2022");
        Date secondDate = formatter.parse("23/05/2022");
        TimeInterval timeInterval = new TimeInterval(firstDate, secondDate);
        assertEquals("[22/05/2022] - [23/05/2022]", timeInterval.toString());
    }

    @Test
    public void firstDateAfterSecondDateTest() {
        Date firstDate = new Date("24/05/2022");
        Date secondDate = new Date("23/05/2022");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new TimeInterval(firstDate, secondDate));
        assertEquals("Error: First date cannot be after the second!", exception.getMessage());
    }

    @Test
    public void firstDateEqualToSecondDateTest() {
        Date firstDate = new Date("24/05/2022");
        Date secondDate = new Date("24/05/2022");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new TimeInterval(firstDate, secondDate));
        assertEquals("Error: The two dates cannot be the same!", exception.getMessage());
    }
}
