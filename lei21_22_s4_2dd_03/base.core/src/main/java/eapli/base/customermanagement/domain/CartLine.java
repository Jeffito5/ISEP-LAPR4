package eapli.base.customermanagement.domain;

import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.model.ValueObject;


import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Embeddable
public class CartLine implements ValueObject, Serializable {

    @OneToOne
    private Product product;

    private Integer quantity;

    protected CartLine() {

    }

    protected CartLine(Product product, Integer quantity) {
        ruleQuantity(quantity);
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * new contructor
     *
     * @param product  product
     * @param quantity quantity
     * @return cart line
     */
    public static CartLine valueOf(Product product, Integer quantity) {
        return new CartLine(product, quantity);
    }

    /**
     * gives quantity
     * @return quantity
     */
    public Integer quantity() {
        return quantity;
    }

    /**
     * rule quantity
     * @param quantity quantity
     */
    private void ruleQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity invalid.");
        }
    }

    /**
     * gives product
     * @return product
     */
    public Product product() {
        return product;
    }

    @Override
    public String toString() {
        return  "Product: " + product.internalCode() +
                " Description: " + product.shortDescription() +
                " Brand Name: " + product.brandName() +
                " Price: " + product.priceWithTax() +
                " Quantity: " + quantity
                ;
    }
}
