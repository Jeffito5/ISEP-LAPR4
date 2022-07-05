package eapli.base.app.user.console.presentation.customer;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;

import java.io.*;

public class AddProductSCUI extends AbstractUI {

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

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            tcpCustomerClient.writeByte(1000, (byte) 3, "");

            tcpCustomerClient.writeByte(1000, (byte) 2, email.toString());

            String catalog = tcpCustomerClient.readByte(100000);

            System.out.println("====================================================");
            System.out.println(catalog);
            System.out.println("====================================================");
            System.out.println("Insert the product identification (Internal Code)");
            String productId = in.readLine();
            System.out.println("====================================================");
            System.out.println("Insert the quantity of the product you want to add");
            String quantity = in.readLine();
            System.out.println("====================================================");

            tcpCustomerClient.writeByte(1000, (byte) 2, productId);

            tcpCustomerClient.writeByte(1000, (byte) 2, quantity);

            String message = tcpCustomerClient.readByte(10000);
            System.out.println("====================================================");
            System.out.println(message);
            System.out.println("====================================================");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String headline() {
        return "Add Product to Shopping Cart";
    }
}
