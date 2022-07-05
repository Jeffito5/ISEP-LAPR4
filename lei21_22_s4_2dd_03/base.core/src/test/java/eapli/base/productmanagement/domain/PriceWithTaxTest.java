package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class PriceWithTaxTest {
    /**
     * Instance of PriceWithTax
     */
    PriceWithTax priceWithTax=new PriceWithTax(10.0);

    /**
     * Test that verifies if the priceWithTax is the same
     */
    @Test
    public void priceWithTax() {
        //Assert
        assertEquals(10.0, priceWithTax.priceWithTax());
    }
}