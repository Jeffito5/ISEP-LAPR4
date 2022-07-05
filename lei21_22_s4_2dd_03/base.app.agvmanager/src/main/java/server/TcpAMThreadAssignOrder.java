package server;

import eapli.base.agvmanagement.mapper.dto.AGVDTO;
import eapli.base.ordermanagement.application.AssignOrderController;
import eapli.base.ordermanagement.mapper.dto.OrderDTO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class TcpAMThreadAssignOrder implements Runnable {

    private final Socket socket;

    public TcpAMThreadAssignOrder(Socket client_socket) {
        socket = client_socket;
    }

    public void run() {
        try {
            TcpAgvManagerServer.addClient(socket);

            DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream sIn = new DataInputStream(socket.getInputStream());

            AssignOrderController controller = new AssignOrderController();


            List<OrderDTO> orderList = controller.listPaidOrders();
            if (orderList.isEmpty()) {
                TcpAgvManagerServer.writeByte(100000, (byte) 3, "-1", sOut);
            }

            TcpAgvManagerServer.writeByte(100000, (byte) 3, orderList.toString(), sOut);
            String option = TcpAgvManagerServer.readByte(1000, sIn);

            OrderDTO order = orderList.get(Integer.parseInt(option));
            List<AGVDTO> agvList = controller.listAgvAble(order);

            if (agvList.isEmpty()) {
                TcpAgvManagerServer.writeByte(100000, (byte) 3, "-1", sOut);
            }

            TcpAgvManagerServer.writeByte(100000, (byte) 3, agvList.toString(), sOut);
            option = TcpAgvManagerServer.readByte(1000, sIn);

            AGVDTO agv = agvList.get(Integer.parseInt(option));
            if (controller.assignOrder(agv)) {
                TcpAgvManagerServer.writeByte(1000, (byte) 3, "1", sOut);
            } else {
                TcpAgvManagerServer.writeByte(1000, (byte) 3, "-1", sOut);
            }

            TcpAgvManagerServer.removeClient(socket);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
