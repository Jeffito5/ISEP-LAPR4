package eapli.base.ordermanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class IdentifierTest {
    /**
     * Instance of identifier
     */
    Identifier identifier= Identifier.valueOf(1);

    /**
     * Test that tests the method that returns the identifier
     */
    @Test
    public void identifier() {
        //Assert
        assertEquals(1, identifier.identifier());
    }
}