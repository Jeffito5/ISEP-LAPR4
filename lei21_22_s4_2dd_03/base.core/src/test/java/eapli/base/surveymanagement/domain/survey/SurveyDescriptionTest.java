package eapli.base.surveymanagement.domain.survey;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static eapli.base.surveymanagement.domain.survey.SurveyDescription.DESCRIPTION_MAX_LENGTH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SurveyDescriptionTest {

    @Test
    public void validDescriptionTest() {
        SurveyDescription description = new SurveyDescription("123test");
        assertEquals(description.description(), "123test");
    }

    @Test
    public void nullDescriptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new SurveyDescription(null));
        assertEquals("ERROR: Survey Description cannot be null!", exception.getMessage());
    }

    @Test
    public void emptyDescriptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new SurveyDescription(""));
        assertEquals("ERROR: Survey Description cannot be empty!", exception.getMessage());
    }

    @Test
    public void blankDescriptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new SurveyDescription(" "));
        assertEquals("ERROR: Survey Description cannot be empty!", exception.getMessage());
    }

    String random = RandomStringUtils.random(DESCRIPTION_MAX_LENGTH + 1, true, true);
    String random2 = RandomStringUtils.random(DESCRIPTION_MAX_LENGTH - 1, true, true);

    @Test
    public void tooBigDescriptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new SurveyDescription(random));
        assertEquals("ERROR: Survey Description must have a total of " + DESCRIPTION_MAX_LENGTH + " characters!", exception.getMessage());
    }

    @Test
    public void maxLimitDescriptionTest() {
        SurveyDescription description = new SurveyDescription(String.valueOf(random2));
        assertEquals(description.description(), random2);
    }

}
