package client.presentation;

import client.TcpDigitalTwinClient;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class ConnectUI extends AbstractUI {

    private final TcpDigitalTwinClient tcpDigitalTwinClient = new TcpDigitalTwinClient();

    @Override
    protected boolean doShow() {
        tcpDigitalTwinClient.run();
        try {
            tcpDigitalTwinClient.writeByte(1000, (byte) 0, "");

            String data = tcpDigitalTwinClient.readByte(1000);

            System.out.println("= = = = = = = = =");
            System.out.println(data);
            System.out.println("= = = = = = = = =");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String headline() {
        return "Connect with the Server";
    }
}
