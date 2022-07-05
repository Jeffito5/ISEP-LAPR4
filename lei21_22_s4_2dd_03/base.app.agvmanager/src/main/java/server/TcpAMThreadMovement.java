package server;

import eapli.base.agvmanagement.application.DigitalTwinMovementController;
import eapli.base.agvmanagement.domain.Route;
import eapli.base.warehousemanagement.domain.Coordinates;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class TcpAMThreadMovement implements Runnable {
    private final Socket socket;
    private final DigitalTwinMovementController controller = new DigitalTwinMovementController();

    public TcpAMThreadMovement(Socket client_socket) {
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

            List<Coordinates> coordinatesList = controller.route(agvId, orderId);

            TcpAgvManagerServer.writeByte(1000, (byte) 12, String.valueOf(coordinatesList.size()), sOut);

            for (int i = 0; i < coordinatesList.size() - 1; i++) {
                Route route = controller.calculateRoute(coordinatesList.get(i), coordinatesList.get(i + 1));

                TcpAgvManagerServer.writeByte(1000, (byte) 12, String.valueOf(route.coordinatesList.size()), sOut);
                for (int j = 0; j < route.coordinatesList.size() - 1; j++) {
                    TcpAgvManagerServer.writeByte(1000, (byte) 12, "12. Moved from: " + route.coordinatesList.get(i) + " to " + route.coordinatesList.get(i + 1), sOut);
                    controller.updateAGVPosition(agvId, route.coordinatesList.get(i + 1));
                }
            }

            TcpAgvManagerServer.removeClient(socket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
