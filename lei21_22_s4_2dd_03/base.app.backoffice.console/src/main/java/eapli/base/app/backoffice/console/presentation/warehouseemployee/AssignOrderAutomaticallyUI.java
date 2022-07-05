package eapli.base.app.backoffice.console.presentation.warehouseemployee;

import eapli.base.Utils;
import eapli.base.app.backoffice.console.presentation.TcpBackofficeClient;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Luís Araújo
 * @author Ana Rita Silva
 */
public class AssignOrderAutomaticallyUI extends AbstractUI {

    private final TcpBackofficeClient tcpBackofficeClient = new TcpBackofficeClient();

    @Override
    protected boolean doShow() {
        try {
            tcpBackofficeClient.run();
            tcpBackofficeClient.writeByte(1000, (byte) 4, "");

            String success = tcpBackofficeClient.readByte(1000);
            if (success.equalsIgnoreCase("false")) {
                System.out.println("Could not add orders to queue\n");
                return false;
            }

            List<String> options = new ArrayList<>();
            int option;
            String unitOfTime;
            int time;
            options.add("Not periodically");
            options.add("Periodically");

            option = Utils.showAndSelectIndex(options, "\n\nAssign order automatically");
            tcpBackofficeClient.writeByte(1000, (byte) 4, String.valueOf(option));
            switch (option) {
                case 0:
                    assignTaskAutomatically();
                    break;
                case 1:
                    unitOfTime = Console.readLine("Enter the unit of time (minute/hour/day)");
                    tcpBackofficeClient.writeByte(1000, (byte) 4, unitOfTime);
                    time = Console.readInteger("Enter the time");
                    tcpBackofficeClient.writeByte(1000, (byte) 4, String.valueOf(time));

                    success = tcpBackofficeClient.readByte(1000);
                    if (success.equalsIgnoreCase("false")) {
                        doShow();
                    }

                    String sizeOfQueue = tcpBackofficeClient.readByte(1000);
                    int size = Integer.parseInt(sizeOfQueue);

                    while (size != 0) {
                        size--;
                        assignTaskAutomatically();
                        if (size != 0) {
                            System.out.println("\n\n" +
                                    "------------------------------------------------------\n" +
                                    time + " " + unitOfTime + "(s)" + " passed between orders\n" +
                                    "------------------------------------------------------\n");
                        }
                    }
                    break;
                default:
                    System.out.println("Option not chosen");
                    break;
            }

        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void assignTaskAutomatically() throws IOException {
        System.out.println("------------------------------------------Order that is being processed by the AGV-----------------------------------\n");

        String aux = tcpBackofficeClient.readByte(1000000);

        if (aux != null) {
            tcpBackofficeClient.writeByte(1000, (byte) 4, "not");
            String agv = tcpBackofficeClient.readByte(1000);

            if (agv == null) {
                tcpBackofficeClient.writeByte(100, (byte) 4, "null");
                System.out.println("There are no AGVs available \n");
                doShow();
            }
            tcpBackofficeClient.writeByte(100, (byte) 4, "not");
            if (tcpBackofficeClient.readByte(100).equalsIgnoreCase("true")) {
                System.out.println("\nThe order was assigned to the AGV successfully\n");
            } else {
                System.out.println("\nSomething went wrong, try again \n");
                doShow();
            }

            System.out.println(tcpBackofficeClient.readByte(1000));

        } else {
            tcpBackofficeClient.writeByte(1000, (byte) 4, "null");
            System.out.println("Error with the order that was going to be processed by the AGV\n");
            doShow();
        }
    }

    @Override
    public String headline() {
        return "Assign orders automatically to AGVs";
    }
}
