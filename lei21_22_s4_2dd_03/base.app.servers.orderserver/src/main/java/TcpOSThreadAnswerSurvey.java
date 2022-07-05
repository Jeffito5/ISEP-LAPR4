import eapli.base.surveymanagement.application.AnswerSurveyController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TcpOSThreadAnswerSurvey implements Runnable {

    private final Socket socket;

    public TcpOSThreadAnswerSurvey(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream sIn = new DataInputStream(socket.getInputStream());

            sOut.flush();
            String email = TcpOrderServer.readByte(1000, sIn);
            AnswerSurveyController controller = new AnswerSurveyController(email);

            String path = TcpOrderServer.readByte(1000,sIn);

            try {
                controller.answerSurvey(path);
                TcpOrderServer.writeByte(1000, (byte) 4, "Survey Answered with success!", sOut);
            }catch (Exception e){
                TcpOrderServer.writeByte(1000, (byte) 4, "ERROR", sOut);
                TcpOrderServer.writeByte(1000, (byte) 4, e.getMessage(), sOut);
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
