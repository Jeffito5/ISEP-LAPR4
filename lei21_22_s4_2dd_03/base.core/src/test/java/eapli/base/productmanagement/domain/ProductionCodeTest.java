package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class ProductionCodeTest {
    /**
     * Instance of ProductionCode
     */
    ProductionCode productionCode=new ProductionCode("PC1");

    /**
     * Test that verifies if the productionCode is the same
     */
    @Test
    public void productionCode() {
        //Assert
        assertEquals("PC1", productionCode.productionCode());
    }
}