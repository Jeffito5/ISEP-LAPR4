package eapli.base.surveymanagement.domain.survey;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static eapli.base.surveymanagement.domain.survey.SurveyCode.CODE_MAX_LENGTH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SurveyCodeTest {

    @Test
    public void validCodeTest() {
        SurveyCode code = new SurveyCode("123test");
        assertEquals(code.code(), "123test");
    }

    @Test
    public void nullCodeTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new SurveyCode(null));
        assertEquals("ERROR: Survey Code cannot be null!", exception.getMessage());
    }

    @Test
    public void emptyCodeTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new SurveyCode(""));
        assertEquals("ERROR: Survey Code cannot be empty!", exception.getMessage());
    }

    @Test
    public void blankCodeTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new SurveyCode(" "));
        assertEquals("ERROR: Survey Code cannot be empty!", exception.getMessage());
    }

    @Test
    public void notAlphanumericCodeTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new SurveyCode("test."));
        assertEquals("ERROR: Survey Code has non-alphanumeric characters!", exception.getMessage());
    }

    String random = RandomStringUtils.random(CODE_MAX_LENGTH + 1, true, true);
    String random2 = RandomStringUtils.random(CODE_MAX_LENGTH - 1, true, true);

    @Test
    public void tooBigCodeTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new SurveyCode(random));
        assertEquals("ERROR: Survey Code must have a total of " + CODE_MAX_LENGTH + " characters!", exception.getMessage());
    }

    @Test
    public void maxLimitCodeTest() {
        SurveyCode code = new SurveyCode(String.valueOf(random2));
        assertEquals(code.code(), random2);
    }

}
