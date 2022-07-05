package eapli.base.app.backoffice.console.presentation.salesclerk;

import eapli.base.Utils;
import eapli.base.ordermanagement.application.CreateOrderController;
import eapli.base.ordermanagement.domain.PaymentMethod;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;


/**
 * @author 1201217 Marco Ramos
 */
public class CreateOrderUI extends AbstractUI {


    private final CreateOrderController controller = new CreateOrderController();

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

    @Override
    protected boolean doShow() {

        try {
            System.out.println("-------------Stakeholders-------------");
            SystemUser systemUser = null;
            if (authorizationService.session().isPresent())
                systemUser = authorizationService.session().get().authenticatedUser();
            assert systemUser != null;
            String vat = Console.readLine("Customer's Value-Added Tax (VAT)");
            boolean customerBoolean = controller.findCustomer(vat);
            if (!customerBoolean) {
                System.out.println("There's no Customer in the data with this VAT");
                new CreateCustomerUI().show();
                controller.findCustomer(vat);
            }
            String conversation = Console.readLine("Conversation details between the customer and the sales_clerk:");
            System.out.println("--------------------------------------------\n");

            System.out.println("--------------------------------------------");
            int identification = Console.readInteger("Order Identification:");
            System.out.println("--------------------------------------------\n");


            System.out.println("-------------DeliveryAddress-----------");
            String street = Console.readLine("Street:");
            int doorNumber = Console.readInteger("Door Number:");
            String postalCode = Console.readLine("Postal Code:");
            String city = Console.readLine("City:");
            String country = Console.readLine("Country:");
            boolean countryBoolean = controller.createCountry(country);
            if (countryBoolean) {
                System.out.println("New Country " + country + " was added to the database.");
            } else {
                System.out.println("Country " + country + " was already registered in the database.");
            }
            System.out.println("--------------------------------------------\n");


            System.out.println("--------------OrderItems-----------------");
            boolean addProduct = false;
            List<Product> catalog = controller.listAll();
            do {
                Product product = (Product) Utils.showAndSelectOne(catalog, "Which product should be added to the order??");
                int quantity = Console.readInteger("How many of " + product.internalCode() + " are to be added to this order??");
                controller.addOrderItem(product, quantity);
                catalog.remove(product);
                if (!catalog.isEmpty())
                    addProduct = Console.readBoolean("Do you wish to add more products?(y/n)");
            } while (addProduct && !catalog.isEmpty());
            System.out.println("--------------------------------------------\n");


            double price = controller.createOrderMeasurements();
            System.out.println("=====================================");
            System.out.println("Order Full Price= " + price + "€");
            System.out.println("=====================================\n");

            System.out.println("------------Payment-------------------------");
            PaymentMethod[] paymentMethods = controller.getPaymentMethods();
            int pmIndex = Utils.showAndSelectIndex(List.of(paymentMethods), "Choose a Payment Method");
            String paymentConfirmation = Console.readLine("Confirmation:");
            System.out.println("--------------------------------------------\n");


            ProductOrder productOrder = controller.createOrder(identification, street, doorNumber, postalCode, city, conversation, systemUser, pmIndex, paymentConfirmation);

            System.out.println("+-===========================================-+");
            System.out.println(productOrder.toString());
            System.out.println("+-===========================================-+");


        } catch (IllegalArgumentException e) {
            System.out.println("--------------------------\n");
            System.out.println("\n" + e.getMessage() + "\n");
            System.out.println("--------------------------\n");

        }
        return false;
    }

    @Override
    public String headline() {
        return "Create an Order on the customer's behalf";
    }
}
