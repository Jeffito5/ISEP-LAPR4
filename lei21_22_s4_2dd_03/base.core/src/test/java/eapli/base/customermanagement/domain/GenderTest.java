package eapli.base.customermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenderTest {

    @Test
    void valueOfGenderValid() {
        assertEquals(Gender.valueOf("Male").toString(),"Gender{gender='Male'}");
        assertEquals(Gender.valueOf("Female").toString(),"Gender{gender='Female'}");
        assertEquals(Gender.valueOf("Other").toString(),"Gender{gender='Other'}");
    }

    @Test
    void valueOfGenderBlank() {
        assertEquals(Gender.valueOf("").toString(),"Gender{gender=''}");
    }


    @Test
    void valueOfGenderString() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Gender.valueOf("qqqqq"));
        assertEquals("Invalid gender.",exception.getMessage());
    }
}