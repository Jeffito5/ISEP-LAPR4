package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class TechnicalDescriptionTest {
    /**
     * Instance of TechnicalDescription
     */
    TechnicalDescription technicalDescription=new TechnicalDescription("TD1");

    /**
     * Test that verifies if the technicalDescription is the same
     */
    @Test
    public void technicalDescription() {
        //Assert
        assertEquals("TD1", technicalDescription.technicalDescription());
    }
}