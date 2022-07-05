package eapli.base.ordermanagement.application;

import eapli.base.customermanagement.dto.CustomerDTO;
import eapli.base.ordermanagement.domain.Identifier;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.mapper.dto.OrderDTO;

import java.util.List;

/**
 * @author Luís Araújo
 */
public interface UpdateOrderToDeliveredController {
    boolean changeOrderStatusToDelivered(OrderDTO orderDTO);

    OrderDTO findProductOrderById(Identifier identifier);

    List<OrderDTO> listOfOrdersReceived();

    CustomerDTO findCustomerByOrderId(Identifier identifier);
}
