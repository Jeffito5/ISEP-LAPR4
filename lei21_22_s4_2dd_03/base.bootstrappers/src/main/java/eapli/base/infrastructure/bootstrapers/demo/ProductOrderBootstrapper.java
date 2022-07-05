package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.countrymanagement.domain.Country;
import eapli.base.customermanagement.domain.*;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.application.CreateOrderController;
import eapli.base.ordermanagement.domain.*;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Luís Araújo
 */
public class ProductOrderBootstrapper implements Action {

    /**
     * Executes the bootstrap.
     * <p>For More information read Bootstraps' (US1900) README.md
     *
     * @return true if no error appeared.
     */

    @Override
    public boolean execute() {
        CreateOrderController createOrderController = new CreateOrderController();

        //Identifier
        Identifier identifier = Identifier.valueOf(123);
        Identifier identifier2 = Identifier.valueOf(21321);
        Identifier identifier3 = Identifier.valueOf(321);
        Identifier identifier4 = Identifier.valueOf(1321);
        Identifier identifier5 = Identifier.valueOf(555);
        Identifier identifier6 = Identifier.valueOf(5555);

        //Address deliveryAddress
        JpaRepository<Country, Serializable> repo1 = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        Address deliveryAddress = Address.valueOf("Street Name1", 1, "4444-4441", "City1", repo1.findById(19));

        //OrderMeasurements orderMeasurements
        OrderMeasurements orderMeasurements = OrderMeasurements.valueOf(10.0, 10.0, 10.0);

        //Payment paymentMethod
        PaymentMethod paymentMethod = PaymentMethod.PAYPAL;
        Payment payment = Payment.valueOf(paymentMethod, "CONFIRMED");

        //Stakeholders stakeholders
        JpaRepository<SystemUser, Serializable> repo2 = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        Username username = Username.valueOf("poweruser");
        List<Address> addressess = new ArrayList<>();
        addressess.add(deliveryAddress);
        JpaRepository<Customer, Serializable> repo3 = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        Stakeholders stakeholders = Stakeholders.valueOf(repo3.findById(119), repo2.findById(username), "Conversation");

        //Date dateTime
        Date date1 = new Date(2000 - 1900, Calendar.JANUARY, 15, 15, 45, 57);
        Date date2 = new Date(2000 - 1900, Calendar.FEBRUARY, 16, 10, 32, 40);
        Date date3 = new Date(2000 - 1900, Calendar.AUGUST, 17, 10, 32, 45);
        Date date4 = new Date(2000 - 1900, Calendar.AUGUST, 17, 10, 32, 50);

        //List< OrderItem > orderItems
        JpaRepository<Product, Serializable> repo4 = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        InternalCode internalCode = new InternalCode("Milk");
        OrderItem orderItem = OrderItem.valueOf(repo4.findById(internalCode), 1);
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem);

        //OrderStatus orderStatus
        OrderStatus orderStatus = OrderStatus.DEVELOPING;
        OrderStatus orderStatus2 = OrderStatus.PAID;

        createOrderController.createProductOrder(identifier, deliveryAddress, orderMeasurements, payment, stakeholders, date1, orderItemList, orderStatus);
        createOrderController.createProductOrder(identifier2, deliveryAddress, orderMeasurements, payment, stakeholders, date2, orderItemList, orderStatus);
        createOrderController.createProductOrder(identifier3, deliveryAddress, orderMeasurements, payment, stakeholders, date3, orderItemList, orderStatus2);
        createOrderController.createProductOrder(identifier4, deliveryAddress, orderMeasurements, payment, stakeholders, date4, orderItemList, orderStatus2);





        createOrderController.createProductOrder(
                Identifier.valueOf(111)
                , deliveryAddress
                ,orderMeasurements
                , payment
                , Stakeholders.valueOf(findCustomerByEmail("marcoRamos@gmail.com"),repo2.findById(username),"CONVERSATION")
                , Calendar.getInstance().getTime()
                , orderItemList
                , OrderStatus.PAID);



        return true;
    }
    public Customer findCustomerByEmail(String emailString) {
        Email email = Email.valueOf(emailString);
        CustomerRepository customerRepository = PersistenceContext.repositories().customers();

        if (customerRepository.findByEmail(email).isPresent())
            return customerRepository.findByEmail(email).get();
        return null;
    }

}