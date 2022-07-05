package eapli.base.customermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelephoneTest {

    @Test
    void valueOfTelephoneValid() {
        assertEquals(Telephone.valueOf("+741",963258741).toString(),"Telephone{countryIndetification='+741', phoneNumber=963258741}");
    }

    @Test
    void valueOfCIBlank() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Telephone.valueOf("",741288963));
        assertEquals("Country Indentification invalid.",exception.getMessage());
    }

    @Test
    void valueOfCILenght() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Telephone.valueOf("+741258",741288963));
        assertEquals("Country Indentification invalid.",exception.getMessage());
    }

    @Test
    void valueOfCISignal() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Telephone.valueOf("7415",741288963));
        assertEquals("Country Indentification invalid.",exception.getMessage());
    }

    @Test
    void valueOfCINumbers() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Telephone.valueOf("+ada",741288963));
        assertEquals("Country Indentification invalid.",exception.getMessage());
    }

    @Test
    void valueOfPHLenghtMore() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Telephone.valueOf("+741",1000000000));
        assertEquals("Phone number invalid.",exception.getMessage());
    }

    @Test
    void valueOfPHLenghtLess() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Telephone.valueOf("+741",10000000));
        assertEquals("Phone number invalid.",exception.getMessage());
    }
}