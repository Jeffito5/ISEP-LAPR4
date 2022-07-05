package server;

import client.TcpDigitalTwinClient;

import java.io.IOException;
import java.net.Socket;

public class TcpDTThreadSensor implements Runnable {

    private final Socket socket;
    private final String agvId;
    private final TcpDigitalTwinClient client = new TcpDigitalTwinClient();


    public TcpDTThreadSensor(Socket client_socket, String agvId) {
        socket = client_socket;
        this.agvId = agvId;
    }

    @Override
    public void run() {
        try {
            client.run();

            client.writeByte(1000, (byte) 13, "");
            client.writeByte(1000, (byte) 13, agvId);

            String option = client.readByte(1000);
            if (Integer.parseInt(option) == 2)
                slowDown();
            if (Integer.parseInt(option) == 1)
                stop();
            if (Integer.parseInt(option) == 0)
                speedUp();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void speedUp() {
        notify();
    }

    public void slowDown() throws InterruptedException {
        Thread.sleep(10000);
        speedUp();
    }

    public void stop() {
        //stop
    }
}
