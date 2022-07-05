package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Luís Araújo
 */
@Embeddable
public class PriceWithoutTax implements ValueObject, Comparable<PriceWithoutTax>, Serializable {
    /**
     * Product's price without tax
     */
    private double priceWithoutTax;

    /**
     * Empty constructor
     */
    public PriceWithoutTax() {
    }

    /**
     * Constructor with the parameter priceWithoutTax
     * @param priceWithoutTax
     */
    public PriceWithoutTax(double priceWithoutTax) {
        this.priceWithoutTax = priceWithoutTax;
    }

    /**
     * Method that returns the priceWithoutTax
     * @return priceWithoutTax
     */
    public double priceWithoutTax() {
        return priceWithoutTax;
    }

    @Override
    public String toString() {
        return priceWithoutTax + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceWithoutTax)) return false;
        PriceWithoutTax that = (PriceWithoutTax) o;
        return Double.compare(that.priceWithoutTax, priceWithoutTax) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceWithoutTax);
    }

    @Override
    public int compareTo(PriceWithoutTax o) {
        return 0;
    }
}
