package eapli.base.customermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirthDateTest {


    @Test
    void valueOfBirthDateFuture() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> BirthDate.valueOf("21/06/2050"));
        assertEquals("Invalid date.",exception.getMessage());
    }

    @Test
    void valueOfBirthDateValid() {
        assertEquals(BirthDate.valueOf("21/06/2002").toString(),"BirthDate{birthDate='21/06/2002'}");
    }

    @Test
    void valueOfBirthDateBlank() {
        assertEquals(BirthDate.valueOf("").toString(),"BirthDate{birthDate=''}");
    }

    @Test
    void valueOfBirthDateFormat() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> BirthDate.valueOf("asdasdasd"));
        assertEquals("Invalid date format.",exception.getMessage());
    }


}