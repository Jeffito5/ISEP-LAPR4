package eapli.base.app.backoffice.console.presentation.warehouseemployee;

import eapli.base.Utils;
import eapli.base.app.backoffice.console.presentation.TcpBackofficeClient;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ana Rita Silva
 */
public class ConfigureAGVUI extends AbstractUI {

    private final TcpBackofficeClient tcpBackofficeClient = new TcpBackofficeClient();

    @Override
    protected boolean doShow() {
        try {
            tcpBackofficeClient.run();
            tcpBackofficeClient.writeByte(1000, (byte) 5, "");

            double maxWeight = Console.readDouble("Max Weight in Kg");
            double volume = Console.readDouble("Volume in m³");
            String status = Console.readLine("AGV status (free,charging,occupied,maintenance)");

            tcpBackofficeClient.writeByte(1000, (byte) 5, String.valueOf(maxWeight));
            tcpBackofficeClient.writeByte(1000, (byte) 5, String.valueOf(volume));
            tcpBackofficeClient.writeByte(1000, (byte) 5, status);

            String dockList = tcpBackofficeClient.readByte(10000);

            StringBuilder sb = new StringBuilder(dockList);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            dockList = sb.toString();

            List<String> list = Arrays.asList(dockList.split("},"));
            int choice = Utils.showAndSelectIndex(list, "Select a docker.");

            if (choice == -1) {
                return false;
            }
            tcpBackofficeClient.writeByte(1000, (byte) 5, String.valueOf(choice));


            int autonomy = Console.readInteger("Autonomy in minutes");
            String identifier = Console.readLine("Id");
            String description = Console.readLine("Description");
            String model = Console.readLine("Model");
            int speed = Console.readInteger("Speed (m/s)");

            tcpBackofficeClient.writeByte(1000, (byte) 5, String.valueOf(autonomy));
            tcpBackofficeClient.writeByte(1000, (byte) 5, identifier);
            tcpBackofficeClient.writeByte(1000, (byte) 5, description);
            tcpBackofficeClient.writeByte(1000, (byte) 5, model);
            tcpBackofficeClient.writeByte(1000, (byte) 5, String.valueOf(speed));

            System.out.println(tcpBackofficeClient.readByte(10000));
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    @Override
    public String headline() {
        return "Configure an AGV";
    }
}
