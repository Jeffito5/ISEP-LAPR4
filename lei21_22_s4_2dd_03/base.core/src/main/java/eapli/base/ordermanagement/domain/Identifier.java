package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author 1201217 Marco Ramos
 */
@Embeddable
public class Identifier implements ValueObject, Serializable, Comparable<Identifier> {


    private Integer identifier;

    protected Identifier() {

    }

    protected Identifier(int identifier) {
        this.identifier = identifier;
    }

    /**
     * create the new Identifier
     *
     * @param identifier identifier
     * @return the new Identifier class
     */
    public static Identifier valueOf(int identifier) {
        return new Identifier(identifier);
    }

    public Integer identifier() {
        return identifier;
    }

    @Override
    public int compareTo(Identifier o) {
        return this.identifier.compareTo(o.identifier);
    }

    @Override
    public String toString() {
        return "Identifier{" +
                "identifier=" + identifier +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return Objects.equals(identifier, that.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
