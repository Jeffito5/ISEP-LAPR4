package eapli.base.ordermanagement.application;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.mapper.AGVMapper;
import eapli.base.agvmanagement.mapper.dto.AGVDTO;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.mapper.OrderMapper;
import eapli.base.ordermanagement.mapper.dto.OrderDTO;
import eapli.base.ordermanagement.repositories.OrderRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Ana Rita Silva
 */
public class AssignOrderController {

    private final OrderRepository orderRepository;
    private final AGVRepository agvRepository;
    private final AGVMapper agvMapper;
    private final OrderMapper orderMapper;
    private ProductOrder order;

    /**
     * Controller's constructor
     * - Initializes the AGV and Order repositories
     */
    public AssignOrderController() {
        this.orderRepository = PersistenceContext.repositories().orders();
        this.agvRepository = PersistenceContext.repositories().agvs();
        this.agvMapper = new AGVMapper();
        this.orderMapper = new OrderMapper();
    }

    /**
     * Lists the order with the status "paid"
     * - Uses the method developed in the orders' repository
     *
     * @return list of paid orders
     */
    public List<OrderDTO> listPaidOrders() {
        return orderMapper.toDTO(this.orderRepository.findPaid());
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
}
