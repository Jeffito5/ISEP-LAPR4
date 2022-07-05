package eapli.base.warehousemanagement.application;

import eapli.base.warehousemanagement.domain.Warehouse;
import org.json.simple.parser.ParseException;

import java.io.*;

/**
 * @author Ana Rita Silva
 */
public class SetUpPlantController {

    /**
     * Empty constructor
     */
    public SetUpPlantController() {
    }

    /**
     * Reads the json file, imports and sets the plant
     * @param path the file's path
     * @return warehouse created
     * @throws IOException exception thrown in case of error with the file
     * @throws ParseException exception thrown in case of error with the file
     */
    public Warehouse readFile(String path) throws IOException, ParseException {
        return new JsonReader().readFile(path);
    }

}
