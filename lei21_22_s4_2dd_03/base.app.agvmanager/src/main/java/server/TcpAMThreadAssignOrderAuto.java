package server;

import eapli.base.agvmanagement.mapper.dto.AGVDTO;
import eapli.base.ordermanagement.application.AssignOrderAutomaticallyController;
import eapli.base.ordermanagement.mapper.dto.OrderDTO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpAMThreadAssignOrderAuto implements Runnable {

    private final Socket socket;
    private final AssignOrderAutomaticallyController controller;

    public TcpAMThreadAssignOrderAuto(Socket client_socket) {
        socket = client_socket;
        controller = new AssignOrderAutomaticallyController();
    }

    public void run() {
        try {
            DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream sIn = new DataInputStream(socket.getInputStream());

            boolean success = controller.addOrdersToQueue();
            TcpAgvManagerServer.writeByte(1000, (byte) 4, String.valueOf(success), sOut);

            if (success) {
                String caseOption = TcpAgvManagerServer.readByte(1000, sIn);
                if (caseOption.equals("1")) {
                    String unitOfTime = TcpAgvManagerServer.readByte(1000, sIn);
                    String time = TcpAgvManagerServer.readByte(1000, sIn);
                    success = controller.checkIfTimeIsCorrect(Integer.parseInt(time), unitOfTime);
                    TcpAgvManagerServer.writeByte(1000, (byte) 4, String.valueOf(success), sOut);
                    sOut.flush();
                    if (success) {
                        String size = String.valueOf(controller.sizeOfListOfOrdersInQueue());
                        TcpAgvManagerServer.writeByte(1000, (byte) 4, size, sOut);

                        int s = Integer.parseInt(size);
                        while (s != 0) {
                            s--;
                            this.assignTaskAutomatically(sOut, sIn);
                        }
                    }
                } else if (caseOption.equals("0")) {
                    this.assignTaskAutomatically(sOut, sIn);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void assignTaskAutomatically(DataOutputStream sOut, DataInputStream sIn) throws IOException {
        sOut.flush();
        OrderDTO order = controller.removeFirstOrderFromQueue();
        TcpAgvManagerServer.writeByte(1000000, (byte) 4, String.valueOf(order), sOut);

        if (TcpAgvManagerServer.readByte(1000, sIn).equalsIgnoreCase("not")) {
            AGVDTO agv = controller.listAgvAble(order).get(0);
            TcpAgvManagerServer.writeByte(1000, (byte) 4, String.valueOf(agv), sOut);

            if (!TcpAgvManagerServer.readByte(100, sIn).equalsIgnoreCase("null")) {
                boolean success = controller.assignOrder(agv);
                TcpAgvManagerServer.writeByte(100, (byte) 4, String.valueOf(success), sOut);

                if (success) {
                    String product = controller.findProductOrderById(order.id).toString();
                    TcpAgvManagerServer.writeByte(1000, (byte) 4, product, sOut);
                }
            }
        }
    }
}
