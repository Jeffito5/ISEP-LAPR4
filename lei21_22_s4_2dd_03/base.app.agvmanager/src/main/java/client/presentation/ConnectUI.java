package client.presentation;

import client.TcpAgvManagerClient;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class ConnectUI extends AbstractUI {

    private final TcpAgvManagerClient tcpDigitalTwinClient = new TcpAgvManagerClient();

    @Override
    protected boolean doShow() {
        tcpDigitalTwinClient.run();
        System.out.println("done");
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
