package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Luís Araújo
 */
@Embeddable
public class Reference implements ValueObject, Comparable<Reference>, Serializable {
    /**
     * Product's reference
     */
    private String reference;

    /**
     * Empty constructor
     */
    public Reference() {
    }

    /**
     * Constructor with the parameter reference
     * @param reference
     */
    public Reference(String reference) {
        this.reference = reference;
    }

    /**
     * Method that returns the reference
     * @return reference
     */
    public String reference() {
        return reference;
    }

    @Override
    public String toString() {
        return reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reference)) return false;
        Reference reference1 = (Reference) o;
        return Objects.equals(reference, reference1.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference);
    }

    @Override
    public int compareTo(Reference o) {
        return 0;
    }
}
