package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class ExtendedDescriptionTest {
    /**
     * Instance of ExtendedDescription
     */
    ExtendedDescription extendedDescription=new ExtendedDescription("ED1");

    /**
     * Test that verifies if the extendedDescription is the same
     */
    @Test
    public void extendedDescription() {
        //Assert
        assertEquals("ED1", extendedDescription.extendedDescription());
    }
}