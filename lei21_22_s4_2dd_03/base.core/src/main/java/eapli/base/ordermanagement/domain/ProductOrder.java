package eapli.base.ordermanagement.domain;

import eapli.base.customermanagement.domain.Address;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 1201217 Marco Ramos
 * @author Ana Rita Silva
 */
@Entity
public class ProductOrder implements Serializable, AggregateRoot<Identifier> {

    @EmbeddedId
    private Identifier identifier;

    private Date dateTime;

    @Embedded
    private Address deliveryAddress;

    @Embedded
    private Payment paymentMethod;

    @Embedded
    private Stakeholders stakeholders;

    @Embedded
    private OrderMeasurements orderMeasurements;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ElementCollection
    private List<OrderItem> orderItems;


    protected ProductOrder() {
    }

    protected ProductOrder(Identifier identifier, Address deliveryAddress, OrderMeasurements orderMeasurements, Payment paymentMethod, Stakeholders stakeholders, Date dateTime, List<OrderItem> orderItems, OrderStatus orderStatus) {
        this.identifier = identifier;
        this.dateTime = dateTime;
        this.orderItems = orderItems;
        this.deliveryAddress = deliveryAddress;
        this.orderMeasurements = orderMeasurements;
        this.paymentMethod = paymentMethod;
        this.stakeholders = stakeholders;
        this.orderStatus = orderStatus;
    }

    /**
     * create the new order
     *
     * @param identifier        order identifier
     * @param deliveryAddress   order delivery address
     * @param orderMeasurements order weight, price and volume
     * @param paymentMethod     payment method
     * @param stakeholders      order stakeholders (customer, system user and the conversation between them when there is)
     * @param dateTime          order's exact time
     * @param orderItems        order items
     * @param orderStatus       order status
     * @return the new order
     */
    public static ProductOrder valueOf(Identifier identifier, Address deliveryAddress, OrderMeasurements orderMeasurements, Payment paymentMethod, Stakeholders stakeholders, Date dateTime, List<OrderItem> orderItems, OrderStatus orderStatus) {
        return new ProductOrder(identifier, deliveryAddress, orderMeasurements, paymentMethod, stakeholders, dateTime, orderItems, orderStatus);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Identifier identity() {
        return this.identifier;
    }

    /**
     * Returns the order's measurements
     *
     * @return order's measurements
     */
    public OrderMeasurements orderMeasurements() {
        return this.orderMeasurements;
    }

    public Stakeholders stakeholders() {
        return stakeholders;
    }

    /**
     * Returns the order's status
     *
     * @return order's status
     */
    public OrderStatus orderStatus() {
        return this.orderStatus;
    }

    public List<OrderItem> items(){
        return new ArrayList<>(orderItems);
    }

    public Date dateTime(){
        return dateTime;
    }

    /**
     * Changes the current status to the new status
     * - Checks which status is the new one and changes the current one
     *
     * @param newStatus new status
     * @return true if success, false otherwise
     */
    private boolean changeStatus(String newStatus) {
        if (newStatus.equalsIgnoreCase(OrderStatus.PAID.toString())) {
            this.orderStatus = OrderStatus.PAID;
        } else if (newStatus.equalsIgnoreCase(OrderStatus.DEVELOPING.toString())) {
            this.orderStatus = OrderStatus.DEVELOPING;
        } else if (newStatus.equalsIgnoreCase(OrderStatus.DEPLOYED.toString())) {
            this.orderStatus = OrderStatus.DEPLOYED;
        } else if (newStatus.equalsIgnoreCase(OrderStatus.RECEIVED.toString())) {
            this.orderStatus = OrderStatus.RECEIVED;
        } else if (newStatus.equalsIgnoreCase(OrderStatus.DELIVERED.toString())) {
            this.orderStatus = OrderStatus.DELIVERED;
        } else {
            return false;
        }
        return true;
    }

    /**
     * Changes the current status to paid
     * - As soon as the order is paid the specified order changes its status to paid
     *
     * @return boolean if success, false otherwise
     */
    public boolean payOrder() {
        return changeStatus(OrderStatus.PAID.toString());
    }

    /**
     * Changes the current status to developing
     * - As soon as an AGV starts to perform the order the specified order changes its status to developing
     *
     * @return boolean if success, false otherwise
     */
    public boolean developOrder() {
        return changeStatus(OrderStatus.DEVELOPING.toString());
    }

    /**
     * Method that returns true if the order status was successfully changed to the state of deployed and false otherwise
     *
     * @return true if the order status was successfully changed to the state of deployed and false otherwise
     */
    public boolean deployOrder() {
        return changeStatus(OrderStatus.DEPLOYED.toString());
    }

    /**
     * Method that returns true if the order status was successfully changed to the state of received and false otherwise
     *
     * @return true if the order status was successfully changed to the state of received and false otherwise
     */
    public boolean receiveOrder() {
        return changeStatus(OrderStatus.RECEIVED.toString());
    }

    /**
     * Method that returns true if the order status was successfully changed to the state of received and false otherwise
     *
     * @return true if the order status was successfully changed to the state of received and false otherwise
     */
    public boolean deliverOrder() {
        return changeStatus(OrderStatus.DELIVERED.toString());
    }

    @Override
    public String toString() {
        return "ProductOrder:" +
                "identifier=" + identifier + "\n" +
                "dateTime=" + dateTime + "\n" +
                "deliveryAddress=" + deliveryAddress + "\n" +
                "paymentMethod=" + paymentMethod + "\n" +
                "stakeholders=" + stakeholders + "\n" +
                "orderMeasurements=" + orderMeasurements + "\n" +
                "orderItems=" + orderItems + "\n" +
                "orderStatus=" + orderStatus + "\n";
    }

    public String basicToString() {
        return "\nProduct Order Information:\n" +
                "Identifier: " + identifier.identifier() + "\n" +
                "Date Time: " + dateTime.toString() + "\n" +
                "Order Status: " + orderStatus.toString() + "\n\n" +
                "Product Information:\n" + orderItems;
    }
}
