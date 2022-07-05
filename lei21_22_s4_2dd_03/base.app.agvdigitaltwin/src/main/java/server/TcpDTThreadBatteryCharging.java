package server;

import client.TcpDigitalTwinClient;

import java.io.IOException;
import java.net.Socket;

public class TcpDTThreadBatteryCharging implements Runnable {

    private final Socket socket;

    private int autonomy;
    private final String agvId;

    private final TcpDigitalTwinClient client = new TcpDigitalTwinClient();

    public TcpDTThreadBatteryCharging(Socket client_socket, String agvId, String autonomy) {
        this.socket = client_socket;
        this.autonomy = Integer.parseInt(autonomy);
        this.agvId = agvId;
    }

    @Override
    public void run() {
        try {
            client.run();
            client.writeByte(1000, (byte) 6, "");
            client.writeByte(1000, (byte) 6, agvId);
            client.writeByte(1000, (byte) 6, "CHARGING");
            String message = client.readByte(10000);
            System.out.println(message);

            while (autonomy < 100) {
                Thread.sleep(10000);
                autonomy += 1;

                client.run();
                client.writeByte(100, (byte) 11, "");
                client.writeByte(100, (byte) 11, agvId);
                client.writeByte(100, (byte) 11, String.valueOf(autonomy));
            }
            client.run();
            client.writeByte(1000, (byte) 6, "");
            client.writeByte(1000, (byte) 6, agvId);
            client.writeByte(1000, (byte) 6, "FREE");
            String message1 = client.readByte(10000);
            System.out.println(message1);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
