package client;

import eapli.base.Application;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
public class TcpDigitalTwinClient implements Runnable {

    private static final String DEFAULT_IP = Application.settings().getProperty("AGVManagerServer.ip");
    private static final int DEFAULT_PORT = Integer.parseInt(Application.settings().getProperty("AGVManagerServer.port"));
    private static final String KEYSTORE_PASS="Password1";
    private static InetAddress serverIP;
    private static SSLSocket socket;
    private static DataOutputStream sOut;
    private static DataInputStream sIn;

    @Override
    public void run() {
        System.setProperty("javax.net.ssl.trustStore", "server"+".jks");
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);
        System.setProperty("javax.net.ssl.keyStore","client"+".jks");
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);
        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            serverIP = InetAddress.getByName(DEFAULT_IP);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            socket = (SSLSocket) sf.createSocket(serverIP,DEFAULT_PORT);
        } catch (IOException ex) {
            System.out.println("Failed to establish TCP connection");
        }
        try {
            socket.startHandshake();
            sOut = new DataOutputStream(socket.getOutputStream());
            sIn = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * writes a message
     *
     * @param size   size
     * @param code   code
     * @param string message
     * @throws IOException exception
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
     * reads message
     *
     * @param size size
     * @return message
     * @throws IOException exception
     */
    public String readByte(int size) throws IOException {
        byte[] message = new byte[size];
        sIn.readFully(message);
        int lenght2;
        int lenght3;
        if (message[2] < 0) {
            lenght2 = message[2] & 0xFF;
        } else {
            lenght2 = message[2];
        }
        if (message[3] < 0) {
            lenght3 = message[3] & 0xFF;
        } else {
            lenght3 = message[3];
        }
        int length = lenght2 + lenght3 * 256;
        byte[] data = new byte[length];
        System.arraycopy(message, 4, data, 0, length);
        return new String(data);
    }

    public Socket getSocket() {
        return socket;
    }

    public DataOutputStream getsOut() {
        return sOut;
    }

    public DataInputStream getsIn() {
        return sIn;
    }
}