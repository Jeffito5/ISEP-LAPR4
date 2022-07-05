package server;

import client.TcpDigitalTwinClient;

import java.io.IOException;
import java.net.Socket;

public class TcpDTThreadComeBack implements Runnable {

    private final Socket socket;
    private final String agvId;
    private final TcpDigitalTwinClient client = new TcpDigitalTwinClient();


    public TcpDTThreadComeBack(Socket client_socket, String agvId) {
        socket = client_socket;
        this.agvId = agvId;
    }

    @Override
    public void run() {
        try {
            client.run();

            client.writeByte(1000, (byte) 14, "");
            client.writeByte(1000, (byte) 14, agvId);

            String size = client.readByte(1000);

            for (int i = 0; i < Integer.parseInt(size) - 1; i++) {
                String message = client.readByte(10000);
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
