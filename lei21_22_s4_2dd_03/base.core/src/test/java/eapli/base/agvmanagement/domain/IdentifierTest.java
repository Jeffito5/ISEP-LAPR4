package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IdentifierTest {

    @Test
    public void valueOfIdentifierValid() {
        assertEquals(Identifier.valueOf("adad123").toString(),"Identifier{identifier='adad123'}");
    }

    @Test
    public void valueOfIdentifierBlank() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Identifier.valueOf(""));
        assertEquals("Invalid identifier.",exception.getMessage());
    }

    @Test
    public void valueOfIdentifierLenght() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Identifier.valueOf("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertEquals("Invalid identifier lenght.",exception.getMessage());
    }

    @Test
    public void valueOfIdentifierAlphanumeric() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Identifier.valueOf("ad12+-/"));
        assertEquals("Identifier must be Alphanumeric.",exception.getMessage());
    }
}