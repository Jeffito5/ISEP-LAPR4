package eapli.base.customermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VATTest {

    @Test
    void valueOfVATValid() {
        assertEquals(VAT.valueOf("vatadadadadadad").toString(),"VAT{vat='vatadadadadadad'}");
    }

    @Test
    void valueOfVATBlank() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> VAT.valueOf(""));
        assertEquals("Invalid VAT.",exception.getMessage());
    }

    @Test
    void valueOfVATLenght() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> VAT.valueOf("a"));
        assertEquals("Invalid VAT.",exception.getMessage());
    }
}