package eapli.base.ordermanagement.application;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.mapper.AGVMapper;
import eapli.base.agvmanagement.mapper.dto.AGVDTO;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.ordermanagement.domain.Identifier;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.domain.events.UpdatedOrderToDeliveredEvent;
import eapli.base.ordermanagement.mapper.OrderMapper;
import eapli.base.ordermanagement.mapper.dto.OrderDTO;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Luís Araújo
 */
public class UpdateOrderController {
    /**
     * Instance of repository factory
     */
    private final RepositoryFactory repositoryFactory;
    /**
     * Instance of agv repository
     */
    private final AGVRepository agvRepository;
    /**
     * Instance of OrderMapper
     */
    private final OrderMapper orderMapper;

    private final AGVMapper agvMapper;

    private final EventPublisher dispatcher;

    /**
     * Constructor that initializes all the variables
     */
    public UpdateOrderController(final EventPublisher eventPublisher) {
        repositoryFactory = PersistenceContext.repositories();
        agvRepository = PersistenceContext.repositories().agvs();
        this.orderMapper = new OrderMapper();
        this.agvMapper = new AGVMapper();
        this.dispatcher = eventPublisher;
    }

    /**
     * Method that returns true if the order selected for the change of state to "dispatched for customer delivery" passes through
     * the boolean method that deploys the order and false otherwise
     *
     * @param orderDTO
     * @return true if the order selected for the change of state to "dispatched for customer delivery" passes through
     * * the boolean method that deploys the order and false otherwise
     */
    public boolean changeOrderStatusToDispatchedForDelivery(OrderDTO orderDTO) {
        JpaRepository<ProductOrder, Serializable> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        ProductOrder productOrder = repo.findById(orderDTO.id);
        boolean success = productOrder.deployOrder();
        repositoryFactory.orders().save(productOrder);
        return success;
    }

    /**
     * Method that finds a product order in the repository using its identifier
     *
     * @param identifier
     * @return a product order in the repository using its identifier
     */
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
     * Method that finds an agv by the id of the order that he is executing and changes its status
     *
     * @param identifier
     * @return true if the status of the agv found was modified and false otherwise
     */
    public boolean findAGVByOrderIdAndChangeStatus(Identifier identifier) {
        AGV agv = agvRepository.findAGVByOrderId(identifier).get(0);
        boolean success = agv.deployOrder();
        agvRepository.save(agv);
        return success;
    }

    public void publishEvent(OrderDTO orderDTO){
        JpaRepository<ProductOrder, Serializable> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };

        ProductOrder productOrder = repo.findById(orderDTO.id);
        // notify interested parties (if any)
        final DomainEvent event = new UpdatedOrderToDeliveredEvent(productOrder);
        dispatcher.publish(event);
    }

    /**
     * Method that finds all the AGVs occupied
     * @return list with all the AGVs occupied
     */
    public List<AGVDTO> findAGVOccupied() {
        return agvMapper.toDTO(agvRepository.findAGVOccupied());
    }

    /**
     * Method that returns a list of orders that have been prepared by a certain agv
     *
     * @return list of orders that have been prepared by a certain agv
     */
    public List<OrderDTO> findOrderByAGVId(eapli.base.agvmanagement.domain.Identifier identifier) {
        AGV agv = agvRepository.findByIdentifier(identifier).get();
        ProductOrder productOrder = agv.agvStatus().productOrder();
        List<ProductOrder> list = new ArrayList<>();
        list.add(productOrder);
        return orderMapper.toDTO(list);
    }
}

