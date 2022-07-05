package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.categorymanagement.application.CreateCategoryController;
import eapli.framework.actions.Action;

/**
 * @author Guilherme Araújo Sencadas
 */


public class CategoryBootstrapper implements Action{

    /**Executes the bootstrap.
     * <p>For More information read Bootstraps' (US1900) README.md
     *
     * @return true if no error appeared.
     */
    @Override
    public boolean execute() {
        CreateCategoryController controller= new CreateCategoryController();

        controller.createCategory("Male",  "Represents products for MALE clients.");
        controller.createCategory("Female","Represents products for FEMALE clients.");
        controller.createCategory("Sports","Represents products for SPORTS practitioners.");
        controller.createCategory("Hygiene",  "Represents HYGIENE products.");
        controller.createCategory("Beauty","Represents BEAUTY products.");
        controller.createCategory("Decoration","Represents DECORATION products.");
        controller.createCategory("Food","Represents PROVISIONING products.");
        controller.createCategory("Technology","Represents TECHNOLOGY products.");

        return true;
    }
}