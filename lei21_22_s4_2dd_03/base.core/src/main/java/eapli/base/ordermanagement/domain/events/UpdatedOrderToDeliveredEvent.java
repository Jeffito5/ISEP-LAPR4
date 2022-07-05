package eapli.base.ordermanagement.domain.events;

import eapli.base.ordermanagement.domain.Identifier;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.framework.domain.events.DomainEventBase;

/**
 * @author Luís Araújo
 */
public class UpdatedOrderToDeliveredEvent extends DomainEventBase {
    /**
     * Version
     */
    private static final long serialVersionUID = 1L;
    /**
     * Instance of ProductOrder
     */
    private final ProductOrder productOrder;

    /**
     * Constructor that initializes the variable
     *
     * @param productOrder
     */
    public UpdatedOrderToDeliveredEvent(final ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    /**
     * Method that returns the id of the order
     *
     * @return id of the order
     */
    public Identifier identifier() {
        return productOrder.identity();
    }

    @Override
    public String toString() {
        return "UpdatedOrderToDeliveredEvent -> Order ID: " + productOrder.identity();
    }
}
