package eapli.base.app.backoffice.console.presentation.salesclerk;

import eapli.base.categorymanagement.application.CreateCategoryController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

/**
 * @author Ana Rita Silva
 */
public class CreateCategoryUI extends AbstractUI {

    private final CreateCategoryController controller = new CreateCategoryController();

    @Override
    protected boolean doShow() {
        boolean success;
        do {
            success = true;
            try {
                String code = Console.readLine("Insert the category's code:");
                String description = Console.readLine("Insert the category's description:");
                controller.createCategory(code, description);
                System.out.println("New category was created with success");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Try again.");
                success = false;
            }
        } while (!success);

        return false;
    }

    @Override
    public String headline() {
        return "Create New Product's Category";
    }
}
