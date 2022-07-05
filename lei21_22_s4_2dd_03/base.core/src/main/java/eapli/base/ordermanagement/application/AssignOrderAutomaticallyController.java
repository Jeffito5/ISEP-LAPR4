package eapli.base.ordermanagement.application;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.mapper.AGVMapper;
import eapli.base.agvmanagement.mapper.dto.AGVDTO;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Identifier;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.mapper.OrderMapper;
import eapli.base.ordermanagement.mapper.dto.OrderDTO;
import eapli.base.ordermanagement.repositories.OrderRepository;

import java.io.Serializable;
import java.util.*;

/**
 * @author Luís Araújo
 */
public class AssignOrderAutomaticallyController {
    private final AGVRepository agvRepository;
    private final AGVMapper agvMapper;
    /**
     * Instance of OrderMapper
     */
    private OrderMapper orderMapper;
    /**
     * Instance of OrderRepository
     */
    private OrderRepository orderRepository;
    /**
     * Queue with the orders that need to be executed by the AGV
     */
    private Queue<ProductOrder> listOfOrdersInQueue;
    private ProductOrder order;

    /**
     * Constructor that initializes all the variables
     */
    public AssignOrderAutomaticallyController() {
        this.orderMapper = new OrderMapper();
        this.agvRepository = PersistenceContext.repositories().agvs();
        this.orderRepository = PersistenceContext.repositories().orders();
        this.agvMapper = new AGVMapper();
        listOfOrdersInQueue = new LinkedList<>();
    }

    /**
     * Method that adds an order to the queue and returns true if the operation was a success and false otherwise
     *
     * @return true if the operation of adding an order to the queue was a success and false otherwise
     */
    public boolean addOrdersToQueue() {
        return listOfOrdersInQueue.addAll(orderRepository.listOfOrdersInAscendingOrder());
    }

    /**
     * Method that removes an order from the queue and converts it to a OrderDTO
     *
     * @return order from the queue and converts it to a OrderDTO
     */
    public OrderDTO removeFirstOrderFromQueue() {
        return orderMapper.toDTO(listOfOrdersInQueue.remove());
    }

    /**
     * Method that returns the size of the queue
     *
     * @return size of the queue
     */
    public int sizeOfListOfOrdersInQueue() {
        return listOfOrdersInQueue.size();
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
     * List the agv able to perform the specified order
     * - Verifies which agvs are available
     * - Checks which agvs can carry the volume and weight of the order
     *
     * @param order specified order
     * @return list of able agvs
     */
    public List<AGVDTO> listAgvAble(OrderDTO order) {
        Optional<ProductOrder> optional = this.orderRepository.findById(order.id);
        if (optional.isPresent()) {
            this.order = optional.get();
            return agvMapper.toDTO(this.agvRepository.isAble(this.order));
        }

        return Collections.emptyList();
    }

    /**
     * Assign the specified order to the specified agv
     * - First assigns the order to the agv and changes its status to occupied
     * - Second changes the order status to "developing"
     * - Finally saves the changes made in the respective repositories
     *
     * @return true if success, false otherwise
     */
    public boolean assignOrder(AGVDTO agvDto) {
        Optional<AGV> optional = this.agvRepository.findByIdentifier(agvDto.identifier);
        if (optional.isPresent()) {
            AGV agv = optional.get();
            boolean successAgv = agv.assignOrder(this.order);
            boolean successOrder = this.order.developOrder();
            agvRepository.save(agv);
            orderRepository.save(this.order);
            return (successAgv && successOrder);
        }
        return false;
    }

    /**
     * Method that verifies if the time is correct
     *
     * @param time
     * @param unitOfTime
     * @return true if the time is correct and false otherwise
     */
    public boolean checkIfTimeIsCorrect(int time, String unitOfTime) {
        if (time <= 0) {
            System.out.println("Time is wrong. Try again");
            return false;
        }

        switch (unitOfTime) {
            case "minute":
                if (time > 60)
                    return false;
                return true;

            case "hour":
                if (time > 24)
                    return false;
                return true;

            case "day":
                if (time > 30)
                    return false;
                return true;

            default:
                System.out.println("Unit of time is wrong. Try again");
                return false;
        }
    }
}
