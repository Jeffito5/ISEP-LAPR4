package eapli.base.categorymanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DescriptionTest {

    @Test
    public void validDescriptionTest() {
        eapli.base.categorymanagement.domain.Description description = new Description("Category's description");
        assertEquals(description.toString(), "Description: " + "Category's description");
    }

    @Test
    public void blankDescriptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Description(""));
        assertEquals("Description should neither be null nor empty.", exception.getMessage());
    }

    @Test
    public void nullDescriptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Description(null));
        assertEquals("Description should neither be null nor empty.", exception.getMessage());
    }

    @Test
    public void tooBigDescriptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Description("111111111111111111111111111111111111111111122222222222222222222222222222aaaaaaaaaaaaaaaa"));
        assertEquals("Description should have a minimum of 20 chars and 50 chars maximum.", exception.getMessage());
    }

    @Test
    public void tooShortDescriptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Description("11aa"));
        assertEquals("Description should have a minimum of 20 chars and 50 chars maximum.", exception.getMessage());
    }
}
