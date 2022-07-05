package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.Code;
import eapli.base.countrymanagement.domain.Country;
import eapli.base.customermanagement.domain.Address;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.domain.Email;
import eapli.base.customermanagement.domain.VAT;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.ordermanagement.domain.OrderItem;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.productmanagement.domain.BrandName;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.surveymanagement.domain.survey.TargetAudience;
import eapli.base.surveymanagement.domain.survey.TimeInterval;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.naming.OperationNotSupportedException;
import javax.persistence.Query;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author 1201217 Marco Ramos
 */
public class JpaCustomerRepository extends JpaAutoTxRepository<Customer, Integer, Integer>
        implements CustomerRepository {


    public JpaCustomerRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaCustomerRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }


    @Override
    public Optional<Customer> findByVat(VAT vat) {
        final Map<String, Object> params = new HashMap<>();
        params.put("vat", vat);
        return matchOne("e.vat=:vat", params);
    }

    @Override
    public Optional<Customer> findByEmail(Email email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        return matchOne("e.email=:email", params);
    }

    @Override
    public List<Customer> findByTarget(TargetAudience target) {

        switch (target.targetType()) {

            case GENDER:
                return findCustomersByGender(target.codes().get(0));

            case COUNTRY:
                return findCustomerByCountry(target.codes().get(0));

            case CATEGORY:
                List<Customer> result = new ArrayList<>();
                for (String code : target.codes())
                    result.addAll(findCustomerByCategory(code, target.getDayCount()));
                return result;

            case PRODUCT:
                result = new ArrayList<>();
                for (String code : target.codes())
                    result.addAll(findCustomerByProduct(code, target.getDayCount()));
                return result;


            case BRAND:
                result = new ArrayList<>();
                for (String code : target.codes())
                    result.addAll(findCustomerByBrand(code, target.getDayCount(),result));
                return result;

            default:
                return new ArrayList<>();
        }

    }

    public List<Customer> findCustomersByGender(String gender) {
        Query query = entityManager().createQuery(
                "SELECT c FROM Customer c WHERE (c.gender.gender = ?1)"
        );
        query.setParameter(1, gender);
        return query.getResultList();
    }

    public List<Customer> findCustomerByCountry(String country) {
        List<Customer> customerList = (List<Customer>) findAll();
        List<Customer> result = new ArrayList<>();
        for (Customer customer : customerList) {
            for (Address address : customer.billingAddress()) {
                if (!result.contains(customer) && address.country().name().equals(country)) {
                    result.add(customer);
                }
            }
        }
        return result;
    }

    public List<Customer> findCustomerByCategory(String code, TimeInterval timeInterval) {
        List<Customer> customers = new ArrayList<>();
        Query query = entityManager().createQuery(
                "SELECT po FROM ProductOrder po"
        );
        List<ProductOrder> orders = query.getResultList();

        for (ProductOrder order : orders) {
            List<OrderItem> items = order.items();
            for (OrderItem item : items) {
                if (item.product().category().code().compareTo(new Code(code)) == 0 && timeInterval.inInterval(order.dateTime()) && !customers.contains(order.stakeholders().customer())) {
                    customers.add(order.stakeholders().customer());
                }
            }
        }
        return customers;
    }

    public List<Customer> findCustomerByProduct(String code, TimeInterval timeInterval) {
        List<Customer> customers = new ArrayList<>();
        Query query = entityManager().createQuery(
                "SELECT po FROM ProductOrder po"
        );
        List<ProductOrder> orders = query.getResultList();

        for (ProductOrder order : orders) {
            List<OrderItem> items = order.items();
            for (OrderItem item : items) {
                if (item.product().compareTo(new InternalCode(code)) == 0 && timeInterval.inInterval(order.dateTime()) && !customers.contains(order.stakeholders().customer())) {
                    customers.add(order.stakeholders().customer());
                }
            }
        }
        return customers;
    }

    public List<Customer> findCustomerByBrand(String code, TimeInterval timeInterval,List<Customer> customers) {
        Query query = entityManager().createQuery(
                "SELECT po FROM ProductOrder po"
        );
        List<ProductOrder> orders = query.getResultList();
        for (ProductOrder order : orders) {
            List<OrderItem> items = order.items();
            for (OrderItem item : items) {
                if (item.product().brandName().compareTo(new BrandName(code)) == 0 && timeInterval.inInterval(order.dateTime()) && !customers.contains(order.stakeholders().customer())) {
                    customers.add(order.stakeholders().customer());
                }
            }
        }
        return customers;
    }


    @Override
    public boolean containsOfIdentity(Integer id) {
        return CustomerRepository.super.containsOfIdentity(id);
    }

    @Override
    public boolean contains(Customer entity) {
        return CustomerRepository.super.contains(entity);
    }

    @Override
    public long size() {
        return CustomerRepository.super.size();
    }

    @Override
    public void remove(Customer entity) {
        CustomerRepository.super.remove(entity);
    }

    @Override
    public void removeOfIdentity(Integer entityId) {
        CustomerRepository.super.removeOfIdentity(entityId);
    }

    @Override
    public void forEach(Consumer<? super Customer> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<Customer> spliterator() {
        return super.spliterator();
    }
}
