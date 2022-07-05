package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DescriptionTest {

    @Test
    public void valueOfDescriptionValid() {
        assertEquals(Description.valueOf("adaddad").toString(),"Description{description='adaddad'}");
    }

    @Test
    public void valueOfDescriptionBlank() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Description.valueOf(""));
        assertEquals("Invalid description.",exception.getMessage());
    }

    @Test
    public void valueOfDescriptionLenght() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Description.valueOf("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertEquals("Invalid description lenght.",exception.getMessage());
    }
}