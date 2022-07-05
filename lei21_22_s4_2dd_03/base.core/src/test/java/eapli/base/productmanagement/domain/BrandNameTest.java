package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class BrandNameTest {
    /**
     * Instance of BrandName
     */
    BrandName brandName=new BrandName("BN1");

    /**
     * Test that verifies if the brandName is the same
     */
    @Test
    public void brandName() {
        //Assert
        assertEquals("BN1", brandName.brandName());
    }
}