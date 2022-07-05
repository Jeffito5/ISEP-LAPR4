package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Embeddable
public class Speed implements ValueObject, Serializable {

    private int speed;

    protected Speed() {
    }

    protected Speed(int speed) {
        ruleSpeed(speed);
        this.speed = speed;
    }

    /**
     * new constructor
     *
     * @param speed speed
     * @return speed
     */
    public static Speed valueOf(int speed) {
        return new Speed(speed);
    }

    /**
     * speed rule
     *
     * @param speed speed
     */
    private void ruleSpeed(int speed) {
        if (speed <= 0)
            throw new IllegalArgumentException("Speed invalid");
    }

    /**
     * Returns the volume
     *
     * @return volume
     */
    public int speed() {
        return this.speed;
    }

    @Override
    public String toString() {
        return "Speed{" +
                "speed=" + speed +
                '}';
    }
}