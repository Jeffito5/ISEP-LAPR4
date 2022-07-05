package eapli.base.ordermanagement.domain;

import eapli.base.countrymanagement.domain.Country;
import eapli.base.customermanagement.domain.Address;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.ordermanagement.application.CreateOrderController;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
//TODO
/**
 * @author Luís Araújo
 */
public class ProductOrderTest {
    /**
     * Instance of CreateOrderController
     */
    CreateOrderController createOrderController = new CreateOrderController();

    /**
     * Instance of Identifier
     */
    Identifier identifier = Identifier.valueOf(123);

    /**
     * Instance of Address
     */
    JpaRepository<Country, Serializable> repo1 = new JpaRepository<>() {
        @Override
        protected String persistenceUnitName() {
            return null;
        }
    };
    Address deliveryAddress = Address.valueOf("Street Name1", 1, "4444-4441", "City1", repo1.findById(19));

    /**
     * Instance of OrderMeasurements
     */
    OrderMeasurements orderMeasurements = OrderMeasurements.valueOf(10.0, 10.0, 10.0);

    /**
     * Instance of Payment
     */
    PaymentMethod paymentMethod = PaymentMethod.PAYPAL;
    Payment payment = Payment.valueOf(paymentMethod, "CONFIRMED");

    /**
     * Instance of Stakeholders
     */
    JpaRepository<SystemUser, Serializable> repo2 = new JpaRepository<>() {
        @Override
        protected String persistenceUnitName() {
            return null;
        }
    };
    Username username = Username.valueOf("poweruser");
    List<Address> addressess = new ArrayList<>();

    JpaRepository<Customer, Serializable> repo3 = new JpaRepository<>() {
        @Override
        protected String persistenceUnitName() {
            return null;
        }
    };
    Stakeholders stakeholders = Stakeholders.valueOf(repo3.findById(38), repo2.findById(username), "Conversation");

    /**
     * Instance of Date
     */
    Date date1 = new Date(2000 - 1900, Calendar.JANUARY, 15, 15, 45, 57);

    /**
     * Instance of orderItemList
     */
    JpaRepository<Product, Serializable> repo4 = new JpaRepository<>() {
        @Override
        protected String persistenceUnitName() {
            return null;
        }
    };
    InternalCode internalCode = new InternalCode("Milk");
    OrderItem orderItem = OrderItem.valueOf(repo4.findById(internalCode), 1);
    List<OrderItem> orderItemList = new ArrayList<>();

    /**
     * Instance of OrderStatus
     */
    OrderStatus orderStatus = OrderStatus.DEVELOPING;

    /**
     * Instance of ProductOrder
     */
    ProductOrder productOrder= createOrderController.createProductOrder(identifier,deliveryAddress,orderMeasurements,payment,stakeholders,date1,orderItemList,orderStatus);


    /**
     * Test that tests the method that returns the identity
     */
//    @Test
//    public void identity() {
//        //Arrange
//        Identifier identifier = Identifier.valueOf(123);
//        addressess.add(deliveryAddress);
//        orderItemList.add(orderItem);
//
//        //Assert
//        assertEquals(identifier, productOrder.identity());
//    }
//
//    /**
//     * Test that tests the method that returns the orderMeasurements
//     */
//    @Test
//    public void orderMeasurements() {
//        //Arrange
//        OrderMeasurements orderMeasurements = OrderMeasurements.valueOf(10.0, 10.0, 10.0);
//        //addressess.add(deliveryAddress);
//        //orderItemList.add(orderItem);
//
//        //Assert
//        assertEquals(orderMeasurements, productOrder.orderMeasurements());
//    }
//
//    /**
//     * Test that tests the method that returns the orderStatus
//     */
//    @Test
//    public void orderStatus() {
//        //Arrange
//        OrderStatus orderStatus = OrderStatus.DEVELOPING;
//        addressess.add(deliveryAddress);
//        orderItemList.add(orderItem);
//
//        //Assert
//        assertEquals(orderStatus, productOrder.orderStatus());
//    }
}