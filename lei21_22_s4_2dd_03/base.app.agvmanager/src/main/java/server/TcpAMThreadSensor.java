package server;

import eapli.base.agvmanagement.application.DigitalTwinMovementController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpAMThreadSensor implements Runnable {
    private final Socket socket;
    private final DigitalTwinMovementController controller = new DigitalTwinMovementController();

    public TcpAMThreadSensor(Socket client_socket) {
        socket = client_socket;
    }

    @Override
    public void run() {
        try {
            TcpAgvManagerServer.addClient(socket);

            DataInputStream sIn = new DataInputStream(socket.getInputStream());
            DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());

            String agvId = TcpAgvManagerServer.readByte(1000, sIn);

            int option = controller.checkCollision(agvId);

            TcpAgvManagerServer.writeByte(1000, (byte) 13, String.valueOf(option), sOut);

            TcpAgvManagerServer.removeClient(socket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
