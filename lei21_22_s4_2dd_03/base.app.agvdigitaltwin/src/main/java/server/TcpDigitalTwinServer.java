package server;

import eapli.base.Application;
import eapli.base.agvmanagement.mapper.dto.AGVDTO;
import org.w3c.dom.ls.LSOutput;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.net.*;
import java.util.HashMap;

public class TcpDigitalTwinServer {

    private static final HashMap<Socket, DataOutputStream> cliList = new HashMap<>();

    public static synchronized void sendToAll(int len, byte[] data) throws Exception {
        for (DataOutputStream cOut : cliList.values()) {
            cOut.write(len);
            cOut.write(data, 0, len);
        }

    }

    public static synchronized void addCli(Socket s) throws IOException {
        InetAddress clientIP = s.getInetAddress();
        System.out.println("New client connection from " + clientIP.getHostAddress() +
                ", port number " + s.getPort());
        cliList.put(s, new DataOutputStream(s.getOutputStream()));
    }

    public static synchronized void remCli(Socket socket) throws IOException {
        cliList.remove(socket);
        System.out.println("Client " + socket.getInetAddress().getHostAddress() +
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
     * @param sIn  data imput stream
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


    private static SSLServerSocket sock;
    private static final String TRUST_STORE = "dtclient.jks";
    private static final String KEYSTORE_PASS = "Password1";
    private static final String KEYSTORE = "dtserver.jks";
    private static final int DEFAULT_PORT = Integer.parseInt(Application.settings().getProperty("DigitalTwinServer.port"));


    public static void main(String[] args) throws Exception {
        Socket cliSock;
        System.setProperty("javax.net.ssl.keyStore", KEYSTORE);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);
        System.setProperty("javax.net.ssl.trustStore", TRUST_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);
        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            sock = (SSLServerSocket) sslF.createServerSocket(DEFAULT_PORT);
            sock.setNeedClientAuth(true);
        } catch (IOException ex) {
            System.out.println("Failed to open server socket");
            System.exit(1);
        }
        while (true) {
            cliSock = sock.accept();
            new Thread(new TcpDigitalTwinServerThreadMenu(cliSock)).start();
        }
    }
}

class TcpDigitalTwinServerThreadMenu implements Runnable {

    private static final int COMM_TEST = 0;
    private static final int DIS_CONN = 1;
    private static final int ACK = 2;

    private static final int CALLING_DT = 10;

    private final Socket socket;

    public TcpDigitalTwinServerThreadMenu(Socket cli_s) {
        socket = cli_s;
    }

    public void run() {
        try {
            DataInputStream sIn = new DataInputStream(socket.getInputStream());
            DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());

            byte[] connect = new byte[1000];
            sIn.read(connect);
            int code = connect[1];

            if (code == COMM_TEST) {
                TcpDigitalTwinServer.writeByte(1000, (byte) 2, "The Server has connected this client", sOut);
                TcpDigitalTwinServer.addCli(socket);
            }
            if (code == DIS_CONN) {
                TcpDigitalTwinServer.writeByte(1000, (byte) 2, "The Server has disconnected this client", sOut);
                TcpDigitalTwinServer.remCli(socket);
            }
            if (code == ACK) {
                int length = connect[2] + connect[3] * 256;
                byte[] data = new byte[length];
                System.arraycopy(connect, 4, data, 0, length);
                System.out.println(new String(data));
                TcpDigitalTwinServer.writeByte(connect.length, (byte) 2, "Message arrived in the Server", sOut);
            }
            if (code == CALLING_DT) {
                new Thread(new TcpDTThreadAGVMovement(socket)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}