package eapli.base.ordermanagement.application;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.domain.Email;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.mapper.OrderMapper;
import eapli.base.ordermanagement.mapper.dto.OrderDTO;
import eapli.base.ordermanagement.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;


public class CheckOrderStatusController {


    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private Customer customer;

    public String customer(String email) {
        if (customerRepository.findByEmail(Email.valueOf(email)).isPresent()) {
            customer = customerRepository.findByEmail(Email.valueOf(email)).get();
            return customer.toString();
        } else
            return "No Customer associated with " + email;
    }

    public String checkOrderStatus() {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        List<ProductOrder> orderList = orderRepository.findNotDeliveredForCustomer(customer);
        for (ProductOrder order : orderList) {
            orderDTOList.add(new OrderMapper().toDTO(order));
        }
        return orderDTOList.toString();
    }

}
