package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaxWeightTest {

    @Test
    public void valueOfMaxWeightValid() {
        assertEquals(MaxWeight.valueOf(412).toString(),"MaxWeight{maxWeight=412.0}");
    }

    @Test
    public void valueOfMaxWeightInvalid() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> MaxWeight.valueOf(-78));
        assertEquals("Max weight invalid",exception.getMessage());
    }

}