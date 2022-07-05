package eapli.base.warehousemanagement.application;

import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.warehousemanagement.domain.Aisle;
import eapli.base.warehousemanagement.domain.Coordinates;
import eapli.base.warehousemanagement.domain.Dock;
import eapli.base.warehousemanagement.domain.Plant;
import eapli.base.warehousemanagement.domain.Row;
import eapli.base.warehousemanagement.domain.Shelf;
import eapli.base.warehousemanagement.domain.Warehouse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ana Rita Silva
 */
public class JsonReader {

    JpaRepository<Dock, Serializable> dockRepo;
    JpaRepository<Plant, Integer> plantRepo;
    JpaRepository<Aisle, String> aisleRepo;
    JpaRepository<Row, String> rowRepo;
    JpaRepository<Shelf, String> shelfRepo;


    public JsonReader() {
        dockRepo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        plantRepo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        aisleRepo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        rowRepo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        shelfRepo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
    }

    /**
     * - Reads the json file
     * - Creates the necessary classes
     * - Sets the warehouse plant
     *
     * @param path the file's path
     * @return the created warehouse
     * @throws IOException    exception thrown in case of error with the file
     * @throws ParseException exception thrown in case of error with the file
     */
    public Warehouse readFile(String path) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        List<Aisle> aisleList = new ArrayList<>();
        List<Dock> dockList = new ArrayList<>();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));

        //Removes the existing docks to upload the current ones
        dockRepo.removeAll(dockRepo.findAll());
        plantRepo.removeAll(plantRepo.findAll());
        aisleRepo.removeAll(aisleRepo.findAll());
        rowRepo.removeAll(rowRepo.findAll());
        shelfRepo.removeAll(shelfRepo.findAll());

        //-------------------WAREHOUSE----------------------------------------------------------------------------------
        String name = jsonObject.get("Warehouse").toString();
        String length = jsonObject.get("Length").toString();
        String width = jsonObject.get("Width").toString();
        String square = jsonObject.get("Square").toString();
        String unit = jsonObject.get("Unit").toString();

        //-------------------AISLES-------------------------------------------------------------------------------------
        JSONArray aisles = (JSONArray) jsonObject.get("Aisles");
        for (Object object : aisles) {
            JSONObject aisle = (JSONObject) object;
            String aisleId = aisle.get("Id").toString();

            JSONObject begin = (JSONObject) aisle.get("begin");
            String beginLsquare = null;
            String beginWsquare = null;
            if (begin != null) {
                beginLsquare = begin.get("lsquare").toString();
                beginWsquare = begin.get("wsquare").toString();
            }

            String endLsquare = null;
            String endWsquare = null;
            JSONObject end = (JSONObject) aisle.get("end");
            if (end != null) {
                endLsquare = end.get("lsquare").toString();
                endWsquare = end.get("wsquare").toString();
            }
            JSONObject depth = (JSONObject) aisle.get("depth");
            String depthLsquare = null;
            String depthWsquare = null;
            if (depth != null) {
                depthLsquare = depth.get("lsquare").toString();
                depthWsquare = depth.get("wsquare").toString();
            }
            String accessibility = aisle.get("accessibility").toString();

            //-------------------ROW--------------------------------------------------------------------------------
            JSONArray rows = (JSONArray) aisle.get("rows");
            List<Row> rowList = new ArrayList<>();

            for (Object object2 : rows) {
                JSONObject row = (JSONObject) object2;
                String rowId = row.get("Id").toString();
                JSONObject rowBegin = (JSONObject) row.get("begin");

                String rowBeginLSquare = null;
                String rowBeginWSquare = null;
                if (rowBegin != null) {
                    rowBeginLSquare = rowBegin.get("lsquare").toString();
                    rowBeginWSquare = rowBegin.get("wsquare").toString();
                }

                JSONObject rowEnd = (JSONObject) row.get("end");

                String rowEndLSquare = null;
                String rowEndWSquare = null;
                if (rowEnd != null) {
                    rowEndLSquare = rowEnd.get("lsquare").toString();
                    rowEndWSquare = rowEnd.get("wsquare").toString();
                }

                //-------------------SHELVES------------------------------------------------------------------------
                String shelves = row.get("shelves").toString();
                List<Shelf> shelfList = new ArrayList<>();

                //--------------CREATE ROW AND SHELVES-----------------------------------------------------------
                for (int i = 1; i <= Integer.parseInt(shelves); i++) {
                    Shelf newShelf = new Shelf(i);
                    shelfList.add(newShelf);
                    shelfRepo.add(newShelf);
                }
                Row newRow = new Row(rowId, new Coordinates(rowBeginLSquare, rowBeginWSquare), new Coordinates(rowEndLSquare, rowEndWSquare), shelfList);
                rowList.add(newRow);
                rowRepo.add(newRow);
            }
            //--------------CREATE AISLES-----------------------------------------------------------

            Aisle newAisle = new Aisle(aisleId, new Coordinates(beginLsquare, beginWsquare), new Coordinates(endLsquare, endWsquare), new Coordinates(depthLsquare, depthWsquare), accessibility, rowList);
            aisleList.add(newAisle);
            aisleRepo.add(newAisle);
            //-------------------AGV_DOCK--------------------------------------------------------------------------------
            JSONArray docks = (JSONArray) jsonObject.get("AGVDocks");
            for (Object object3 : docks) {
                JSONObject dock = (JSONObject) object3;
                String dockId = dock.get("Id").toString();

                JSONObject dockBegin = (JSONObject) dock.get("begin");
                String dockBeginLsquare = null;
                String dockBeginWsquare = null;
                if (dockBegin != null) {
                    dockBeginLsquare = dockBegin.get("lsquare").toString();
                    dockBeginWsquare = dockBegin.get("wsquare").toString();
                }

                JSONObject dockEnd = (JSONObject) dock.get("end");
                String dockEndLsquare = null;
                String dockEndWsquare = null;
                if (dockEnd != null) {
                    dockEndLsquare = dockEnd.get("lsquare").toString();
                    dockEndWsquare = dockEnd.get("wsquare").toString();
                }

                JSONObject dockDepth = (JSONObject) dock.get("depth");
                String dockDepthLsquare = null;
                String dockDepthWsquare = null;
                if (dockDepth != null) {
                    dockDepthLsquare = dockDepth.get("lsquare").toString();
                    dockDepthWsquare = dockDepth.get("wsquare").toString();
                }

                String dockAccessibility = dock.get("accessibility").toString();

                Dock newDock = new Dock(dockId, new Coordinates(dockBeginLsquare, dockBeginWsquare), new Coordinates(dockEndLsquare, dockEndWsquare), new Coordinates(dockDepthLsquare, dockDepthWsquare), dockAccessibility);

                if (dockRepo.findById(dockId) == null) {
                    dockRepo.add(newDock);
                    dockList.add(newDock);
                }
            }
        }

        //-------------------------------------CREATE AND SAVE OBJECTS-----------------------------------------------------------

        Plant plant = new Plant(length, width, square, unit, aisleList, dockList);
        plantRepo.add(plant);

        return new Warehouse(name, plant);
    }
}
