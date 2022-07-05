package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Luís Araújo
 */
@Embeddable
public class PriceWithTax implements ValueObject, Comparable<PriceWithTax>, Serializable {
    /**
     * Product's price with tax
     */
    private double priceWithTax;

    /**
     * Empty constructor
     */
    public PriceWithTax() {
    }

    /**
     * Constructor with the parameter priceWithTax
     * @param priceWithTax
     */
    public PriceWithTax(double priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    /**
     * Method that returns the priceWithTax
     * @return priceWithTax
     */
    public double priceWithTax() {
        return priceWithTax;
    }
    @Override
    public String toString() {
        return priceWithTax + "";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceWithTax)) return false;
        PriceWithTax that = (PriceWithTax) o;
        return Double.compare(that.priceWithTax, priceWithTax) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceWithTax);
    }

    @Override
    public int compareTo(PriceWithTax o) {
        return 0;
    }
}
