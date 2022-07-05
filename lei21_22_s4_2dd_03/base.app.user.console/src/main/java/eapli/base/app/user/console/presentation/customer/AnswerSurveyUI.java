package eapli.base.app.user.console.presentation.customer;

import eapli.base.surveymanagement.application.AnswerSurveyController;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AnswerSurveyUI extends AbstractUI {

    private final TcpCustomerClient tcpCustomerClient = new TcpCustomerClient();

    @Override
    protected boolean doShow() {
        try {
            tcpCustomerClient.run();
            tcpCustomerClient.writeByte(1000, (byte) 5, "");

            String email = AuthzRegistry.authorizationService().session().get().authenticatedUser().email().toString();

            tcpCustomerClient.writeByte(1000, (byte) 5, email);

            String path = Console.readLine("Type a file path:");

            tcpCustomerClient.writeByte(1000, (byte) 5, path);

            String output = tcpCustomerClient.readByte(1000);

            if (output.equals("ERROR")) {
                System.out.println(tcpCustomerClient.readByte(1000));
                return false;
            }

            System.out.println(output);

            return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }

    @Override
    public String headline() {
        return "Answer a Survey";
    }
}
