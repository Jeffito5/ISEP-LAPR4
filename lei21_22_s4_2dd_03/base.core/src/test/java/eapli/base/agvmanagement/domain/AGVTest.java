package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Luís Araújo
 */
public class AGVTest {
    /**
     * Instance of MaxWeight
     */
    MaxWeight maxWeight = MaxWeight.valueOf(100);
    /**
     * Instance of Volume
     */
    Volume volume = Volume.valueOf(50);
    /**
     * Instance of Status
     */
    Status status = Status.valueOf("Free");
    /**
     * Instance of docker
     */
    String docker = "3";
    /**
     * Instance of Autonomy
     */
    Autonomy autonomy = Autonomy.valueOf(1);
    /**
     * Instance of Identifier
     */
    Identifier identifier1 = Identifier.valueOf("00000001");
    /**
     * Instance of Description
     */
    Description description = Description.valueOf("empty");
    /**
     * Instance of Model
     */
    Model model = Model.valueOf("Model 0");
    /**
     * Instance of Model
     */
    Speed speed = Speed.valueOf(10);
    /**
     * Instance of AGV
     */
    AGV agv1 = AGV.valueOf(maxWeight, volume, status, docker, autonomy, identifier1, description, model,speed);

    /**
     * Test that tests the method that returns the identifier
     */
    @Test
    public void identifier() {
        //Assert
        assertEquals("00000001", agv1.identifier().identifier());
    }

    /**
     * Test that tests the method that returns the status in a String
     */
    @Test
    public void status() {
        //Assert
        assertEquals("FREE", agv1.status());
    }

    /**
     * Test that tests the method that returns the status
     */
    @Test
    public void agvStatus() {
        //Assert
        assertEquals("FREE", agv1.agvStatus().status());
    }

    /**
     * Test that tests the method that returns the autonomy
     */
    @Test
    public void autonomy() {
        //Assert
        assertEquals(1, agv1.autonomy());
    }

    /**
     * Test that tests the method that returns the coordinates
     */
    @Test
    public void coordinates() {
        //Assert
        assertNull(agv1.coordinates());
    }

    /**
     * Test that tests the method that returns the maxWeight
     */
    @Test
    public void maxWeight() {
        //Assert
        assertEquals(100, agv1.maxWeight());
    }

    /**
     * Test that tests the method that returns the volume
     */
    @Test
    public void volume() {
        //Assert
        assertEquals(50, agv1.volume());
    }
}