package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class PriceWithoutTaxTest {
    /**
     * Instance of PriceWithoutTax
     */
    PriceWithoutTax priceWithoutTax=new PriceWithoutTax(10.0);

    /**
     * Test that verifies if the priceWithoutTax is the same
     */
    @Test
    public void priceWithoutTax() {
        //Assert
        assertEquals(10.0, priceWithoutTax.priceWithoutTax());
    }
}