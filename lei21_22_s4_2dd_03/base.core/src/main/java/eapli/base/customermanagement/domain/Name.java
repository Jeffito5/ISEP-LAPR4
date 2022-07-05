package eapli.base.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Embeddable
public class Name implements ValueObject, Serializable {

    private String firstName;

    private String lastName;

    protected Name(){}

    protected Name(String firstName, String lastName) {
        ruleName(firstName);
        ruleName(lastName);
        this.firstName=firstName;
        this.lastName=lastName;
    }

    /**
     * new constructor
     * @param firstName first name
     * @param lastName last name
     * @return name
     */
    public static Name valueOf(String firstName, String lastName){
        return new Name(firstName,lastName);
    }


    /**
     * name rule
     * @param name name
     */
    private void ruleName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Insert name.");
        }
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
