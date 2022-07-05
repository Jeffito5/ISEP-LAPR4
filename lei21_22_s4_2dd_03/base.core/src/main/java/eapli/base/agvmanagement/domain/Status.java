package eapli.base.agvmanagement.domain;

import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.io.Serializable;


/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 * @author Ana Rita Silva
 */
@Embeddable
public class Status implements ValueObject, Serializable {

    public static final String FREE = "Free";
    public static final String OCCUPIED = "Occupied";
    public static final String MAINTENANCE = "Maintenance";
    public static final String CHARGING = "Charging";

    private String status;
    @OneToOne
    private ProductOrder order;

    protected Status() {
    }

    protected Status(String status) {
        ruleStatus(status);
        this.status = status;
    }

    /**
     * new constructor
     *
     * @param status status
     * @return status
     */
    public static Status valueOf(String status) {
        return new Status(status.toUpperCase());
    }

    /**
     * status rules
     *
     * @param status status
     */
    private void ruleStatus(String status) {
        if (status.isBlank())
            throw new IllegalArgumentException("Invalid status.");
        if (!status.equalsIgnoreCase(FREE) && !status.equalsIgnoreCase(CHARGING) && !status.equalsIgnoreCase(OCCUPIED) && !status.equalsIgnoreCase(MAINTENANCE))
            throw new IllegalArgumentException("Invalid status.");
    }

    /**
     * Returns the current status
     *
     * @return status
     */
    public String status() {
        return this.status;
    }

    public ProductOrder productOrder() {
        return this.order;
    }

    /**
     * Changes the current status to the new status
     * - Verifies if the new status is valid
     * - If so changes the status
     *
     * @param status new status
     * @return true if success, false otherwise
     */
    public boolean changeStatus(String status) {
        try {
            ruleStatus(status);
            this.status = status;
            return true;
        } catch (IllegalArgumentException ignored) {
            return false;
        }
    }

    /**
     * Assigns a new order
     * - Changes the current order to the new one
     * - Changes the status to "occupied"
     *
     * @param order new order
     * @return true if success, false otherwise
     */
    public boolean assignOrder(ProductOrder order) {
        this.order = order;
        return changeStatus(OCCUPIED);
    }

    /**
     * Changes the status of the agv to "free" after the order was deployed
     *
     * @return true if success and false otherwise
     */
    public boolean deployOrder() {
        return changeStatus(FREE);
    }

    @Override
    public String toString() {
        return "The current AGV status is: " + status + ".";
    }
}
