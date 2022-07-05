package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class ShortDescriptionTest {
    /**
     * Instance of ShortDescription
     */
    ShortDescription shortDescription=new ShortDescription("SD1");

    /**
     * Test that verifies if the shortDescription is the same
     */
    @Test
    public void shortDescription() {
        //Assert
        assertEquals("SD1", shortDescription.shortDescription());
    }
}