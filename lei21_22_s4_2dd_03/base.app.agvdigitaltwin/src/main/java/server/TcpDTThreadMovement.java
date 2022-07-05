package server;

import client.TcpDigitalTwinClient;

import java.io.IOException;
import java.net.Socket;

public class TcpDTThreadMovement implements Runnable {

    private final Socket socket;
    private final String agvId;
    private final String orderId;
    private final TcpDigitalTwinClient client = new TcpDigitalTwinClient();

    public TcpDTThreadMovement(Socket client_socket, String agvId, String orderId) {
        socket = client_socket;
        this.agvId = agvId;
        this.orderId = orderId;
    }

    @Override
    public void run() {
        try {
            client.run();

            client.writeByte(1000, (byte) 12, "");
            client.writeByte(1000, (byte) 12, agvId);
            client.writeByte(1000, (byte) 12, orderId);

            String itemPositionSize = client.readByte(1000);
            for (int i = 0; i < Integer.parseInt(itemPositionSize); i++) {
                String routeSize = client.readByte(1000);
                for (int j = 0; j < Integer.parseInt(routeSize); j++) {
                    wait();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
