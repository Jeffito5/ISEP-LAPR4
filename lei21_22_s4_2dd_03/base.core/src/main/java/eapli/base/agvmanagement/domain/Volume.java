package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Embeddable
public class Volume implements ValueObject, Serializable {

    private double volume;

    protected Volume() {
    }

    protected Volume(double volume) {
        ruleVolume(volume);
        this.volume = volume;
    }

    /**
     * new constructor
     *
     * @param volume volume
     * @return volume
     */
    public static Volume valueOf(double volume) {
        return new Volume(volume);
    }

    /**
     * volume rule
     *
     * @param volume volume
     */
    private void ruleVolume(double volume) {
        if (volume <= 0)
            throw new IllegalArgumentException("Volume invalid");
    }

    /**
     * Returns the volume
     *
     * @return volume
     */
    public double volume() {
        return this.volume;
    }

    @Override
    public String toString() {
        return "Volume{" +
                "volume=" + volume +
                '}';
    }
}
