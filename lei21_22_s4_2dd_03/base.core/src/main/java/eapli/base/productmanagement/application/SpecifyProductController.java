package eapli.base.productmanagement.application;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.CatalogId;
import eapli.base.categorymanagement.mapper.dto.CategoryDTO;
import eapli.base.categorymanagement.mapper.CategoryMapper;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.Code;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.builder.ProductBuilder;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductMeasurements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Luís Araújo
 */
public class SpecifyProductController {
    /**
     * List of products
     */
    private List<Product> listOfProducts = new ArrayList<>();
    /**
     * Instance of the catalog
     */
    private Catalog catalog;
    /**
     * Instance of category repository
     */
    private CategoryRepository categoryRepository;

    /**
     * Empty Constructor
     */
    public SpecifyProductController() {
        categoryRepository = PersistenceContext.repositories().categories();
    }

    /**
     * Method that specifies a product without the production code
     *
     * @param code
     * @param shortDescription
     * @param extendedDescription
     * @param technicalDescription
     * @param productMeasurements
     * @param brandName
     * @param reference
     * @param priceWithTax
     * @param priceWithoutTax
     * @return a product without the production code
     */
    public Product specifyProductWithoutTheProductionCode(Long id, String code, String shortDescription, String extendedDescription, String technicalDescription, ProductMeasurements productMeasurements, String barcode, String brandName, String reference, double priceWithTax, double priceWithoutTax, Category category, String photo) {
        //JpaRepository<Category, Serializable> repoCat = new JpaRepository<>() {
            //@Override
            //protected String persistenceUnitName() {
                //return null;
            //}
        //};
        //Category category1 = repoCat.findById(category.code.valueOf());
        CatalogId catalogId = new CatalogId(id);
        Product prod = new ProductBuilder(code).shortDescription(shortDescription).extendedDescription(extendedDescription).technicalDescription(technicalDescription)
                .productMeasurements(productMeasurements).barcode(barcode).brandName(brandName).reference(reference).priceWithTax(priceWithTax).priceWithoutTax(priceWithoutTax).category(category).photo(photo).build();
        JpaRepository<Product, Serializable> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        repo.add(prod);

        JpaRepository<Catalog, Serializable> repo2 = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        if (repo2.findById(catalogId) == null) {
            catalog = new Catalog(id, listOfProducts);
            catalog.listOfProducts().add(prod);
            repo2.add(catalog);
        } else {
            Catalog c = repo2.findById(catalogId);
            c.listOfProducts().add(prod);
            repo2.add(c);
        }

        return prod;
    }

    /**
     * Method that specifies a product with the production code
     *
     * @param code
     * @param shortDescription
     * @param extendedDescription
     * @param technicalDescription
     * @param productMeasurements
     * @param brandName
     * @param reference
     * @param priceWithTax
     * @param priceWithoutTax
     * @param productionCode
     * @return a product with the production code
     */
    public Product specifyProductWithTheProductionCode(Long id, String code, String shortDescription, String extendedDescription, String technicalDescription, ProductMeasurements productMeasurements, String barcode, String brandName, String reference, double priceWithTax, double priceWithoutTax, String productionCode, Category category, String photo) {
//        JpaRepository<Category, Serializable> repoCat = new JpaRepository<>() {
//            @Override
//            protected String persistenceUnitName() {
//                return null;
//            }
//        };
//        Category category1 = repoCat.findById(category.code.valueOf());
        CatalogId catalogId = new CatalogId(id);
        Product prod = new ProductBuilder(code).shortDescription(shortDescription).extendedDescription(extendedDescription).technicalDescription(technicalDescription)
                .productMeasurements(productMeasurements).barcode(barcode).brandName(brandName).reference(reference).priceWithTax(priceWithTax).priceWithoutTax(priceWithoutTax).productionCode(productionCode).category(category).photo(photo).build();
        JpaRepository<Product, Serializable> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        repo.add(prod);

        JpaRepository<Catalog, Serializable> repo2 = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        if (repo2.findById(catalogId) == null) {
            catalog = new Catalog(id, listOfProducts);
            catalog.listOfProducts().add(prod);
            repo2.add(catalog);
        } else {
            Catalog c = repo2.findById(catalogId);
            c.listOfProducts().add(prod);
            repo2.add(c);
        }

        return prod;
    }

    /**
     * Method that returns a list of categories to choose
     *
     * @return list of categories to choose
     */
    public List<CategoryDTO> chooseCategory() {
        JpaRepository<Category, Serializable> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        return new CategoryMapper().toDTO(repo.findAll());
    }

    public Category categoryByCategoryDTO(CategoryDTO categoryDTO) {
        JpaRepository<Category, Serializable> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        return repo.findById(categoryDTO.code);
    }

    /**
     * Method that returns a certain category searched by its code
     *
     * @param code
     * @return certain category searched by its code
     */
    public CategoryDTO category(Code code) {
        JpaRepository<Category, Serializable> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        return new CategoryMapper().toDTO(repo.findById(code));
    }

    /**
     * Method that creates an instance of product measurements
     *
     * @param aisleID
     * @param rowID
     * @param shelfID
     * @param width
     * @param length
     * @param height
     * @param weight
     * @return instance of product measurements
     */
    public ProductMeasurements createInstanceOfProductMeasurements(int aisleID, int rowID, int shelfID, double width, double length, double height, double weight) {
        return new ProductMeasurements(aisleID, rowID, shelfID, width, length, height, weight);
    }
}
