import eapli.base.ordermanagement.application.CheckOrderStatusController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpOSThreadCheckOrderStatus implements Runnable {

    private final Socket socket;

    public TcpOSThreadCheckOrderStatus(Socket cli_s) {
        socket = cli_s;
    }

    public void run() {
        try {
            DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream sIn = new DataInputStream(socket.getInputStream());

            CheckOrderStatusController controller = new CheckOrderStatusController();

            String email = TcpOrderServer.readByte(1000, sIn);

            System.out.println(controller.customer(email));

            String orders = controller.checkOrderStatus();

            TcpOrderServer.writeByte(100000, (byte) 2, orders, sOut);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
