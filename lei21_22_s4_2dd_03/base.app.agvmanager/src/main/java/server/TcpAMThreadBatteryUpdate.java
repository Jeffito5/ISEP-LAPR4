package server;

import eapli.base.agvmanagement.application.DigitalTwinMovementController;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpAMThreadBatteryUpdate implements Runnable {
    private final Socket socket;

    private final DigitalTwinMovementController controller = new DigitalTwinMovementController();

    public TcpAMThreadBatteryUpdate(Socket client_socket) {
        socket = client_socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream sIn = new DataInputStream(socket.getInputStream());

            String agvId = TcpAgvManagerServer.readByte(1000, sIn);
            String autonomy = TcpAgvManagerServer.readByte(1000, sIn);

            controller.updateAGVAutonomy(agvId, Integer.parseInt(autonomy));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
