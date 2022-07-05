package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class ProductMeasurementsTest {
    /**
     * Instance of ProductMeasurements
     */
    ProductMeasurements productMeasurements=new ProductMeasurements(1, 1, 1, 10.0, 10.0, 10.0, 10.0);

    /**
     * Test that verifies if the aisleID is the same
     */
    @Test
    public void aisleID() {
        //Assert
        assertEquals(1, productMeasurements.aisleID());
    }

    /**
     * Test that verifies if the aisle id is in the correct format
     */
    @Test
    public void ruleAisleID() {
        //Act
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    ProductMeasurements productMeasurements = new ProductMeasurements();
                    productMeasurements.ruleAisleID(-1);
                }
        );

        //Assert
        assertEquals("Aisle ID cannot be less or equal to 0.", exception.getMessage());
    }

    /**
     * Test that verifies if the rowID is the same
     */
    @Test
    public void rowID() {
        //Assert
        assertEquals(1, productMeasurements.rowID());
    }

    /**
     * Test that verifies if the row id is in the correct format
     */
    @Test
    public void ruleRowID() {
        //Act
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    ProductMeasurements productMeasurements = new ProductMeasurements();
                    productMeasurements.ruleRowID(-1);
                }
        );

        //Assert
        assertEquals("Row ID cannot be less or equal to 0.", exception.getMessage());
    }

    /**
     * Test that verifies if the shelfID is the same
     */
    @Test
    public void shelfID() {
        //Assert
        assertEquals(1, productMeasurements.shelfID());
    }

    /**
     * Test that verifies if the shelf id is in the correct format
     */
    @Test
    public void ruleShelfID() {
        //Act
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    ProductMeasurements productMeasurements = new ProductMeasurements();
                    productMeasurements.ruleShelfID(-1);
                }
        );

        //Assert
        assertEquals("Shelf ID cannot be less or equal to 0.", exception.getMessage());
    }

    /**
     * Test that verifies if the width is the same
     */
    @Test
    public void width() {
        //Assert
        assertEquals(10.0, productMeasurements.width());
    }

    /**
     * Test that verifies if the width is in the correct format
     */
    @Test
    public void ruleWidth() {
        //Act
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    ProductMeasurements productMeasurements = new ProductMeasurements();
                    productMeasurements.ruleWidth(-1);
                }
        );

        //Assert
        assertEquals("Width cannot be less or equal to 0.", exception.getMessage());
    }

    /**
     * Test that verifies if the length is the same
     */
    @Test
    public void length() {
        //Assert
        assertEquals(10.0, productMeasurements.length());
    }

    /**
     * Test that verifies if the length is in the correct format
     */
    @Test
    public void ruleLength() {
        //Act
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    ProductMeasurements productMeasurements = new ProductMeasurements();
                    productMeasurements.ruleLength(-1);
                }
        );

        //Assert
        assertEquals("Length cannot be less or equal to 0.", exception.getMessage());
    }

    /**
     * Test that verifies if the height is the same
     */
    @Test
    public void height() {
        //Assert
        assertEquals(10.0, productMeasurements.height());
    }

    /**
     * Test that verifies if the height is in the correct format
     */
    @Test
    public void ruleHeight() {
        //Act
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    ProductMeasurements productMeasurements = new ProductMeasurements();
                    productMeasurements.ruleHeight(-1);
                }
        );

        //Assert
        assertEquals("Height cannot be less or equal to 0.", exception.getMessage());
    }

    /**
     * Test that verifies if the weight is the same
     */
    @Test
    public void weight() {
        //Assert
        assertEquals(10.0, productMeasurements.weight());
    }

    /**
     * Test that verifies if the weight is in the correct format
     */
    @Test
    public void ruleWeight() {
        //Act
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    ProductMeasurements productMeasurements = new ProductMeasurements();
                    productMeasurements.ruleWeight(-1);
                }
        );

        //Assert
        assertEquals("Weight cannot be less or equal to 0.", exception.getMessage());
    }
}