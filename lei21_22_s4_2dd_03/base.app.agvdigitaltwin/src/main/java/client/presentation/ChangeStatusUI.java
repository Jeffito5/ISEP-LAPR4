package client.presentation;

import client.TcpDigitalTwinClient;
import eapli.framework.presentation.console.AbstractUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangeStatusUI extends AbstractUI {

    private final TcpDigitalTwinClient tcpDigitalTwinClient = new TcpDigitalTwinClient();

    @Override
    protected boolean doShow() {
        tcpDigitalTwinClient.run();
        try {
            tcpDigitalTwinClient.writeByte(1000, (byte) 6, "");

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Insert the AGV identifier:");
            String agvIdentifier = in.readLine();
            tcpDigitalTwinClient.writeByte(1000, (byte) 2, agvIdentifier);

            System.out.println("========================================================");
            System.out.println("Insert the AGV new status between the available options:");
            System.out.println("   Free");
            System.out.println("   Occupied");
            System.out.println("   Maintenance");
            System.out.println("   Charging\n");
            String status = in.readLine();
            System.out.println("========================================================");

            tcpDigitalTwinClient.writeByte(1000, (byte) 2, status);

            String message = tcpDigitalTwinClient.readByte(10000);

            System.out.println("= = = = = = = = =");
            System.out.println(message);
            System.out.println("= = = = = = = = =");


        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String headline() {
        return "Change the AGV Status";
    }
}
