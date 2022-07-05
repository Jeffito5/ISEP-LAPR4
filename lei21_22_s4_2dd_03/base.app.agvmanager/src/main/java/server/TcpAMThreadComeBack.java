package server;

import eapli.base.agvmanagement.application.DigitalTwinMovementController;
import eapli.base.agvmanagement.domain.Route;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpAMThreadComeBack implements Runnable {
    private final Socket socket;

    private final DigitalTwinMovementController controller = new DigitalTwinMovementController();

    public TcpAMThreadComeBack(Socket client_socket) {
        socket = client_socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream sIn = new DataInputStream(socket.getInputStream());
            DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());

            String agvId = TcpAgvManagerServer.readByte(1000, sIn);

            Route route = controller.comebackDock(agvId);
            TcpAgvManagerServer.writeByte(1000, (byte) 14, String.valueOf(route.coordinatesList.size()), sOut);
            for (int i = 0; i < route.coordinatesList.size() - 1; i++) {
                TcpAgvManagerServer.writeByte(10000, (byte) 14, "14. Moved from: " + route.coordinatesList.get(i) + " to " + route.coordinatesList.get(i + 1), sOut);
                controller.updateAGVPosition(agvId, route.coordinatesList.get(i + 1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
