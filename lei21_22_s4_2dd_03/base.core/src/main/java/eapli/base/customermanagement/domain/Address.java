package eapli.base.customermanagement.domain;


import eapli.base.countrymanagement.domain.Country;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;


/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Embeddable
public class Address implements ValueObject, Serializable {

    private String streetName;

    private int doorNumber;

    private String postalCode;

    private String city;

    @ManyToOne
    private Country country;

    protected Address() {
    }

    protected Address(String streetName, int doorNumber, String postalCode, String city, Country country) {
        ruleCity(city);
        ruleDoorNumber(doorNumber);
        rulePostalCode(postalCode);
        ruleStreetName(streetName);
        this.streetName = streetName;
        this.doorNumber = doorNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    /**
     * new constructor
     * @param streetName street name
     * @param doorNumber door number
     * @param postalCode postal code
     * @param city city
     * @param country country
     * @return address
     */
    public static Address valueOf(String streetName, int doorNumber, String postalCode, String city, Country country) {
        return new Address(streetName,doorNumber,postalCode,city,country);
    }

    /**
     * rule street name
     * @param streetName street name
     */
    private void ruleStreetName(String streetName) {
        if (streetName.isBlank()) {
            throw new IllegalArgumentException("Insert Street Name.");
        }
    }

    /**
     * rule door number
     * @param doorNumber door number
     */
    private void ruleDoorNumber(int doorNumber) {
        if (doorNumber >= 1000 || doorNumber <= 0) {
            throw new IllegalArgumentException("Door Number is invalid.");
        }
    }

    /**
     * rule postal code
     * @param postalCode postal code
     */
    private void rulePostalCode(String postalCode) {
        if (postalCode.isBlank()) {
            throw new IllegalArgumentException("Insert postal code.");
        }
    }

    /**
     * rule city
     * @param city city
     */
    private void ruleCity(String city) {
        if (city.isBlank()) {
            throw new IllegalArgumentException("Insert City name.");
        }
    }

    public Country country(){return country;}


    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", doorNumber=" + doorNumber +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                '}';
    }
}
