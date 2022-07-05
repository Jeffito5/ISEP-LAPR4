package server;

import eapli.base.agvmanagement.application.ConfigureAGVController;
import eapli.base.warehousemanagement.mappers.dtos.DockDTO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class TcpAMThreadConfigureAgv implements Runnable {

    private final Socket socket;

    public TcpAMThreadConfigureAgv(Socket client_socket) {
        socket = client_socket;
    }

    public void run() {
        try {
            DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream sIn = new DataInputStream(socket.getInputStream());

            ConfigureAGVController controller = new ConfigureAGVController();

            String maxWeight = TcpAgvManagerServer.readByte(1000, sIn);
            String volume = TcpAgvManagerServer.readByte(1000, sIn);
            String status = TcpAgvManagerServer.readByte(1000, sIn);

            List<DockDTO> dockList = controller.availableDockList();

            TcpAgvManagerServer.writeByte(10000, (byte) 5, dockList.toString(), sOut);
            String option = TcpAgvManagerServer.readByte(1000, sIn);

            String autonomy = TcpAgvManagerServer.readByte(1000, sIn);
            String identifier = TcpAgvManagerServer.readByte(1000, sIn);
            String description = TcpAgvManagerServer.readByte(1000, sIn);
            String model = TcpAgvManagerServer.readByte(1000, sIn);
            String speed = TcpAgvManagerServer.readByte(1000,sIn);

            controller.configureAGV(Double.parseDouble(maxWeight), Double.parseDouble(volume), status, Integer.parseInt(option), Integer.parseInt(autonomy), identifier, description, model,Integer.parseInt(speed));

            String string = controller.findAGV(identifier).toString;
            TcpAgvManagerServer.writeByte(10000, (byte) 5, string, sOut);

            TcpAgvManagerServer.removeClient(socket);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
