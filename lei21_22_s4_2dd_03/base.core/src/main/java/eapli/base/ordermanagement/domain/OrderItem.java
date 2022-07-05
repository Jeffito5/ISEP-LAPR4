package eapli.base.ordermanagement.domain;

import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * @author 1201217 Marco Ramos
 */
@Embeddable
public class OrderItem implements ValueObject, Serializable {

    @OneToOne
    private Product product;

    private int quantity;

    protected OrderItem() {
    }

    protected OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * create the new order item
     *
     * @param product  catalog's product
     * @param quantity product quantity
     * @return the new order item
     */
    public static OrderItem valueOf(Product product, int quantity) {
        return new OrderItem(product, quantity);
    }

    /**
     * get the order item product
     *
     * @return order item product
     */
    public Product product() {
        return product;
    }

    /**
     * get the product quantity
     *
     * @return product quantity
     */
    public int quantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order Item: " + product.basicToString() + "Quantity: " + quantity;
    }
}
