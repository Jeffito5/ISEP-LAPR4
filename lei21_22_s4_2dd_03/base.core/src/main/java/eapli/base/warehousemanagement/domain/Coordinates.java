package eapli.base.warehousemanagement.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Ana Rita Silva
 */
@Embeddable
public class Coordinates {

    private float length;
    private float width;

    /**
     * Represents the coordinates in the warehouse
     *
     * @param length horizontal coordinate
     * @param width  vertical coordinate
     */
    public Coordinates(String length, String width) {
        validateCoordinates(length, width);
    }

    /**
     * Empty constructor
     */
    public Coordinates() {

    }

    public float length() {
        return length;
    }

    public float width() {
        return width;
    }

    /**
     * Validates the coordinates
     * - Checks if they are both positive values
     *
     * @param l length
     * @param w width
     */
    private void validateCoordinates(String l, String w) {
       this.length = Float.parseFloat(l);
       this.width = Float.parseFloat(w);
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Coordinates can't be negatives.");
        }
    }

    @Override
    public String toString() {
        return "Coordinates:" +
                "\n    Width=" + width +
                "\n    Length=" + length;
    }
}
