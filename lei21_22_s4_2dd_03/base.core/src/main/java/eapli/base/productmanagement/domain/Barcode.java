package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Luís Araújo
 */
@Embeddable
public class Barcode implements ValueObject, Comparable<Barcode>, Serializable {
    /**
     * Product's barcode
     */
    private String barcode;

    /**
     * Empty constructor
     */
    public Barcode() {

    }

    /**
     * Constructor with the parameter barcode
     * @param barcode
     */
    public Barcode(String barcode) {
        this.barcode = barcode;
    }

    /**
     * Method that returns the barcode
     * @return barcode
     */
    public String barcode() {
        return barcode;
    }

    @Override
    public String toString() {
        return barcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Barcode)) return false;
        Barcode barcode1 = (Barcode) o;
        return Objects.equals(barcode, barcode1.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode);
    }

    @Override
    public int compareTo(Barcode o) {
        return 0;
    }
}
