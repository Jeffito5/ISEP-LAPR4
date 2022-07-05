package eapli.base.catalogmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Luís Araújo
 */
public class CatalogIdTest {
    /**
     * Instance of the id of the catalog
     */
    CatalogId catalogId = new CatalogId(1L);

    /**
     * Test that verifies if the id is the same
     */
    @Test
    public void id() {
        //Assert
        assertEquals(1L, catalogId.id());
    }
}