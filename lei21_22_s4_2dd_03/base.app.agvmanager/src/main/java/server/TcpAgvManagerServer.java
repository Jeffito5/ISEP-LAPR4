package server;

import eapli.base.Application;

import javax.net.ssl.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 * @author MarcoRamos <1201217@isep.ipp.pt>
 * @author Ana Rita Silva <1201228@isep.ipp.pt>
 */
public class TcpAgvManagerServer {

    private static final HashMap<Socket, DataOutputStream> clientList = new HashMap<>();
    static SSLServerSocket sock;

    /**
     * adds client
     *
     * @param s socket
     * @throws IOException exception
     */
    public static synchronized void addClient(Socket s) throws IOException {
        System.out.println("New client connection from " + s.getInetAddress().getHostAddress() +
                ", port number " + s.getPort());
        clientList.put(s, new DataOutputStream(s.getOutputStream()));
    }

    /**
     * removes client
     *
     * @param socket socket
     * @throws IOException exception
     */
    public static synchronized void removeClient(Socket socket) throws IOException {
        clientList.remove(socket);
        System.out.println("client " + socket.getInetAddress().getHostAddress() +
                ", port number: " + socket.getPort() + " disconnected");
        socket.close();
    }

    /**
     * writes a message
     *
     * @param size   size
     * @param code   code
     * @param string message
     * @param sOut   data output stream
     * @throws IOException exception
     */
    public static void writeByte(int size, byte code, String string, DataOutputStream sOut) throws IOException {
        byte[] message = new byte[size];
        message[0] = 1;
        message[1] = code;
        int D_LENGTH_1 = string.length() % 256;
        int D_LENGTH_2 = string.length() / 256;
        message[2] = (byte) D_LENGTH_1;
        message[3] = (byte) D_LENGTH_2;
        byte[] data = string.getBytes();
        System.arraycopy(data, 0, message, 4, string.length());
        sOut.write(message);
    }

    /**
     * reads message
     *
     * @param size size
     * @param sIn  data input stream
     * @return message
     * @throws IOException exception
     */
    public static String readByte(int size, DataInputStream sIn) throws IOException {
        byte[] message = new byte[size];
        sIn.readFully(message);
        int length2;
        int length3;
        if (message[2] < 0) {
            length2 = message[2] & 0xFF;
        } else {
            length2 = message[2];
        }
        if (message[3] < 0) {
            length3 = message[3] & 0xFF;
        } else {
            length3 = message[3];
        }
        int length = length2 + length3 * 256;
        byte[] data = new byte[length];
        System.arraycopy(message, 4, data, 0, length);
        return new String(data);
    }

    private static final int SERVER_PORT = Integer.parseInt(Application.settings().getProperty("AGVManagerServer.port"));
    private static final String KEYSTORE = "server.jks";
    private static final String TRUST_STORE = "client.jks";
    private static final String KEYSTORE_PASS = "Password1";

    public static void main(String[] args) throws Exception {
        sock = null;
        Socket clientSocket;

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", KEYSTORE);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TRUST_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            if (!Files.exists(Path.of(KEYSTORE)) || !Files.exists(Path.of(TRUST_STORE))) {
                throw new IllegalArgumentException("File " + KEYSTORE + " and/or " + TRUST_STORE + " not found.");
            }

            sock = (SSLServerSocket) sslF.createServerSocket(SERVER_PORT);
            sock.setNeedClientAuth(true);
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + SERVER_PORT);
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        while (true) {
            clientSocket = sock.accept();
            new Thread(new TcpAgvManagerThreadMenu(clientSocket)).start();
        }
    }
}

class TcpAgvManagerThreadMenu implements Runnable {

    private static final int COMM_TEST = 0;
    private static final int DIS_CONN = 1;
    private static final int ACK = 2;

    //From BackOfficeApp
    private static final int ASSIGN_ORDER = 3;
    private static final int ASSIGN_ORDER_AUTOMATICALLY = 4;
    private static final int CONFIGURE_AGV = 5;
    private static final int AGV_MANAGEMENT = 9;

    //From DigitalTwinApp
    private static final int CHANGE_STATUS = 6;
    private static final int BATTERY_UPDATE = 11;
    private static final int AGV_MOVEMENT = 12;
    private static final int AGV_SENSORS = 13;
    private static final int COMEBACK_DOCK = 14;


    private final Socket socket;

    public TcpAgvManagerThreadMenu(Socket client_socket) {
        socket = client_socket;
    }

    public void run() {
        try {
            DataInputStream sIn = new DataInputStream(socket.getInputStream());
            DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());

            byte[] connect = new byte[1000];
            sIn.read(connect);
            int code = connect[1];

            if (code == COMM_TEST) {
                TcpAgvManagerServer.writeByte(1000, (byte) 2, "The Server has connected this client", sOut);
                TcpAgvManagerServer.addClient(socket);
            }
            if (code == DIS_CONN) {
                TcpAgvManagerServer.writeByte(1000, (byte) 2, "The Server has disconnected this client", sOut);
                TcpAgvManagerServer.removeClient(socket);
            }
            if (code == ACK) {
                int length = connect[2] + connect[3] * 256;
                byte[] data = new byte[length];
                System.arraycopy(connect, 4, data, 0, length);
                System.out.println(new String(data));
                TcpAgvManagerServer.writeByte(connect.length, (byte) 2, "Message arrived in the Server", sOut);
            }
            if (code == ASSIGN_ORDER) {
                new Thread(new TcpAMThreadAssignOrder(socket)).start();
            }
            if (code == ASSIGN_ORDER_AUTOMATICALLY) {
                new Thread(new TcpAMThreadAssignOrderAuto(socket)).start();
            }
            if (code == CONFIGURE_AGV) {
                new Thread(new TcpAMThreadConfigureAgv(socket)).start();
            }
            if (code == CHANGE_STATUS) {
                new Thread(new TcpAMThreadChangeStatus(socket)).start();
            }
            if (code == AGV_MANAGEMENT) {
                new Thread(new TcpAMThreadCallDT(socket)).start();
            }
            if (code == BATTERY_UPDATE) {
                new Thread(new TcpAMThreadBatteryUpdate(socket)).start();
            }
            if (code == AGV_SENSORS) {
                new Thread(new TcpAMThreadSensor(socket)).start();
            }
            if (code == AGV_MOVEMENT) {
                new Thread(new TcpAMThreadMovement(socket)).start();
            }
            if (code == COMEBACK_DOCK) {
                new Thread(new TcpAMThreadComeBack(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}