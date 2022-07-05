package eapli.base.ordermanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class OrderMeasurementsTest {
    /**
     * Instance of OrderMeasurements
     */
    OrderMeasurements orderMeasurements= OrderMeasurements.valueOf(10.0, 10.0, 10.0);

    /**
     * Test that tests the method that returns the volume
     */
    @Test
    public void volume() {
        //Assert
        assertEquals(10.0, orderMeasurements.volume());
    }

    /**
     * Test that tests the method that returns the maxWeight
     */
    @Test
    public void maxWeight() {
        //Assert
        assertEquals(10.0, orderMeasurements.maxWeight());
    }
}