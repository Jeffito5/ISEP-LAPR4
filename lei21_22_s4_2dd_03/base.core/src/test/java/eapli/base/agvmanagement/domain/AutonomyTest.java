package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutonomyTest {

    @Test
    public void valueOfAutonomyValid() {
        assertEquals(Autonomy.valueOf(789).toString(),"Autonomy{autonomy=789}");
    }

    @Test
    public void valueOfAutonomyInvalid() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Autonomy.valueOf(0));
        assertEquals("Autonomy invalid",exception.getMessage());
    }

}