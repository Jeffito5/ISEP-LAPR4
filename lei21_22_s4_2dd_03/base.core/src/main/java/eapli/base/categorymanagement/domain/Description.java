package eapli.base.categorymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Ana Rita Silva
 */
@Embeddable
public class Description implements ValueObject, Serializable {

    private String description;
    private static final int MIN_LIMIT = 20;
    private static final int MAX_LIMIT = 50;

    /**
     * Defines the description
     * - Verifies if the description is not empty with a minimum of 20 chars and 50 chars maximum
     *
     * @param description category's description
     */
    public Description(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException(
                    "Description should neither be null nor empty.");
        }
        if (description.length() < MIN_LIMIT || description.length() > MAX_LIMIT) {
            throw new IllegalArgumentException(
                    "Description should have a minimum of 20 chars and 50 chars maximum.");
        }

        this.description = description;
    }

    /**
     * Empty constructor
     */
    public Description() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "Description: " + description;
    }
}
