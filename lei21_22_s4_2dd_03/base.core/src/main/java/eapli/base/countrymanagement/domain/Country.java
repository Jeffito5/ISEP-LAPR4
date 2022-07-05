package eapli.base.countrymanagement.domain;


import eapli.base.ordermanagement.domain.Identifier;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */


@Entity
public class Country implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;


    protected Country() {
    }

    protected Country(String name) {
        ruleName(name);
        this.name = name;
    }


    /**
     * new constructor
     *
     * @param name name
     * @return country
     */
    public static Country valueOf(String name) {
        return new Country(name.toUpperCase());
    }

    /**
     * rule name
     *
     * @param name name
     */
    private void ruleName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Insert a Country name.");
        }
    }

    /**
     * gets the name
     *
     * @return name
     */
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public Integer identity() {
        return this.id;
    }

    @Override
    public boolean hasIdentity(Integer id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }
}
