package eapli.base.ordermanagement.application;

import eapli.base.customermanagement.domain.VAT;
import eapli.base.customermanagement.dto.CustomerDTO;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.ordermanagement.domain.Identifier;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.mapper.OrderMapper;
import eapli.base.ordermanagement.mapper.dto.OrderDTO;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.infrastructure.pubsub.EventPublisher;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Luís Araújo
 */
public class UpdateOrderToDeliveredControllerEventfulImpl implements UpdateOrderToDeliveredController {
    /**
     * Instance of EntityManagerFactory
     */
    @PersistenceUnit
    private static EntityManagerFactory emFactory;
    /**
     * Instance of EventPublisher
     */
    private final EventPublisher dispatcher;
    /**
     * Instance of OrderRepository
     */
    private OrderRepository orderRepository;
    /**
     * Instance of RepositoryFactory
     */
    private RepositoryFactory repositoryFactory;
    /**
     * Instance of OrderMapper
     */
    private OrderMapper orderMapper;
    /**
     * Instance of CustomerRepository
     */
    private CustomerRepository customerRepository;
    /**
     * Instance of EntityManager
     */
    private EntityManager _entityManager;

    /**
     * Constructor that initializes all variables
     *
     * @param dispatcher
     */
    public UpdateOrderToDeliveredControllerEventfulImpl(final EventPublisher dispatcher) {
        this.dispatcher = dispatcher;
        orderRepository = PersistenceContext.repositories().orders();
        repositoryFactory = PersistenceContext.repositories();
        orderMapper = new OrderMapper();
        customerRepository = PersistenceContext.repositories().customers();
    }

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
     * Method that returns true if the order selected for the change of state to "delivered" passes through
     * the boolean method that delivers the order and false otherwise
     *
     * @param orderDTO
     * @return true if the order selected for the change of state to "delivered" passes through
     * * the boolean method that delivers the order and false otherwise
     */
    public boolean changeOrderStatusToDelivered(OrderDTO orderDTO) {
        JpaRepository<ProductOrder, Serializable> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        EntityManager em = entityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        ProductOrder productOrder = repo.findById(orderDTO.id);
        boolean success = productOrder.deliverOrder();
        repositoryFactory.orders().save(productOrder);
        tx.commit();
        em.close();
        return success;
    }

    /**
     * Method that finds an order by its id and returns that order converted to dto
     *
     * @param identifier
     * @return order converted to dto
     */
    @Override
    public OrderDTO findProductOrderById(Identifier identifier) {
        JpaRepository<ProductOrder, Serializable> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        return orderMapper.toDTO(repo.findById(identifier));
    }

    /**
     * Method that returns a list of orders received by the customer and converted to dto
     *
     * @return list of orders received by the customer and converted to dto
     */
    @Override
    public List<OrderDTO> listOfOrdersReceived() {
        return orderMapper.toDTO(orderRepository.listOfOrdersReceived());
    }

    /**
     * Method that finds a customer by an order id and converts it to dto
     *
     * @param identifier
     * @return customer converted to dto
     */
    public CustomerDTO findCustomerByOrderId(Identifier identifier) {
        JpaRepository<ProductOrder, Serializable> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };

        VAT vat = repo.findById(identifier).stakeholders().customer().vat();
        return customerRepository.findByVat(vat).get().toDTO();
    }
}
