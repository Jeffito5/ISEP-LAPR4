package eapli.base.ordermanagement.application;

import eapli.base.countrymanagement.domain.Country;
import eapli.base.countrymanagement.repository.CountryRepository;
import eapli.base.customermanagement.domain.Address;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.domain.VAT;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.*;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author 1201217 Marco Ramos
 */
public class CreateOrderController {

    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();

    private final CountryRepository countryRepository = PersistenceContext.repositories().countries();

    private final ProductRepository productRepository = PersistenceContext.repositories().products();
    private final List<OrderItem> orderItemList = new ArrayList<>();
    private Customer customer;
    private Country deliveryAddressCountry;
    private OrderMeasurements orderMeasurements;

    /**
     * find a customer in the database with his vat
     *
     * @param vatString vat
     * @return if the customer was or wasn't in the database
     */
    public boolean findCustomer(String vatString) {
        VAT vat = VAT.valueOf(vatString);

        if (customerRepository.findByVat(vat).isPresent()) {
            customer = customerRepository.findByVat(vat).get();
            return true;
        } else {
            return false;
        }
    }

    /**
     * create or find the country in the database
     *
     * @param countryString Country name
     * @return if the country was or wasn't already in the database
     */
    public boolean createCountry(String countryString) {
        if (countryRepository.findByName(countryString.toUpperCase()).isPresent()) {
            deliveryAddressCountry = countryRepository.findByName(countryString.toUpperCase()).get();
            return false;
        } else {
            deliveryAddressCountry = Country.valueOf(countryString);
            countryRepository.save(deliveryAddressCountry);
            return true;
        }
    }

    /**
     * @return payment method values
     */
    public PaymentMethod[] getPaymentMethods() {
        return PaymentMethod.values();
    }

    /**
     * choose the payment method
     *
     * @param pmIndex payment method index
     * @return payment method
     */
    private PaymentMethod choosePaymentMethod(int pmIndex) {
        for (PaymentMethod paymentMethod : getPaymentMethods())
            if (paymentMethod.getI() == pmIndex)
                return paymentMethod;

        return null;
    }

    /**
     * list the products catalog
     *
     * @return product's catalog
     */
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    /**
     * Add a product to an order item
     *
     * @param product  Catalog product
     * @param quantity product quantity
     */
    public void addOrderItem(Product product, int quantity) {
        orderItemList.add(OrderItem.valueOf(product, quantity));
    }

    /**
     * create the Order measurements
     *
     * @return the order price for the customer to pay
     */
    public double createOrderMeasurements() {
        double maxPrice = 0;
        double volume = 0;
        double maxWeight = 0;
        for (OrderItem orderItem : orderItemList) {
            maxPrice += orderItem.product().priceWithTax().priceWithTax() * orderItem.quantity();
            volume += orderItem.product().productMeasurements().height() * orderItem.product().productMeasurements().length() * orderItem.product().productMeasurements().width() * orderItem.quantity();
            maxWeight += orderItem.product().productMeasurements().weight() * orderItem.quantity();
        }
        orderMeasurements = OrderMeasurements.valueOf(maxPrice, volume, maxWeight);
        return maxPrice;
    }

    /**
     * create the new order and save it in the database
     *
     * @param id           order identification
     * @param street       address street
     * @param doorNumber   address door number
     * @param postalNumber address postal number
     * @param city         address city
     * @param conversation conversation between the stakeholders
     * @param user         System User Sales Clerk
     * @param pmIndex      payment Method index
     * @param confirmation payment confirmation
     * @return order
     */
    public ProductOrder createOrder(int id,
                                    String street, int doorNumber, String postalNumber, String city,
                                    String conversation, SystemUser user,
                                    int pmIndex, String confirmation) {
        Identifier identifier = Identifier.valueOf(id);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        Address deliveryAddress = Address.valueOf(street, doorNumber, postalNumber, city, deliveryAddressCountry);

        Stakeholders stakeholders = Stakeholders.valueOf(customer, user, conversation);


        Payment payment = Payment.valueOf(choosePaymentMethod(pmIndex), confirmation);

        ProductOrder order = ProductOrder.valueOf(identifier, deliveryAddress, orderMeasurements, payment, stakeholders, date, orderItemList, OrderStatus.PAID);

        JpaRepository<ProductOrder, Serializable> repository = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };

        repository.add(order);

        return order;
    }

    public ProductOrder createProductOrder(Identifier identifier, Address deliveryAddress, OrderMeasurements orderMeasurements, Payment paymentMethod, Stakeholders stakeholders, Date dateTime, List<OrderItem> orderItems, OrderStatus orderStatus) {
        JpaRepository<ProductOrder, Serializable> repository = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        ProductOrder order = ProductOrder.valueOf(identifier, deliveryAddress, orderMeasurements, paymentMethod, stakeholders, dateTime, orderItems, orderStatus);
        repository.add(order);
        return order;
    }
}
