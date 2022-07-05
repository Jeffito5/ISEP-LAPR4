package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Luís Araújo
 */
public class BarcodeTest {
    /**
     * Instance of Barcode
     */
    Barcode barcode = new Barcode("B1");

    /**
     * Test that verifies if the barcode is the same
     */
    @Test
    public void barcode() {
        //Assert
        assertEquals("B1", barcode.barcode());
    }
}