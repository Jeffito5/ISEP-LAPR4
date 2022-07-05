package eapli.base.customermanagement.domain;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */

@Embeddable
public class Telephone implements ValueObject, Serializable {
    private String countryIndetification;
    private int phoneNumber;

    protected Telephone(){

    }

    protected Telephone(String countryIndetification, int phoneNumber) {
        rulePhoneNumber(phoneNumber);
        ruleCountryIndentification(countryIndetification);
        this.countryIndetification = countryIndetification;
        this.phoneNumber = phoneNumber;
    }

    /**
     * new constructor
     * @param countryIndetification country identification number
     * @param phoneNumber phone number
     * @return telephone
     */
    public static Telephone valueOf(String countryIndetification, int phoneNumber) {
        return new Telephone(countryIndetification,phoneNumber);
    }

    /**
     * rule phone number
     * @param phoneNumber phone number
     */
    private void rulePhoneNumber(int phoneNumber) {
        if (phoneNumber >= 1000000000 || phoneNumber <= 99999999)
            throw new IllegalArgumentException("Phone number invalid.");
    }

    /**
     * rule country identifier number
     * @param countryIndetification country identification
     */
    private void ruleCountryIndentification(String countryIndetification) {
        if(countryIndetification.isBlank())
            throw new IllegalArgumentException("Country Indentification invalid.");
        if(countryIndetification.length()>4)
            throw new IllegalArgumentException("Country Indentification invalid.");
        if (countryIndetification.charAt(0) != '+'){
            throw new IllegalArgumentException("Country Indentification invalid.");
        }
        try {
            Integer.parseInt(countryIndetification.substring(1, 3));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Country Indentification invalid.");
        }
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "countryIndetification='" + countryIndetification + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
