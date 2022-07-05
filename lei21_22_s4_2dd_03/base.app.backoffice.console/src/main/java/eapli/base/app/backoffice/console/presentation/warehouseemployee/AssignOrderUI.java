package eapli.base.app.backoffice.console.presentation.warehouseemployee;

import eapli.base.Utils;
import eapli.base.app.backoffice.console.presentation.AGVOccupiedEvent;
import eapli.base.app.backoffice.console.presentation.TcpBackofficeClient;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ana Rita Silva
 */
public class AssignOrderUI extends AbstractUI {

    private final TcpBackofficeClient tcpBackofficeClient = new TcpBackofficeClient();

    @Override
    protected boolean doShow() {
        try {
            tcpBackofficeClient.run();
            tcpBackofficeClient.writeByte(1000, (byte) 3, "");

            String orderList = tcpBackofficeClient.readByte(100000);

            if (orderList.equals("-1")) {
                System.out.println("There are no paid orders at the moment.");
                return false;
            }

            List<String> list = Arrays.asList(orderList.split(","));
            int choice = Utils.showAndSelectIndex(list, "Select the intended order.");

            String orderString = list.get(choice);

            if (choice == -1) {
                return false;
            }
            tcpBackofficeClient.writeByte(1000, (byte) 3, String.valueOf(choice));

            String agvList = tcpBackofficeClient.readByte(100000);
            if (agvList.equals("-1")) {
                System.out.println("There are no agv available/able to perform the specified order.");
                return false;
            }

            list = Arrays.asList(agvList.split(","));
            choice = Utils.showAndSelectIndex(list, "Select the intended agv.");

            String agvString = list.get(choice);

            if (choice == -1) {
                return false;
            }
            tcpBackofficeClient.writeByte(1000, (byte) 3, String.valueOf(choice));

            String option = tcpBackofficeClient.readByte(1000);


            list = Arrays.asList(agvString.split("'"));
            String agvIdentifier = list.get(1);

            list = Arrays.asList(orderString.split(" "));
            String something = list.get(3);
            list = Arrays.asList(something.split("\n"));
            String orderIdentifier = list.get(0);

            if (option.equals("1")) {
                AGVOccupiedEvent.event(agvIdentifier, orderIdentifier);
                System.out.println("The order was assigned to the AGV successfully!!");
                return true;
            }
            if (option.equals("-1")) {
                System.out.println("Something went wrong, try again!");
                return false;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;
    }

    @Override
    public String headline() {
        return "Assign order to an AGV";
    }
}
