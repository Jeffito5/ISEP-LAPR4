package eapli.base.ordermanagement.mapper.dto;

import eapli.base.ordermanagement.domain.Identifier;
import eapli.base.ordermanagement.domain.ProductOrder;

/**
 * @author Ana Rita Silva
 */
public class OrderDTO {

    public Identifier id;
    public String toString;

    /**
     * Converts an order to an order DTO
     *
     * @param order order to be converted
     */
    public OrderDTO(ProductOrder order) {
        this.id = order.identity();
        this.toString = order.basicToString();
    }

    @Override
    public String toString() {
        return toString;
    }
}
