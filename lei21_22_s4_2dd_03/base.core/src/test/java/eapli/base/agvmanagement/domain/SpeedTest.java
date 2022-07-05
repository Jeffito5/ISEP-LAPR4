package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SpeedTest {

    @Test
    public void valueOfSpeedValid() {
        assertEquals(Speed.valueOf(14).toString(),"Speed{speed=14}");
    }

    @Test
    public void valueOfSpeedInvalid() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Speed.valueOf(-1));
        assertEquals("Speed invalid",exception.getMessage());
    }
}
