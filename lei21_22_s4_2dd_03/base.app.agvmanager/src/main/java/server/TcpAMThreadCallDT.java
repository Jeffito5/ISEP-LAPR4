package server;


import client.TcpAgvManagerClient;
import eapli.base.agvmanagement.application.DigitalTwinMovementController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpAMThreadCallDT implements Runnable {

    private final Socket socket;
    private final DigitalTwinMovementController controller = new DigitalTwinMovementController();
    private final TcpAgvManagerClient client = new TcpAgvManagerClient();

    public TcpAMThreadCallDT(Socket client_socket) {
        socket = client_socket;
    }

    @Override
    public void run() {
        try {

            TcpAgvManagerServer.addClient(socket);

            DataInputStream sIn = new DataInputStream(socket.getInputStream());
            DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());


            String agvId = TcpAgvManagerServer.readByte(1000, sIn);
            String orderId = TcpAgvManagerServer.readByte(1000, sIn);

            client.run();
            client.writeByte(1000, (byte) 10, "");

            client.writeByte(1000, (byte) 10, agvId);
            client.writeByte(1000, (byte) 10, orderId);
            client.writeByte(1000, (byte) 10, String.valueOf(controller.agv(agvId).autonomy()));


            //write order products
            //write agv autonomy
            //write agv max Speed
            //write agv max weight
            //write agv coordinates
            //write plant


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
