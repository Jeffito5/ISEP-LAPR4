package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {

    @Test
    public void valueOfModelValid() {
        assertEquals(Model.valueOf("adadd").toString(),"Model{model='adadd'}");
    }

    @Test
    public void valueOfModelBlank() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Model.valueOf(""));
        assertEquals("Invalid model.",exception.getMessage());
    }

    @Test
    public void valueOfModelLenght() {
        Exception exception=assertThrows(IllegalArgumentException.class,() -> Model.valueOf("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertEquals("Invalid model lenght.",exception.getMessage());
    }
}