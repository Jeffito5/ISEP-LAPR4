package eapli.base.app.backoffice.console.presentation.salesclerk;

import eapli.base.Utils;
import eapli.base.customermanagement.dto.CustomerDTO;
import eapli.base.ordermanagement.application.UpdateOrderToDeliveredController;
import eapli.base.ordermanagement.application.UpdateOrderToDeliveredFactory;
import eapli.base.ordermanagement.mapper.dto.OrderDTO;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

/**
 * @author Luís Araújo
 */
public class UpdateOrderToDeliveredUI extends AbstractUI {

    private UpdateOrderToDeliveredController controller = UpdateOrderToDeliveredFactory.build();

    @Override
    protected boolean doShow() {
        try {
            int option;
            List<OrderDTO> listOrderDTO = controller.listOfOrdersReceived();

            System.out.println(listOrderDTO);

            option = Utils.showAndSelectIndex(listOrderDTO, "\nSelect the order that has been received");

            if (option == -1) {
                return false;
            }

            OrderDTO orderDTO = listOrderDTO.get(option);

            if (controller.changeOrderStatusToDelivered(controller.findProductOrderById(orderDTO.id)))
                System.out.println("\nThe order status was changed to delivered successfully\n");

            System.out.println("--------------------------------------------------Order's status updated----------------------------------------------------\n");
            System.out.println(controller.findProductOrderById(orderDTO.id).toString());
            System.out.println("----------------------------------------------------Customer information----------------------------------------------------\n");
            CustomerDTO customerDTO = controller.findCustomerByOrderId(orderDTO.id);
            System.out.println("Name: " + customerDTO.name + "\nVAT: " + customerDTO.vat + "\n");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Update order to dispatched for customer delivery";
    }
}
