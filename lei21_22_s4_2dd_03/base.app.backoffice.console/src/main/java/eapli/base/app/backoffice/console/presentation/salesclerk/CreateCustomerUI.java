package eapli.base.app.backoffice.console.presentation.salesclerk;

import eapli.base.customermanagement.application.CreateCustomerController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;


public class CreateCustomerUI extends AbstractUI {

    private final CreateCustomerController createCustomerController = new CreateCustomerController();


    @Override
    protected boolean doShow() {
        boolean proceed;
        List<String> billingAddressList = new ArrayList<>();
        List<String> deliveryAddressList = new ArrayList<>();
        try {
            final String username = Console.readLine("Username:");
            final String password = Console.readLine("Password:");
            final String mecanographicNumber = Console.readLine("MecanographicNumber:");
            final String firstName = Console.readLine("First name");
            final String lastName = Console.readLine("Last name");
            final String vat = Console.readLine("VAT");
            final String email = Console.readLine("E-Mail");
            final String countryIdentification = Console.readLine("Country Identification Number (+351)");
            final String phoneNumber = Console.readLine("Phone Number");
            String gender = "";
            String birthDate = "";
            proceed = Console.readBoolean("Do you wish to add your gender? (y/n)");
            if (proceed)
                gender = Console.readLine("Gender (male,female,other)");
            do {
                proceed = Console.readBoolean("Do you wish to add any Billing Address? (y/n)");
                if (proceed) {
                    list(billingAddressList);
                }

            } while (proceed);

            do {
                proceed = Console.readBoolean("Do you wish to add any Delivery Address? (y/n)");
                if (proceed) {
                    list(deliveryAddressList);
                }
            } while (proceed);

            proceed = Console.readBoolean("Do you wish to add your birth date (dd/mm/yyyy)? (y/n)");
            if (proceed)

                birthDate = Console.readLine("Birth Date");

            createCustomerController.createCustomer(username, password, mecanographicNumber, firstName, lastName, vat, email, countryIdentification, phoneNumber, gender, billingAddressList, deliveryAddressList, birthDate);
            System.out.println(createCustomerController.findCustomer(vat));
        } catch (IllegalArgumentException e) {
            System.out.println("\n\nError:" + e.getMessage());
        }
        return false;
    }

    private void list(List<String> list) {
        list.add(Console.readLine("Street Name"));
        list.add(Console.readLine("Door Number"));
        list.add(Console.readLine("Postal Code"));
        list.add(Console.readLine("City"));
        list.add(Console.readLine("Country"));
    }

    @Override
    public String headline() {
        return "Create Customer";
    }

}
