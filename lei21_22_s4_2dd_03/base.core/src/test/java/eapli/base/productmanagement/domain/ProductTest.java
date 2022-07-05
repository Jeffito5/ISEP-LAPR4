package eapli.base.productmanagement.domain;

import eapli.base.productmanagement.builder.ProductBuilder;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Araújo
 */
public class ProductTest {
    /**
     * Instance of ProductMeasurements
     */
    ProductMeasurements productMeasurements = new ProductMeasurements(1, 1, 1, 10.0, 10.0, 10.0, 10.0);

    /**
     * Instances of Product
     */
    Product product = new ProductBuilder("Code1").shortDescription("shortDescription").extendedDescription("extendedDescription12345690").technicalDescription("technicalDescription")
            .productMeasurements(productMeasurements).brandName("brandName").reference("reference").priceWithTax(11.0).priceWithoutTax(10.0).build();

    Product product2 = new ProductBuilder("Code1").shortDescription("shortDescription").extendedDescription("extendedDescription12345690").technicalDescription("technicalDescription")
            .productMeasurements(productMeasurements).brandName("brandName").reference("reference").priceWithTax(11.0).priceWithoutTax(10.0).productionCode("PC1").build();

    /**
     * Test that verifies if the internalCode is the same
     */
    @Test
    public void internalCode() {
        //Assert
        assertEquals("Code1", product.internalCode().internalCode());
    }

    /**
     * Test that verifies if the shortDescription is the same
     */
    @Test
    public void shortDescription() {
        //Assert
        assertEquals("shortDescription", product.shortDescription().shortDescription());
    }

    /**
     * Test that verifies if the new shortDescription is the same as the changed shortDescription
     */
    @Test
    public void changeShortDescription() {
        //Act
        ShortDescription shortDescription = new ShortDescription("SD1");
        product.changeShortDescription(shortDescription);

        //Assert
        assertEquals("SD1", product.shortDescription().shortDescription());
    }

    /**
     * Test that verifies if the extendedDescription is the same
     */
    @Test
    public void extendedDescription() {
        //Assert
        assertEquals("shortDescription", product.shortDescription().shortDescription());
    }

    /**
     * Test that verifies if the new extendedDescription is the same as the changed extendedDescription
     */
    @Test
    public void changeExtendedDescription() {
        //Act
        ExtendedDescription extendedDescription = new ExtendedDescription("ED1");
        product.changeExtendedDescription(extendedDescription);

        //Assert
        assertEquals("ED1", product.extendedDescription().extendedDescription());
    }

    /**
     * Test that verifies if the technicalDescription is the same
     */
    @Test
    public void technicalDescription() {
        //Assert
        assertEquals("shortDescription", product.shortDescription().shortDescription());
    }

    /**
     * Test that verifies if the new technicalDescription is the same as the changed technicalDescription
     */
    @Test
    public void changeTechnicalDescription() {
        //Act
        TechnicalDescription technicalDescription = new TechnicalDescription("TD1");
        product.changeTechnicalDescription(technicalDescription);

        //Assert
        assertEquals("TD1", product.technicalDescription().technicalDescription());
    }

    /**
     * Test that verifies if the barcode is the same
     */
    @Test
    public void barcode() {
        //Assert
        assertEquals("shortDescription", product.shortDescription().shortDescription());
    }

    /**
     * Test that verifies if the new barcode is the same as the changed barcode
     */
    @Test
    public void changeBarcode() {
        //Assert
        assertNull(product.barcode());
    }

    /**
     * Test that verifies if the productMeasurements is the same
     */
    @Test
    public void productMeasurements() {
        //Arrange
        ProductMeasurements aux = new ProductMeasurements(2, 1, 1, 10.0, 10.0, 10.0, 10.0);

        //Assert
        assertNotEquals(aux, product.productMeasurements());
    }

    /**
     * Test that verifies if the new productMeasurements is the same as the changed productMeasurements
     */
    @Test
    public void changeProductMeasurements() {
        //Arrange
        ProductMeasurements aux = new ProductMeasurements(2, 2, 2, 10.0, 10.0, 10.0, 10.0);

        //Act
        product.changeProductMeasurements(aux);

        //Assert
        assertEquals(aux, product.productMeasurements());
    }

    /**
     * Test that verifies if the brandName is the same
     */
    @Test
    public void brandName() {
        //Assert
        assertEquals("brandName", product.brandName().brandName());
    }

    /**
     * Test that verifies if the new brandName is the same as the changed brandName
     */
    @Test
    public void changeBrandName() {
        //Act
        BrandName brandName = new BrandName("BN1");
        product.changeBrandName(brandName);

        //Assert
        assertEquals("BN1", product.brandName().brandName());
    }

    /**
     * Test that verifies if the reference is the same
     */
    @Test
    public void reference() {
        //Assert
        assertEquals("reference", product.reference().reference());
    }

    /**
     * Test that verifies if the new reference is the same as the changed reference
     */
    @Test
    public void changeReference() {
        //Act
        Reference reference = new Reference("R1");
        product.changeReference(reference);

        //Assert
        assertEquals("R1", product.reference().reference());
    }

    /**
     * Test that verifies if the priceWithTax is the same
     */
    @Test
    public void priceWithTax() {
        //Assert
        assertEquals(11.0, product.priceWithTax().priceWithTax());
    }

    /**
     * Test that verifies if the new priceWithTax is the same as the changed priceWithTax
     */
    @Test
    public void changePriceWithTax() {
        //Act
        PriceWithTax priceWithTax = new PriceWithTax(12.0);
        product.changePriceWithTax(priceWithTax);

        //Assert
        assertEquals(12.0, product.priceWithTax().priceWithTax());
    }

    /**
     * Test that verifies if the priceWithoutTax is the same
     */
    @Test
    public void priceWithoutTax() {
        //Assert
        assertEquals(10.0, product.priceWithoutTax().priceWithoutTax());
    }

    /**
     * Test that verifies if the new priceWithoutTax is the same as the changed priceWithoutTax
     */
    @Test
    public void changePriceWithoutTax() {
        //Act
        PriceWithoutTax priceWithoutTax = new PriceWithoutTax(11.0);
        product.changePriceWithoutTax(priceWithoutTax);

        //Assert
        assertEquals(11.0, product.priceWithoutTax().priceWithoutTax());
    }

    /**
     * Test that verifies if the productionCode is the same
     */
    @Test
    public void productionCode() {
        //Assert
        assertEquals("PC1", product2.productionCode().productionCode());
    }

    /**
     * Test that verifies if the new productionCode is the same as the changed productionCode
     */
    @Test
    public void changeProductionCode() {
        //Act
        ProductionCode productionCode = new ProductionCode("PC2");
        product2.changeProductionCode(productionCode);

        //Assert
        assertEquals("PC2", product2.productionCode().productionCode());
    }
}