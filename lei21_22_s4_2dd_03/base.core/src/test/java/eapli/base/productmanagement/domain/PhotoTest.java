package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class PhotoTest {
    /**
     * Instance of Photo
     */
    Photo photo=new Photo("P1");

    /**
     * Test that verifies if the photo is the same
     */
    @Test
    public void path() {
        //Assert
        assertEquals("P1", photo.path());
    }
}