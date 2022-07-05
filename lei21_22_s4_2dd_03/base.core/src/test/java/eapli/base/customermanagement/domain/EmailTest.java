package eapli.base.customermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void valueOfEmailBlank() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Email.valueOf(""));
        assertEquals("Email can't be null.",exception.getMessage());
    }

    @Test
    void valueOfEmailValid() {
        assertEquals(Email.valueOf("qqcoisa@gmail.com").toString(),"Email{email='qqcoisa@gmail.com'}");
    }

    @Test
    void valueOfEmailFormat1() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Email.valueOf("sadasdad"));
        assertEquals("Invalid format for email.",exception.getMessage());
    }

    @Test
    void valueOfEmailFormat2() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Email.valueOf("sadasdad@"));
        assertEquals("Invalid format for email.",exception.getMessage());
    }

    @Test
    void valueOfEmailFormat3() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Email.valueOf("sadasdad@asda"));
        assertEquals("Invalid format for email.",exception.getMessage());
    }

    @Test
    void valueOfEmailFormat4() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Email.valueOf("sadasdad@asdasd."));
        assertEquals("Invalid format for email.",exception.getMessage());
    }

    @Test
    void valueOfEmailFormat5() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Email.valueOf("@"));
        assertEquals("Invalid format for email.",exception.getMessage());
    }

    @Test
    void valueOfEmailFormat6() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Email.valueOf("@asdad"));
        assertEquals("Invalid format for email.",exception.getMessage());
    }

    @Test
    void valueOfEmailFormat7() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Email.valueOf("@adasd."));
        assertEquals("Invalid format for email.",exception.getMessage());
    }

    @Test
    void valueOfEmailFormat8() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Email.valueOf("@sadad.com"));
        assertEquals("Invalid format for email.",exception.getMessage());
    }

    @Test
    void valueOfEmailFormat9() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Email.valueOf("."));
        assertEquals("Invalid format for email.",exception.getMessage());
    }


    @Test
    void valueOfEmailFormat10() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Email.valueOf(".com"));
        assertEquals("Invalid format for email.",exception.getMessage());
    }


    @Test
    void valueOfEmailFormat11() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Email.valueOf("asdas."));
        assertEquals("Invalid format for email.",exception.getMessage());
    }

    @Test
    void valueOfEmailFormat12() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Email.valueOf("asdasd.com"));
        assertEquals("Invalid format for email.",exception.getMessage());
    }

}