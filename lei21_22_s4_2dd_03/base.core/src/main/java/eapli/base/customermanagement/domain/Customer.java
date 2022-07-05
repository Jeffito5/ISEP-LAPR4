package eapli.base.customermanagement.domain;

import eapli.base.customermanagement.dto.CustomerDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Entity
public class Customer implements Serializable, AggregateRoot<Integer> {
    @Id
    @GeneratedValue
    private Integer id;
    @Embedded
    private Name name;
    @Embedded
    @Column(unique = true)
    private VAT vat;
    @Embedded
    @Column(unique = true)
    private Email email;
    @Embedded
    private Telephone phoneNumber;
    //optional
    @Embedded
    private Gender gender;
    @ElementCollection
    private List<Address> billingAddress;
    @ElementCollection
    private List<Address> deliveryAddress;
    @Embedded
    private BirthDate birthDate;
    @OneToOne
    private ShoppingCart shoppingCart;

    protected Customer() {
    }

    protected Customer(Name name, VAT vat, Email email, Telephone phoneNumber, Gender gender, List<Address> billingAddress, List<Address> deliveryAddress, BirthDate birthDate, ShoppingCart shoppingCart) {
        this.name = name;
        this.vat = vat;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.billingAddress = billingAddress;
        this.deliveryAddress = deliveryAddress;
        this.birthDate = birthDate;
        this.shoppingCart = shoppingCart;
    }

    /**
     * new constructor
     *
     * @param name            name
     * @param vat             vat
     * @param email           email
     * @param phoneNumber     phone number
     * @param gender          gender
     * @param billingAddress  billing address
     * @param deliveryAddress delivery address
     * @param birthDate       birthdate
     * @return customer
     */
    public static Customer valueOf(Name name, VAT vat, Email email, Telephone phoneNumber, Gender gender, List<Address> billingAddress, List<Address> deliveryAddress, BirthDate birthDate, ShoppingCart shoppingCart) {
        return new Customer(name, vat, email, phoneNumber, gender, billingAddress, deliveryAddress, birthDate, shoppingCart);
    }

    public CustomerDTO toDTO() {
        return new CustomerDTO(id.toString(), name.toString(), vat.toString(), email.toString(), phoneNumber.toString(), gender.toString(), billingAddress.toString(), deliveryAddress.toString(), birthDate.toString(), shoppingCart.toString());
    }

    public CustomerDTO toDTO2() {
        return new CustomerDTO(id.toString(), name.toString(), vat.toString(), email.toString(), phoneNumber.toString(), gender.toString(), birthDate.toString(), shoppingCart.toString());
    }

    /**
     * Method that returns the VAT
     *
     * @return vat
     */
    public VAT vat() {
        return vat;
    }

    public Gender gender() {
        return gender;
    }


    /**
     * equals method
     *
     * @param other customer
     * @return true or false
     */
    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    /**
     * returns customer id
     *
     * @return id
     */
    @Override
    public Integer identity() {
        return this.id;
    }

    public ShoppingCart shoppingCart() {
        return shoppingCart;
    }

    public List<Address> billingAddress() {
        return new ArrayList<>(billingAddress);
    }

    public List<Address> deliveryAddress() {
        return new ArrayList<>(deliveryAddress);
    }

    public String email() {
        return email.email();
    }

    public boolean equalGender(String gender) {
        return this.gender.equals(new Gender(gender));
    }

    public boolean hasCountry(String country) {
        for (Address add : billingAddress) {
            if (add.country().name().equals(country))
                return true;
        }

        for (Address add : deliveryAddress) {
            if (add.country().name().equals(country))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name=" + name +
                ", vat=" + vat +
                ", email=" + email +
                ", phoneNumber=" + phoneNumber +
                ", gender=" + gender +
                ", billingAddress=" + billingAddress +
                ", deliveryAddress=" + deliveryAddress +
                ", birthDate=" + birthDate +
                ", shoppingCart=" + shoppingCart +
                '}';
    }
}
