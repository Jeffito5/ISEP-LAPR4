package eapli.base.catalogmanagement.domain;

import com.sun.istack.NotNull;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * @author Luís Araújo
 */
@Entity
public class Catalog implements Serializable, AggregateRoot<CatalogId> {
    /**
     * Catalog's id
     */
    @NotNull
    @EmbeddedId
    private CatalogId id;

    /**
     * List of the products of the catalog
     */
    @OneToMany
    private List<Product> listOfProducts;

    /**
     * Constructor with the list of products
     *
     * @param listOfProducts
     */
    public Catalog(Long id, List<Product> listOfProducts) {
        this.id = new CatalogId(id);
        this.listOfProducts = listOfProducts;
    }

    /**
     * Empty constructor
     */
    protected Catalog() {
    }

    /**
     * Method that returns the id of the catalog
     *
     * @return the id of the catalog
     */
    public CatalogId id() {
        return id;
    }

    /**
     * Method that returns the list of the products
     *
     * @return list of the products
     */
    public List<Product> listOfProducts() {
        return listOfProducts;
    }

    /**
     * Method that changes the list of the products
     *
     * @param listOfProducts
     */
    public void changeListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    @Override
    public String toString() {
        return "---------------------------------------------------------------------------------------------------------Catalog----------------------------------------------------------------------------------------------------------------------\\\n" +
                "ID: " + id + "\n" +
                "List of Products" + listOfProducts;
    }

    /**
     * Method that verifies if two objects are equal
     *
     * @param other
     * @return true if are equal and false otherwise
     */
    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    /**
     * Method that returns the identity
     *
     * @return identity
     */
    @Override
    public CatalogId identity() {
        return this.id;
    }
}
