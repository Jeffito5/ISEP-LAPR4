package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Luís Araújo
 */
@Embeddable
public class InternalCode implements ValueObject, Comparable<InternalCode>, Serializable {
    /**
     * Product's internal code
     */
    private String internalCode;

    /**
     * Empty constructor
     */
    public InternalCode() {
    }

    /**
     * Constructor with the parameter internalCode
     * @param internalCode
     */
    public InternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    /**
     * Method that returns the internalCode
     * @return internalCode
     */
    public String internalCode() {
        return internalCode;
    }

    @Override
    public String toString() {
        return internalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InternalCode)) return false;
        InternalCode that = (InternalCode) o;
        return Objects.equals(internalCode, that.internalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internalCode);
    }

    @Override
    public int compareTo(InternalCode o) {
        return 0;
    }
}
