package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class InternalCodeTest {
    /**
     * Instance of InternalCode
     */
    InternalCode internalCode=new InternalCode("IC1");

    /**
     * Test that verifies if the internalCode is the same
     */
    @Test
    public void internalCode() {
        //Assert
        assertEquals("IC1", internalCode.internalCode());
    }
}