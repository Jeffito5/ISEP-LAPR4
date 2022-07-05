package eapli.base.app.user.console.presentation.customer;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class CheckOrderStatusUI extends AbstractUI {

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

    private final TcpCustomerClient tcpCustomerClient = new TcpCustomerClient();


    @Override
    protected boolean doShow() {
        EmailAddress email = null;
        if (authorizationService.session().isPresent())
            email = authorizationService.session().get().authenticatedUser().email();
        assert email != null;
        try {
            tcpCustomerClient.run();

            tcpCustomerClient.writeByte(1000, (byte) 8, "");

            tcpCustomerClient.writeByte(1000, (byte) 2, email.toString());

            String print = tcpCustomerClient.readByte(100000);

            System.out.println(print);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String headline() {
        return "Check the Status of the Open Orders";
    }
}
