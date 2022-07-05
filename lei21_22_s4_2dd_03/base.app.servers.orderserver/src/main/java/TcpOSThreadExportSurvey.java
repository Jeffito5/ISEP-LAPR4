import eapli.base.surveymanagement.application.AnswerSurveyController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpOSThreadExportSurvey implements Runnable {
    private final Socket socket;


    public TcpOSThreadExportSurvey(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream sIn = new DataInputStream(socket.getInputStream());

            String email = TcpOrderServer.readByte(1000,sIn);
            AnswerSurveyController controller = new AnswerSurveyController(email);

            TcpOrderServer.writeByte(100000, (byte) 4, controller.getSurveysString(), sOut);

            String id = TcpOrderServer.readByte(1000, sIn);

            try {
                String path = controller.exportSurvey(Integer.parseInt(id));
                TcpOrderServer.writeByte(1000, (byte) 4, path, sOut);
            } catch (Exception e){
                TcpOrderServer.writeByte(1000, (byte) 4, "ERROR", sOut);
                TcpOrderServer.writeByte(1000, (byte) 4, e.getMessage(), sOut);
            }

        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
