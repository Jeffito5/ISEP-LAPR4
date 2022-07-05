package eapli.base.customermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void valueOfNameValid() {
        assertEquals(Name.valueOf("Lucas","Guimarães").toString(),"Name{firstName='Lucas', lastName='Guimarães'}");
    }

    @Test
    void valueOfFirstNameBlank() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Name.valueOf("","a"));
        assertEquals("Insert name.",exception.getMessage());
    }

    @Test
    void valueOfLastNameBlank() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Name.valueOf("a",""));
        assertEquals("Insert name.",exception.getMessage());
    }



}