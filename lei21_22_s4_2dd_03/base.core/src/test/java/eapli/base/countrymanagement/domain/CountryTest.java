package eapli.base.countrymanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountryTest {

    @Test
    void valueOfNameValid() {
        assertEquals(Country.valueOf("qweqwe").toString(),"Country{name='QWEQWE'}");
    }

    @Test
    void valueOfNameBlank(){
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Country.valueOf(""));
        assertEquals("Insert a Country name.",exception.getMessage());
    }
}