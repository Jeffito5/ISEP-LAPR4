package eapli.base.app.backoffice.console.presentation.warehouseemployee;

import eapli.base.warehousemanagement.application.SetUpPlantController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class SetUpPlantUI extends AbstractUI {

    SetUpPlantController controller = new SetUpPlantController();

    @Override
    protected boolean doShow() {
        boolean success = true;
        do {
            String path = Console.readLine("Insert the file's path:");
            try {
                System.out.println(controller.readFile(path).toString());
                System.out.println("The plant was uploaded with success!");
            } catch (IOException | ParseException e) {
                System.out.println("Invalid path or file, try again.");
                success = false;
            }
        } while (!success);

        return false;
    }

    @Override
    public String headline() {
        return "Set up the warehouse plant";
    }
}
