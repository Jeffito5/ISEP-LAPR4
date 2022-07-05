package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Luís Araújo
 */
@Embeddable
public class ExtendedDescription implements ValueObject, Comparable<ExtendedDescription>, Serializable {
    /**
     * Product's extended description
     */
    private String extendedDescription;

    /**
     * Empty constructor
     */
    public ExtendedDescription() {
    }

    /**
     * Constructor with the parameter extendedDescription
     * @param extendedDescription
     */
    public ExtendedDescription(String extendedDescription) {
        this.extendedDescription = extendedDescription;
    }

    /**
     * Method that returns the extendedDescription
     * @return extendedDescription
     */
    public String extendedDescription() {
        return extendedDescription;
    }

    @Override
    public String toString() {
        return extendedDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExtendedDescription)) return false;
        ExtendedDescription that = (ExtendedDescription) o;
        return Objects.equals(extendedDescription, that.extendedDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extendedDescription);
    }

    @Override
    public int compareTo(ExtendedDescription o) {
        return 0;
    }
}
