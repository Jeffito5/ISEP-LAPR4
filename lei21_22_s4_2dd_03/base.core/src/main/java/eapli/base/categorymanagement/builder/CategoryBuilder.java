package eapli.base.categorymanagement.builder;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.Code;
import eapli.base.categorymanagement.domain.Description;

/**
 * @author Ana Rita Silva
 */
public class CategoryBuilder {

    /**
     * Category's unique code
     */
    public Code code;

    /**
     * Category's description
     */
    public Description description;

    /**
     * Defines the category's code
     *
     * @param code category's code
     * @return the builder's instance being defined
     */
    public CategoryBuilder withCode(String code) {
        this.code = new Code(code);
        return this;
    }

    /**
     * Defines the category's description
     *
     * @param description category's description
     * @return the builder's instance being defined
     */
    public CategoryBuilder withDescription(String description) {
        this.description = new Description(description);
        return this;
    }

    /**
     * Builds a category
     * - Validates the code and the description
     * - If valid creates the new Category
     */
    public Category build() {
        return new Category(this);
    }
}
