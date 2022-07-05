package eapli.base.catalogmanagement.domain;

import eapli.base.productmanagement.builder.ProductBuilder;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductMeasurements;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Luís Araújo
 */
public class CatalogTest {
    /**
     * Instance of product measurements
     */
    ProductMeasurements productMeasurements = new ProductMeasurements(1, 1, 1, 10.0, 10.0, 10.0, 10.0);

    /**
     * Instances of products
     */
    Product product = new ProductBuilder("Code1").shortDescription("shortDescription").extendedDescription("extendedDescription1234567890").technicalDescription("technicalDescription")
            .productMeasurements(productMeasurements).brandName("brandName").reference("reference").priceWithTax(11.0).priceWithoutTax(10.0).build();
    Product product2 = new ProductBuilder("Code1").shortDescription("shortDescription").extendedDescription("extendedDescription1234567890").technicalDescription("technicalDescription")
            .productMeasurements(productMeasurements).brandName("brandName").reference("reference").priceWithTax(11.0).priceWithoutTax(10.0).productionCode("PC1").build();

    /**
     * List of products
     */
    List<Product> list = new ArrayList<>();

    /**
     * Test that verifies if the catalogId is the same
     */
    @Test
    public void catalogId() {
        //Arrange
        list.add(product);
        list.add(product2);
        Catalog catalog =new Catalog(1L,list);

        //Assert
        assertEquals(1L, catalog.id().id());
    }

    /**
     * Test that verifies if the returned list of products is the same
     */
    @Test
    public void listOfProducts() {
        //Arrange
        List<Product> aux = new ArrayList<>();
        aux.add(product);
        aux.add(product2);

        //Arrange
        list.add(product);
        list.add(product2);
        Catalog catalog =new Catalog(1L,list);

        //Assert
        assertEquals(aux, catalog.listOfProducts());
    }

    /**
     * Test that verifies if the new list of products is the same as the changed list
     */
    @Test
    public void changeListOfProducts() {
        //Arrange
        List<Product> aux = new ArrayList<>();
        aux.add(product);

        //Arrange
        list.add(product);
        list.add(product2);
        Catalog catalog =new Catalog(1L,list);

        //Act
        catalog.changeListOfProducts(aux);

        //Assert
        assertEquals(aux, catalog.listOfProducts());
    }
}