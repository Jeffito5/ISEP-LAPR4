package eapli.base.app.backoffice.console.presentation;

import eapli.base.Application;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Ana Rita Silva <1201228@isep.ipp.pt>
 */
public class TcpBackofficeClient implements Runnable {

    static final String KEYSTORE_PASS = "Password1";
    static final String KEYSTORE = "client.jks";
    static final String TRUST_STORE = "server.jks";

    private static final String DEFAULT_IP = Application.settings().getProperty("AGVManagerServer.ip");
    private static final int DEFAULT_PORT = Integer.parseInt(Application.settings().getProperty("AGVManagerServer.port"));

    private static InetAddress serverIP;
    private static SSLSocket socket;
    private static DataOutputStream sOut;
    private static DataInputStream sIn;

    @Override
    public void run() {
        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", KEYSTORE);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        // Trust these certificates provided by servers
        System.setProperty("javax.net.ssl.trustStore", TRUST_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            serverIP = InetAddress.getByName(DEFAULT_IP);
        } catch (UnknownHostException e) {
            System.out.println("Invalid server specified: " + DEFAULT_IP);
            System.exit(1);
        }

        try {
            socket = (SSLSocket) sf.createSocket(serverIP, DEFAULT_PORT);
            sOut = new DataOutputStream(socket.getOutputStream());
            sIn = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.out.println("Failed to establish TCP connection");
        }

        System.out.println("Connected to: " + DEFAULT_IP + ":" + DEFAULT_PORT);

        try {
            socket.startHandshake();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Writes a message in bytes
     *
     * @param size   message's size
     * @param code   message's code
     * @param string message
     * @throws IOException exception thrown if data output stream fails
     */
    public void writeByte(int size, byte code, String string) throws IOException {
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
     * Reads a message in bytes
     *
     * @param size message's size
     * @return message
     * @throws IOException exception thrown if data input stream fails
     */
    public String readByte(int size) throws IOException {
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
}
