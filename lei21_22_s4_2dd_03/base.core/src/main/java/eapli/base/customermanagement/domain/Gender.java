package eapli.base.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;


/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Embeddable
public class Gender implements ValueObject, Serializable {

    private String gender;

    protected Gender(){}

    protected Gender(String gender){
        ruleGender(gender);
        this.gender=gender;
    }

    /**
     * new constructor
     * @param gender gender
     * @return gender
     */
    public static Gender valueOf(String gender){
        return new Gender(gender);
    }


    /**
     * rule gender
     * @param gender gender
     */
    private void ruleGender(String gender) {
        if (gender.isBlank())
            return;
        if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") && !gender.equalsIgnoreCase("Other"))
            throw new IllegalArgumentException("Invalid gender.");
    }


    public String gender(){
        return gender;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "gender='" + gender + '\'' +
                '}';
    }

    public boolean equals(Gender gender){
        return this.gender.equals(gender.gender);
    }
}
