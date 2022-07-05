package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.clientusermanagement.application.AcceptRefuseSignupFactory;
import eapli.base.clientusermanagement.application.AcceptRefuseSignupRequestController;
import eapli.base.clientusermanagement.domain.SignupRequest;
import eapli.base.customermanagement.application.CreateCustomerController;
import eapli.base.infrastructure.bootstrapers.TestDataConstants;
import eapli.base.myclientuser.application.SignupController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guilherme Araújo Sencadas
 */
public class CustomerBootstrapper implements Action {

    private final CreateCustomerController createCustomerController = new CreateCustomerController();

    /**
     * Executes the bootstrap.
     * <p>For More information read Bootstraps' (US1900) README.md
     *
     * @return true if no error appeared.
     */
    @Override
    public boolean execute() {

        List<String> billAddress = new ArrayList<>();
        billAddress.add("St. 3");
        billAddress.add("73");
        billAddress.add("9999-9999");
        billAddress.add("New York");
        billAddress.add("EUA");

        createCustomerController.createCustomer("RitaSilva", TestDataConstants.PASSWORD1, "1201228", "Ana", "Rita", "444444441", "anaRita@gmail.com", "+351", "444444441", "Female", billAddress, new ArrayList<>(), "13/04/2002");
        createCustomerController.createCustomer("GuilhermeSencadas", TestDataConstants.PASSWORD1, "1201180", "Guilherme", "Sencadas", "444444442", "guilhermeSencadas@gmail.com", "+351", "444444442", "Male", billAddress, new ArrayList<>(), "13/04/2002");
        createCustomerController.createCustomer("LucasGuimaraes", TestDataConstants.PASSWORD1, "1201216", "Lucas", "Guimaraes", "444444443", "lucasGuimaraes@gmail.com", "+351", "444444443", "Male", billAddress, new ArrayList<>(), "13/04/2002");
        createCustomerController.createCustomer("MarcoRamos", TestDataConstants.PASSWORD1, "1201217", "Marco", "Ramos", "444444444", "marcoRamos@gmail.com", "+444", "444444444", "Male", billAddress, new ArrayList<>(), "04/04/2002");
        createCustomerController.createCustomer("LuisAraujo", TestDataConstants.PASSWORD1, "1190827", "Luis", "Araujo", "444444445", "luisAraujo@gmail.com", "+351", "444444445", "Male", billAddress, new ArrayList<>(), "13/04/2002");

        createCustomerController.createCustomer("BeaGalileu", TestDataConstants.PASSWORD1, "thur34", "Beatrice", "Galileu", "000000001", "bea1@gmail.com", "+351", "100000001", "Female", billAddress, billAddress, "02/04/1999");
        createCustomerController.createCustomer("JohnSmith", TestDataConstants.PASSWORD1, "12f45e", "Jonathan", "Smith", "000000002", "jj@gmail.com", "+351", "100000002", "Male", billAddress, billAddress, "03/12/2000");
        createCustomerController.createCustomer("DeepInside", TestDataConstants.PASSWORD1, "321f4e", "Johnny", "Deep", "000000003", "JDeep@gmail.com", "+351", "100000003", "Male", billAddress, billAddress, "04/11/1950");
        createCustomerController.createCustomer("Listening", TestDataConstants.PASSWORD1, "hu765r", "Amber", "Listen", "000000004", "AmbyLi@gmail.com", "+351", "100000004", "Female", billAddress, billAddress, "05/10/2016");
        createCustomerController.createCustomer("Mohamed1290", TestDataConstants.PASSWORD1, "tu56me", "Mohamed", "Ali", "000000005", "MoLi@gmail.com", "+351", "100000005", "Male", billAddress, billAddress, "06/09/2000");
        createCustomerController.createCustomer("JesusWithMoney", TestDataConstants.PASSWORD1, "43gmd4", "Jesus", "Rich", "000000006", "GodSon@gmail.com", "+351", "100000006", "Male", billAddress, billAddress, "07/08/1900");
        createCustomerController.createCustomer("PlantHunter", TestDataConstants.PASSWORD1, "rr56h7", "Hunter", "Veggie", "000000007", "HuVe@gmail.com", "+351", "100000007", "Male", billAddress, billAddress, "01/07/2000");


        return true;
    }
}
