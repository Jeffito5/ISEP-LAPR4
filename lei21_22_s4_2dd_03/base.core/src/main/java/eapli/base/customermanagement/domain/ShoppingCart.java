package eapli.base.customermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Entity
public class ShoppingCart implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @ElementCollection
    private List<CartLine> cartLines;

    private double total;

    protected ShoppingCart() {
    }

    private ShoppingCart(List<CartLine> cartLines, double total) {
        this.cartLines = cartLines;
        this.total = total;
    }

    /**
     * new constructor
     *
     * @param cartLines product and quantity map
     * @return shopping cart
     */
    public static ShoppingCart valueOf(List<CartLine> cartLines, double total) {
        return new ShoppingCart(cartLines, total);
    }

    @Override
    public String toString() {
        return "ShoppingCart:\n" +
                cartLines
                + "\nTotal: " + total + "€"
                ;
    }

    /**
     * gives cart lines
     * @return cart lines
     */
    public List<CartLine> cartLines() {
        return cartLines;
    }

    /**
     * updates the total price of shopping cart
     * @param total total price
     */
    public void updateTotal(double total){
        this.total=total;
    }

    /**
     * gives total
     * @return total
     */
    public double total() {
        return total;
    }


    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Integer identity() {
        return this.id;
    }
}
