package eapli.base.infrastructure.bootstrapers;

import eapli.base.warehousemanagement.application.SetUpPlantController;
import eapli.framework.actions.Action;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class PlantBootstrapper implements Action {

    @Override
    public boolean execute() {
        SetUpPlantController controller = new SetUpPlantController();
        try {
            controller.readFile("warehouse.json");
            // controller.readFile(createFile().getName());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return true;
    }

    public File createFile() {
        File file = null;
        try {
            file = new File("default_plant.json");
            file.createNewFile();
            FileWriter writer = new FileWriter(file.getName());
            writer.write("{\n" + "\t\"Warehouse\": \"Warehouse Default\",\n" + "\t\"Length\": 900,\n" +
                    "\t\"Width\": 500,\n" + "\t\"Square\": 50,\n" + "\t\"Unit\": \"m\",\n" + "\t\"Aisles\":[ \n" +
                    "\t\t{ \n" + "\t\t\t\"Id\":1, \n" + "\t\t\t\"begin\": {\"lsquare\":4, \"wsquare\":1}, \n" +
                    "\t\t\t\"end\": {\"lsquare\":12, \"wsquare\":1}, \n" + "\t\t\t\"depth\":{\"lsquare\":12, \"wsquare\":1}, \n" +
                    "\t\t\t\"accessibility\":\"w+\", \n" + "\t\t\t\"rows\":[ \n" +
                    "\t\t\t\t{\n" + "\t\t\t\t\t\"Id\":1, \n" + "\t\t\t\t\t\"begin\": {\"lsquare\":5, \"wsquare\":1}, \n" +
                    "\t\t\t\t\t\"end\": {\"lsquare\":7, \"wsquare\":1}, \n" +
                    "\t\t\t\t\t\"shelves\":2\n" + "\t\t\t\t},\n" + "\t\t\t\t{\n" +
                    "\t\t\t\t\t\"Id\":2, \n" + "\t\t\t\t\t\"begin\": {\"lsquare\":8, \"wsquare\":1}, \n" +
                    "\t\t\t\t\t\"end\": {\"lsquare\":12, \"wsquare\":1},\n" + "\t\t\t\t\t\"shelves\":5\n" +
                    "\t\t\t\t},\n" + "\t\t\t\t{\n" + "\t\t\t\t\t\"Id\":3, \n" +
                    "\t\t\t\t\t\"begin\": {\"lsquare\":13, \"wsquare\":1}, \n" +
                    "\t\t\t\t\t\"end\": {\"lsquare\":16, \"wsquare\":1}, \n" +
                    "\t\t\t\t\t\"shelves\":1\n" + "\t\t\t\t}\n" + "\t\t\t]\n" + "\t\t},\n" + "\t\t{ \n" +
                    "\t\t\t\"Id\":2, \n" + "\t\t\t\"begin\": {\"lsquare\":5, \"wsquare\":8}, \n" +
                    "\t\t\t\"end\": {\"lsquare\":16, \"wsquare\":10}, \n" + "\t\t\t\"depth\":{\"lsquare\":14, \"wsquare\":9}, \n" +
                    "\t\t\t\"accessibility\":\"w-\", \n" + "\t\t\t\"rows\":[ \n" + "\t\t\t\t{\n" +
                    "\t\t\t\t\t\"Id\":1, \n" + "\t\t\t\t\t\"begin\": {\"lsquare\":5, \"wsquare\":8}, \n" +
                    "\t\t\t\t\t\"end\": {\"lsquare\":9, \"wsquare\":8}, \n" + "\t\t\t\t\t\"shelves\":7\n" +
                    "\t\t\t\t},\n" + "\t\t\t\t{\n" + "\t\t\t\t\t\"Id\":2, \n" + "\t\t\t\t\t\"begin\": {\"lsquare\":10, \"wsquare\":8}, \n" +
                    "\t\t\t\t\t\"end\": {\"lsquare\":11, \"wsquare\":8}, \n" + "\t\t\t\t\t\"shelves\":2\n" + "\t\t\t\t},\n" +
                    "\t\t\t\t{\n" + "\t\t\t\t\t\"Id\":3, \n" + "\t\t\t\t\t\"begin\": {\"lsquare\":12, \"wsquare\":8}, \n" +
                    "\t\t\t\t\t\"end\": {\"lsquare\":12, \"wsquare\":8}, \n" + "\t\t\t\t\t\"shelves\":5\n" + "\t\t\t\t},\n" +
                    "\t\t\t\t{\n" + "\t\t\t\t\t\"Id\":4, \n" + "\t\t\t\t\t\"begin\": {\"lsquare\":13, \"wsquare\":8}, \n" +
                    "\t\t\t\t\t\"end\": {\"lsquare\":17, \"wsquare\":8}, \n" + "\t\t\t\t\t\"shelves\":6\n" +
                    "\t\t\t\t}\n" + "\t\t\t]\n" + "\t\t},\n" + "\t\t{ \n" + "\t\t\t\"Id\":3, \n" +
                    "\t\t\t\"begin\": {\"lsquare\":5, \"wsquare\":11}, \n" + "\t\t\t\"end\": {\"lsquare\":17, \"wsquare\":12}, \n" +
                    "\t\t\t\"depth\":{\"lsquare\":16, \"wsquare\":10}, \n" + "\t\t\t\"accessibility\":\"w+\", \n" + "\t\t\t\"rows\":[ \n" + "\t\t\t\t{\n" +
                    "\t\t\t\t\t\"Id\":1, \n" + "\t\t\t\t\t\"begin\": {\"lsquare\":6, \"wsquare\":11}, \n" + "\t\t\t\t\t\"end\": {\"lsquare\":11, \"wsquare\":11}, \n" +
                    "\t\t\t\t\t\"shelves\":5\n" + "\t\t\t\t},\n" + "\t\t\t\t{\n" +
                    "\t\t\t\t\t\"Id\":2, \n" + "\t\t\t\t\t\"begin\": {\"lsquare\":12, \"wsquare\":11}, \n" +
                    "\t\t\t\t\t\"end\": {\"lsquare\":18, \"wsquare\":11}, \n" + "\t\t\t\t\t\"shelves\":10\n" +
                    "\t\t\t\t}\n" + "\t\t\t]\n" + "\t\t}\n" + "\t],\n" + "\t\"AGVDocks\":[ \n" + "\t\t{\n" +
                    "\t\t\t\"Id\":\"D1\", \n" + "\t\t\t\"begin\": {\"lsquare\":1, \"wsquare\":3}, \n" +
                    "\t\t\t\"end\": {\"lsquare\":1, \"wsquare\":4}, \n" + "\t\t\t\"depth\":{\"lsquare\":1, \"wsquare\":3}, \n" +
                    "\t\t\t\"accessibility\":\"l+\"\n" + "\t\t},\n" + "\t\t{\n" + "\t\t\t\"Id\":\"D2\", \n" +
                    "\t\t\t\"begin\": {\"lsquare\":1, \"wsquare\":5}, \n" + "\t\t\t\"end\": {\"lsquare\":1, \"wsquare\":4}, \n" +
                    "\t\t\t\"depth\":{\"lsquare\":1, \"wsquare\":5}, \n" + "\t\t\t\"accessibility\":\"l+\"\n" + "\t\t},\n" +
                    "\t\t{\n" + "\t\t\t\"Id\":\"D3\", \n" + "\t\t\t\"begin\": {\"lsquare\":1, \"wsquare\":10}, \n" +
                    "\t\t\t\"end\": {\"lsquare\":1, \"wsquare\":12}, \n" + "\t\t\t\"depth\":{\"lsquare\":1, \"wsquare\":11}, \n" +
                    "\t\t\t\"accessibility\":\"l+\"\n" + "\t\t}\n" + "\t]\n" + "}");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred creating the file.");
            e.printStackTrace();
        }
        return file;
    }
}
