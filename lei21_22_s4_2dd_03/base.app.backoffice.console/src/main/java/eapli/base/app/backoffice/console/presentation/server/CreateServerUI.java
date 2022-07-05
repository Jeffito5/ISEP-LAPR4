package eapli.base.app.backoffice.console.presentation.server;

import eapli.base.servermanagement.ServerController;
import eapli.framework.presentation.console.AbstractUI;

import java.net.UnknownHostException;

public class CreateServerUI  extends AbstractUI {

    @Override
    protected boolean doShow() {
        System.out.println("Opening Server...");
        ServerController controller = new ServerController();
        try {
            controller.createServer();
            System.out.println(controller.getIPAddress());
        } catch (Exception e) {
            System.out.println("Error opening the Server!\nMessage: " + e.getMessage());
        }
        System.out.println("Web Server Created!");
        return true;
    }

    @Override
    public String headline() {
        return "Open Server UI";
    }
}
