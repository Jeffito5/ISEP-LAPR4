package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatusTest {

    @Test
    public void valueOfStatusValid() {
        assertNotEquals(Status.valueOf("Free").toString(),"Status{status='Free'}");
        assertEquals(Status.valueOf("Charging").toString(),"The current AGV status is: CHARGING.");
        assertEquals(Status.valueOf("Occupied").toString(),"The current AGV status is: OCCUPIED.");
        assertEquals(Status.valueOf("Maintenance").toString(),"The current AGV status is: MAINTENANCE.");
    }

    @Test
    public void valueOfStatusBlank() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Status.valueOf(""));
        assertEquals("Invalid status.",exception.getMessage());
    }

    @Test
    public void valueOfStatusOther() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Status.valueOf("asdasd"));
        assertEquals("Invalid status.",exception.getMessage());
    }
}