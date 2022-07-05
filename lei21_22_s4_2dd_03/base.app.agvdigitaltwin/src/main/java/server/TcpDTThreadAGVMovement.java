package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

class TcpDTThreadAGVMovement implements Runnable {

    private final Socket socket;

    public TcpDTThreadAGVMovement(Socket client_socket) {
        socket = client_socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream sIn = new DataInputStream(socket.getInputStream());

            TcpDigitalTwinServer.addCli(socket);

            String agvId = TcpDigitalTwinServer.readByte(1000, sIn);
            String orderId = TcpDigitalTwinServer.readByte(1000, sIn);
            String autonomy = TcpDigitalTwinServer.readByte(1000, sIn);


            Thread movementThread = new Thread(new TcpDTThreadMovement(socket, agvId, orderId));
            Thread sensorThread = new Thread(new TcpDTThreadSensor(socket, agvId));
            Thread batteryThread = new Thread(new TcpDTThreadBattery(socket, agvId, autonomy));
            Thread comebackThread = new Thread(new TcpDTThreadComeBack(socket, agvId));
            Thread rechargeThread = new Thread(new TcpDTThreadBatteryCharging(socket, agvId, autonomy));


            movementThread.start();
            batteryThread.start();

            while (true) {
                sensorThread.start();
                Thread.sleep(100);

                if (!movementThread.isAlive()) {
                    sensorThread.stop();
                    batteryThread.stop();
                    break;
                }
                if (!batteryThread.isAlive()) {
                    movementThread.stop();
                    comebackThread.start();
                    comebackThread.join();
                    break;
                }
                if (!sensorThread.isAlive()) {
                    movementThread.stop();
                    movementThread.start();
                }
            }

            rechargeThread.start();
            rechargeThread.join();

            TcpDigitalTwinServer.remCli(socket);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}