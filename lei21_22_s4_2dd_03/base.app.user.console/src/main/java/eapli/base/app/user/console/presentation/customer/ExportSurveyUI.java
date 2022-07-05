package eapli.base.app.user.console.presentation.customer;

import eapli.base.Utils;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ExportSurveyUI extends AbstractUI {

    private final TcpCustomerClient tcpCustomerClient = new TcpCustomerClient();


    @Override
    protected boolean doShow() {
        try {
            tcpCustomerClient.run();
            tcpCustomerClient.writeByte(1000, (byte) 4, "");

            String email = AuthzRegistry.authorizationService().session().get().authenticatedUser().email().toString();

            tcpCustomerClient.writeByte(1000, (byte) 4, email);

            String list = tcpCustomerClient.readByte(100000);

            List<String> surveyList = Arrays.asList(list.split("//////////////\n"));

            int option = Utils.showAndSelectIndex( surveyList, "Select a survey:");
            if (option == -1) {
                return false;
            }

            tcpCustomerClient.writeByte(1000, (byte) 4, String.valueOf(option));

            String path = tcpCustomerClient.readByte(1000);

            if (path.equals("ERROR")) {
                System.out.println(tcpCustomerClient.readByte(1000));
                return false;
            }

            System.out.println("New File Created: " + path);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public String headline() {
        return "Export a Survey";
    }
}
