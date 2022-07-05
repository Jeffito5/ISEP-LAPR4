package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Luís Araújo
 */
@Embeddable
public class ShortDescription implements ValueObject, Comparable<ShortDescription>, Serializable {
    /**
     * Product's short description
     */
    private String shortDescription;

    /**
     * Empty constructor
     */
    public ShortDescription() {
    }

    /**
     * Constructor with the parameter short description
     * @param shortDescription
     */
    public ShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Method that returns the short description
     * @return shortDescription
     */
    public String shortDescription() {
        return shortDescription;
    }

    @Override
    public String toString() {
        return shortDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShortDescription)) return false;
        ShortDescription that = (ShortDescription) o;
        return Objects.equals(shortDescription, that.shortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortDescription);
    }

    @Override
    public int compareTo(ShortDescription o) {
        return 0;
    }
}
