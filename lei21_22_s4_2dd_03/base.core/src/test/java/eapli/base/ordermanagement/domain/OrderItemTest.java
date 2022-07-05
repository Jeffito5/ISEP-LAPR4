package eapli.base.ordermanagement.domain;

import eapli.base.categorymanagement.builder.CategoryBuilder;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.application.SpecifyProductController;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductMeasurements;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Luís Araújo
 */
//TODO
public class OrderItemTest {
    /**
     * Instance of SpecifyProductController
     */
    SpecifyProductController controller = new SpecifyProductController();

    /**
     * Instance of category
     */
    Category category1 = new CategoryBuilder().withCode("Food").build();

    /**
     * Instance of ProductMeasurements
     */
    ProductMeasurements measurements = new ProductMeasurements(1, 1, 1, 30, 20, 30, 0.5);

    /**
     * Instance of Product
     */

    Product product = controller.specifyProductWithTheProductionCode(1L, "Water Bottle", "Bottle with water", "Plastic bottle filled with water", "Plastic bottle, with 500 mL almost full of water", measurements, "Barcode1", "Fastio", "Pingo Doce", 1, 1, "SPLASH", category1, "path1");

    /**
     * Instance of OrderItem
     */
    OrderItem orderItem = OrderItem.valueOf(product, 1);

    /**
     * Test that tests the method that returns the product
     */
//    @Test
//    public void product() {
//        //Assert
//        assertEquals(product, orderItem.product());
//    }
//
//    /**
//     * Test that tests the method that returns the quantity
//     */
//    @Test
//    public void quantity() {
//        //Assert
//        assertEquals(1, orderItem.quantity());
//    }
}