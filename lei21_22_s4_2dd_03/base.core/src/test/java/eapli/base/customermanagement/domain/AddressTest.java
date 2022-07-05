package eapli.base.customermanagement.domain;

import eapli.base.countrymanagement.domain.Country;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    Country country= Country.valueOf("Portugal");

    @Test
    void valueOfAddressValid() {
        assertEquals(Address.valueOf("Rua 25 de Abril",4,"4745-109","Porto",country).toString(),"Address{streetName='Rua 25 de Abril', doorNumber=4, postalCode='4745-109', city='Porto', country=Country{name='PORTUGAL'}}");
    }

    @Test
    void valueOfStreetNameBlank() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Address.valueOf("",4,"4745-109","Porto",country));
        assertEquals("Insert Street Name.",exception.getMessage());
    }

    @Test
    void valueOfPostalCodeBlank() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Address.valueOf("aa",4,"","Porto",country));
        assertEquals("Insert postal code.",exception.getMessage());
    }

    @Test
    void valueOfCityBlank() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Address.valueOf("a",4,"4745-109","",country));
        assertEquals("Insert City name.",exception.getMessage());
    }

    @Test
    void valueOfDoorNumberLower0() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Address.valueOf("a",-1,"4745-109","Porto",country));
        assertEquals("Door Number is invalid.",exception.getMessage());
    }

    @Test
    void valueOfDoorNumberGreater1000() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Address.valueOf("a",1001,"4745-109","Porto",country));
        assertEquals("Door Number is invalid.",exception.getMessage());
    }


}