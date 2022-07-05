package eapli.base.categorymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Ana Rita Silva
 */
@Embeddable
public class Code implements ValueObject, Comparable<Code>, Serializable {

    private String code;
    private static final int MIN_LIMIT = 10;

    /**
     * Empty constructor
     */
    public Code() {
    }

    /**
     * Defines the code
     * - Verifies if the code is an alphanumeric code, not empty, with at 10 chars maximum
     *
     * @param code category's code
     */
    public Code(String code) {
        if (code == null || code.isBlank() || !code.chars().allMatch(Character::isLetterOrDigit)) {
            throw new IllegalArgumentException("Code should be alphanumeric, not null nor empty.");
        }
        if (code.length() > MIN_LIMIT) {
            throw new IllegalArgumentException("Code should have 10 chars maximum.");
        }

        this.code = code;
    }
    public String valueOf(){
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Code code1 = (Code) o;
        return Objects.equals(code, code1.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Code: " + code;
    }

    @Override
    public int compareTo(Code o) {
        return this.code.compareTo(o.code);
    }
}
