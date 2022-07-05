package eapli.base.app.backoffice.console.presentation.warehouseemployee;

import eapli.base.Utils;
import eapli.base.agvmanagement.mapper.dto.AGVDTO;
import eapli.base.ordermanagement.application.UpdateOrderController;
import eapli.base.ordermanagement.mapper.dto.OrderDTO;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

/**
 * @author Luís Araújo
 */
public class UpdateOrderUI extends AbstractUI {

    private final UpdateOrderController updateOrderController = new UpdateOrderController(InProcessPubSub.publisher());

    @Override
    protected boolean doShow() {
        try {
            int option, option2;
            System.out.println();
            System.out.println("------------------------Select one of the AGVs that has been preparing an order------------------------------------------\n");

            List<AGVDTO> agvdtoList = updateOrderController.findAGVOccupied();

            if (agvdtoList.isEmpty()) {
                System.out.println("\nThere are no AGVs occupied");
                return false;
            }

            option = Utils.showAndSelectIndex(agvdtoList, "\nSelect the intended AGV");

            if (option == -1) {
                return false;
            }

            AGVDTO agv = agvdtoList.get(option);
            eapli.base.agvmanagement.domain.Identifier identifier = agv.identifier;

            List<OrderDTO> listOrderDTO = updateOrderController.findOrderByAGVId(identifier);

            option2 = Utils.showAndSelectIndex(listOrderDTO, "\nSelect the order that has been prepared by the AGV");

            if (option2 == -1) {
                return false;
            }

            OrderDTO orderDTO = listOrderDTO.get(option2);

            if (updateOrderController.changeOrderStatusToDispatchedForDelivery(updateOrderController.findProductOrderById(orderDTO.id)))
                System.out.println("\nThe order status was changed to dispatched for delivery successfully\n");
            if (!updateOrderController.findAGVByOrderIdAndChangeStatus(orderDTO.id))
                System.out.println("\nAn error occurred with the AGV status\n");

            System.out.println("--------------------------------------------------Order's status updated----------------------------------------------------\n");
            System.out.println(updateOrderController.findProductOrderById(orderDTO.id).toString());

            updateOrderController.publishEvent(updateOrderController.findProductOrderById(orderDTO.id));

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
