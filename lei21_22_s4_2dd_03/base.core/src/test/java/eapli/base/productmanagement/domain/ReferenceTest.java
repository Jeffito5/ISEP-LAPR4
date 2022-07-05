package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class ReferenceTest {
    /**
     * Instance of Reference
     */
    Reference reference=new Reference("R1");

    /**
     * Test that verifies if the reference is the same
     */
    @Test
    public void reference() {
        //Assert
        assertEquals("R1", reference.reference());
    }
}