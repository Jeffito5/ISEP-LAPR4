package eapli.base.categorymanagement.application;

import eapli.base.categorymanagement.builder.CategoryBuilder;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.io.Serializable;

/**
 * @author Ana Rita Silva
 */
public class CreateCategoryController {

    /**
     * Category's repository
     */
    private final JpaRepository<Category, Serializable> repo;

    /**
     * Controller responsible for creating new categories
     * - Gets the repository where the categories are going to be saved
     */
    public CreateCategoryController() {
        repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
    }

    /**
     * Creates a new category
     * - Uses the CategoryBuilder to validate the code and the description
     * - After the validation the category is created and saved in the repository
     *
     * @param code        category's code
     * @param description category's description
     */
    public void createCategory(String code, String description) {
        Category category = new CategoryBuilder().withCode(code).withDescription(description).build();
        repo.add(category);
    }
}
