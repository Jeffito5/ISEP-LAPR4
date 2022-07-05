package server;

import client.TcpDigitalTwinClient;

import java.io.IOException;
import java.net.Socket;

public class TcpDTThreadBattery implements Runnable {

    private final Socket socket;

    private int autonomy;
    private final String agvId;

    private final TcpDigitalTwinClient client = new TcpDigitalTwinClient();


    public TcpDTThreadBattery(Socket client_socket, String agvId, String autonomy) {
        this.socket = client_socket;
        this.autonomy = Integer.parseInt(autonomy);
        this.agvId = agvId;
    }

    @Override
    public void run() {
        try {
            while (autonomy > 0) {
                Thread.sleep(10000);
                autonomy -= 1;

                client.run();
                client.writeByte(100, (byte) 11, "");
                client.writeByte(100, (byte) 11, agvId);
                client.writeByte(100, (byte) 11, String.valueOf(autonomy));
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
