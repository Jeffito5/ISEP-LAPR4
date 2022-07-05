import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import eapli.base.customermanagement.application.AddProductSCController;
import eapli.base.customermanagement.dto.CustomerDTO;

class TcpOSThreadAddProductSC implements Runnable {
    private final Socket socket;

    public TcpOSThreadAddProductSC(Socket cli_s) {
        socket = cli_s;
    }

    public void run() {
        try {
            DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream sIn = new DataInputStream(socket.getInputStream());


            AddProductSCController controller = new AddProductSCController();

            String email = TcpOrderServer.readByte(1000, sIn);

            String catalog = controller.getCatalog();

            TcpOrderServer.writeByte(100000, (byte) 3, catalog, sOut);

            String productId = TcpOrderServer.readByte(1000, sIn);

            String quantity = TcpOrderServer.readByte(1000, sIn);

            String send;
            if (controller.getProduct(productId) != null) {
                CustomerDTO customer = controller.addProductToShoppingCart(productId, quantity, email);
                send = customer.shoppingCart;
                System.out.println("The Customer " + customer.name + " has added " + quantity + " " + productId + " to his shopping cart!");
                TcpOrderServer.writeByte(10000, (byte) 3, send, sOut);
            } else {
                send = "There is no such product in the catalog";
                TcpOrderServer.writeByte(10000, (byte) 3, send, sOut);
            }
            TcpOrderServer.remCli(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

