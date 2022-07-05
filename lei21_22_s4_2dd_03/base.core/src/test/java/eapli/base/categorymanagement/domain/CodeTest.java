package eapli.base.categorymanagement.domain;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CodeTest {

    @Test
    public void validCodeTest() {
       Code code = new Code("code123");
        assertEquals(code.toString(), "Code: " + "code123");
    }

    @Test
    public void blankCodeTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Code(""));
        assertEquals("Code should be alphanumeric, not null nor empty.", exception.getMessage());
    }

    @Test
    public void nullCodeTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Code(null));
        assertEquals("Code should be alphanumeric, not null nor empty.", exception.getMessage());
    }

    @Test
    public void tooBigCodeTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Code("aaaaaaaaaaaaaaaa111111111"));
        assertEquals("Code should have 10 chars maximum.", exception.getMessage());
    }

    @Test
    public void notAlphanumericCodeTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Code("-------"));
        assertEquals("Code should be alphanumeric, not null nor empty.", exception.getMessage());
    }
}
