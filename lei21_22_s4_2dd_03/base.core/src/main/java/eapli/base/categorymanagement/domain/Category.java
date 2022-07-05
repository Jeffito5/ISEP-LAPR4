package eapli.base.categorymanagement.domain;

import eapli.base.categorymanagement.builder.CategoryBuilder;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author Ana Rita Silva
 */
@Entity
public class Category implements AggregateRoot<Code>, Serializable {

    /**
     * Category's unique code
     */
    @EmbeddedId
    private Code code;

    /**
     * Category's description
     */
    @Embedded
    private Description description;

    public Code code() {
        return code;
    }

    /**
     * Category's constructor
     * - Defines the code and the description using the builder
     *
     * @param builder category's builder
     */
    public Category(CategoryBuilder builder) {
        this.code = builder.code;
        this.description = builder.description;
    }

    /**
     * Empty constructor
     */
    protected Category() {

    }

    /**
     * Transforms the category in a string with all its attributes
     *
     * @return category in a string format
     */
    @Override
    public String toString() {
        return "Category:" + "\n    Code = " + code + "\n   Description = " + description;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Code identity() {
        return this.code;
    }
}
