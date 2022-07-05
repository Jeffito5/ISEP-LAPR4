package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.ordermanagement.domain.Identifier;
import eapli.base.ordermanagement.domain.OrderStatus;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author Luís Araújo
 */
public class JpaOrderRepository extends JpaAutoTxRepository<ProductOrder, Identifier, Identifier> implements OrderRepository {
    public JpaOrderRepository(final TransactionalContext transactionalContext) {
        super(transactionalContext, "identifier");
    }

    public JpaOrderRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "identifier");
    }

    @Override
    public ProductOrder add(ProductOrder entity) {
        return null;
    }

    @Override
    public Optional<ProductOrder> findById(Identifier identifier) {
        final Map<String, Object> params = new HashMap<>();
        params.put("identifier", identifier);
        return matchOne("e.identifier=:identifier", params);
    }

    @Override
    public List<ProductOrder> findAll() {
        Query query = entityManager().createQuery(
                "SELECT e FROM ProductOrder e");
        List<ProductOrder> list = query.getResultList();
        return list;
    }

    @Override
    public Optional<ProductOrder> ofIdentity(Identifier id) {
        return Optional.empty();
    }

    @Override
    public boolean containsOfIdentity(Identifier id) {
        return OrderRepository.super.containsOfIdentity(id);
    }

    @Override
    public boolean contains(ProductOrder entity) {
        return OrderRepository.super.contains(entity);
    }

    @Override
    public long size() {
        return OrderRepository.super.size();
    }

    @Override
    public void remove(ProductOrder entity) {
        OrderRepository.super.remove(entity);
    }

    @Override
    public void removeOfIdentity(Identifier entityId) {
        OrderRepository.super.removeOfIdentity(entityId);
    }

    @Override
    public void forEach(Consumer<? super ProductOrder> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<ProductOrder> spliterator() {
        return super.spliterator();
    }

    /**
     * Find the paid orders
     * - Gets every order
     * - Checks if is paid
     * - If so adds to the list of paid orders
     * - Returns the paid orders
     *
     * @return paid orders
     */
    public List<ProductOrder> findPaid() {
        List<ProductOrder> paidList = new ArrayList<>();
        List<ProductOrder> all = findAll();
        for (ProductOrder order : all) {
            if (order.orderStatus().toString().equalsIgnoreCase("PAID")) {
                paidList.add(order);
            }
        }
        return paidList;
    }

    public List<ProductOrder> findNotDeliveredForCustomer(Customer customer) {
        List<ProductOrder> notDeliveredOrders = new ArrayList<>();
        Query query = Persistence.createEntityManagerFactory("eapli.base").createEntityManager().createQuery(
                "SELECT e FROM ProductOrder e WHERE e.stakeholders.customer=:customer");
        query.setParameter("customer", customer);
        for (ProductOrder order : (List<ProductOrder>) query.getResultList()) {
            if (!order.orderStatus().toString().equalsIgnoreCase("DELIVERED")) {
                notDeliveredOrders.add(order);
            }
        }
        return notDeliveredOrders;
    }

    /**
     * Method that returns a list of orders whose status is "In development"
     *
     * @return list of orders whose status is "In development"
     */
    public List<ProductOrder> listOfOrdersPreparedByAGVs() {
        Query query = Persistence.createEntityManagerFactory("eapli.base").createEntityManager().createQuery(
                "SELECT e FROM ProductOrder e WHERE e.orderStatus=:m");
        query.setParameter("m", OrderStatus.DEVELOPING);
        List<ProductOrder> list = query.getResultList();
        return list;
    }

    /**
     * Method that returns a list of orders in ascending order of its creation date
     *
     * @return list of orders in ascending order of its creation date
     */
    public List<ProductOrder> listOfOrdersInAscendingOrder() {
        Query query = Persistence.createEntityManagerFactory("eapli.base").createEntityManager().createQuery(
                "SELECT e FROM ProductOrder e WHERE e.orderStatus=:m ORDER BY e.dateTime ASC");
        query.setParameter("m", OrderStatus.PAID);
        List<ProductOrder> list = query.getResultList();
        return list;
    }

    /**
     * Method that returns a list of orders whose status is "deployed"
     *
     * @return list of orders whose status is "deployed"
     */
    public List<ProductOrder> listOfOrdersReceived() {
        Query query = Persistence.createEntityManagerFactory("eapli.base").createEntityManager().createQuery(
                "SELECT e FROM ProductOrder e WHERE e.orderStatus=:m");
        query.setParameter("m", OrderStatus.RECEIVED);
        List<ProductOrder> list = query.getResultList();
        return list;
    }
}
