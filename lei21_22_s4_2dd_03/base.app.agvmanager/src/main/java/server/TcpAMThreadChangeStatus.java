package server;

import eapli.base.agvmanagement.application.ChangeStatusController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
public class TcpAMThreadChangeStatus implements Runnable {

    private final Socket socket;

    public TcpAMThreadChangeStatus(Socket client_socket) {
        socket = client_socket;
    }

    @Override
    public void run() {
        try {
            TcpAgvManagerServer.addClient(socket);

            DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream sIn = new DataInputStream(socket.getInputStream());

            ChangeStatusController controller = new ChangeStatusController();

            String agvIdentifier = TcpAgvManagerServer.readByte(1000, sIn);

            String status = TcpAgvManagerServer.readByte(1000, sIn);

            boolean agvExist = controller.getAGVByIdentifier(agvIdentifier);

            boolean agvStatusEqual = controller.checkAGVStatus(status);

            boolean agvStatusValid = controller.checkStatusExistence(status);
            String output = "";
            if (agvExist && !agvStatusEqual && agvStatusValid) {
                output = controller.updateStatusForAGV();
            } else {
                if (!agvExist)
                    output = "The AGV " + agvIdentifier + " doesn't exist";
                if (agvStatusEqual)
                    output = "The AGV " + agvIdentifier + "was already in " + status;
                if (!agvStatusValid)
                    output = "The status " + status + " doesn't exist";
            }

            TcpAgvManagerServer.writeByte(10000, (byte) 2, output, sOut);

            TcpAgvManagerServer.removeClient(socket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
