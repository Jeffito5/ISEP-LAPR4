package eapli.base.app.backoffice.console.presentation;

import java.io.IOException;

public class AGVOccupiedEvent {

    public static void event(String agvId, String orderId) {
        try {
            TcpBackofficeClient client = new TcpBackofficeClient();
            client.run();
            client.writeByte(1000, (byte) 9, "");
            client.writeByte(1000, (byte) 9, agvId);
            client.writeByte(1000, (byte) 9, orderId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
