package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Luís Araújo
 */
@Embeddable
public class TechnicalDescription implements ValueObject, Comparable<TechnicalDescription>, Serializable {
    /**
     * Product's technical description
     */
    private String technicalDescription;

    /**
     * Empty constructor
     */
    public TechnicalDescription() {
    }

    /**
     * Constructor with the parameter technical description
     * @param technicalDescription
     */
    public TechnicalDescription(String technicalDescription) {
        this.technicalDescription = technicalDescription;
    }

    /**
     * Method that returns the technical description
     * @return technicalDescription
     */
    public String technicalDescription() {
        return technicalDescription;
    }

    @Override
    public String toString() {
        return technicalDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TechnicalDescription)) return false;
        TechnicalDescription that = (TechnicalDescription) o;
        return Objects.equals(technicalDescription, that.technicalDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(technicalDescription);
    }

    @Override
    public int compareTo(TechnicalDescription o) {
        return 0;
    }
}
