package eapli.base.ordermanagement.application.eventhandlers;

import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.domain.events.UpdatedOrderToDeliveredEvent;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Luís Araújo
 */
public class OrderUpdatedToDeliveredController {
    /**
     * Instance of EntityManagerFactory
     */
    @PersistenceUnit
    private static EntityManagerFactory emFactory;
    /**
     * Instance of RepositoryFactory
     */
    private RepositoryFactory repositoryFactory = PersistenceContext.repositories();
    /**
     * Instance of EntityManager
     */
    private EntityManager _entityManager;

    /**
     * Method that creates the entityManagerFactory
     *
     * @return entityManagerFactory
     */
    protected EntityManagerFactory entityManagerFactory() {
        if (emFactory == null) {
            emFactory = Persistence.createEntityManagerFactory("eapli.base");
        }
        return emFactory;
    }

    /**
     * Method that creates the entityManager
     *
     * @return entityManager
     */
    protected EntityManager entityManager() {
        if (_entityManager == null || !_entityManager.isOpen()) {
            _entityManager = entityManagerFactory().createEntityManager();
        }
        return _entityManager;
    }

    /**
     * Method that changes the order status to received
     *
     * @param event
     * @return true if the status was changed and false otherwise
     */
    public boolean changeOrderStatusToReceived(final UpdatedOrderToDeliveredEvent event) {
        JpaRepository<ProductOrder, Serializable> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };

        EntityManager em = entityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        ProductOrder productOrder = repo.findById(event.identifier());
        boolean success = productOrder.receiveOrder();
        repositoryFactory.orders().save(productOrder);
        tx.commit();
        em.close();
        return success;
    }
}
