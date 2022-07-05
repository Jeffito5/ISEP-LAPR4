package eapli.base.ordermanagement.mapper;

import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.mapper.dto.OrderDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ana Rita Silva
 */
public class OrderMapper {

    /**
     * Converts an order to an order dto
     *
     * @param order order to be converted
     * @return new order dto
     */
    public OrderDTO toDTO(ProductOrder order) {
        return new OrderDTO(order);
    }

    /**
     * Converts a list of order to a list of orders dto
     *
     * @param orderList order list to be converted
     * @return new order dto list
     */
    public List<OrderDTO> toDTO(List<ProductOrder> orderList) {
        List<OrderDTO> dtoList = new ArrayList<>();
        for (ProductOrder order : orderList) {
            dtoList.add(new OrderDTO(order));
        }
        return dtoList;
    }
}
