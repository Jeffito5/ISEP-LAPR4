package eapli.base.agvmanagement.domain;

import eapli.base.customermanagement.domain.BirthDate;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VolumeTest {

    @Test
    public void valueOfVolumeValid() {
        assertEquals(Volume.valueOf(14).toString(),"Volume{volume=14.0}");
    }

    @Test
    public void valueOfVolumeInvalid() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Volume.valueOf(-1));
        assertEquals("Volume invalid",exception.getMessage());
    }
}