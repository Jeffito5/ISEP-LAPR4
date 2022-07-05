package eapli.base.servermanagement;

import eapli.base.AppSettings;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.mapper.AGVMapper;
import eapli.base.agvmanagement.mapper.dto.AGVDTO;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.warehousemanagement.domain.Aisle;
import eapli.base.warehousemanagement.domain.Dock;
import eapli.base.warehousemanagement.domain.Plant;
import eapli.base.warehousemanagement.mappers.AisleMapper;
import eapli.base.warehousemanagement.mappers.dtos.AisleDTO;
import eapli.base.warehousemanagement.mappers.dtos.DockDTO;
import eapli.base.warehousemanagement.mappers.PlantMapper;
import eapli.base.warehousemanagement.mappers.dtos.PlantDTO;
import eapli.framework.infrastructure.authz.domain.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class ServerController {

    private String port;

    /**
     * Creates a new Server Thread running independently.
     * <p>
     *     Copies the baseInfo.js file to place the reload time from the application.properties
     * </p>
     *
     * @throws IOException Thrown by FileWriter and BufferedReader
     */
    public void createServer() throws IOException {
        port = new AppSettings().getPort();
        String reloadTime = new AppSettings().getReloadTime();

        File script = new File("www/baseInfo.js");
        File newScript = new File("www/info.js");
        String line;
        BufferedReader bf = new BufferedReader(new FileReader(script));
        FileWriter fileWriter = new FileWriter(newScript);
        while ((line = bf.readLine()) != null) {
            fileWriter.append(line).append("\n");
        }
        fileWriter.append("const reloadTime =").append(reloadTime).append(";");
        fileWriter.close();
        String[] args = new String[]{port};

        Server server = new Server(args);
        server.start();
    }

    /**Does a simple login for the Warehouse Employee or Admin
     *
     * @param username User's username to be used in the login.
     * @param password User's password to be used in the login.
     * @return True if success, False otherwise.
     */
    public boolean doLogin(String username, String password) {
        try {
            JpaRepository<SystemUser, Username> repo = new JpaRepository<>() {
                @Override
                protected String persistenceUnitName() {
                    return null;
                }
            };
            SystemUser su = repo.findById(Username.valueOf(username));
            Collection<Role> roles = su.roleTypes();

            if (su.passwordMatches(password, new PlainTextEncoder())) {
                for (Role role : roles) {
                    if (role.toString().equalsIgnoreCase("admin") || role.toString().equalsIgnoreCase("warehouse_employee"))
                        return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**Gets all the Ip Addresses available to be used.
     *
     * @return String to print in the UI with all the server Ip Addresses.
     * @throws Exception Thrown by Server.getIpAddress()
     */
    public String getIPAddress() throws Exception {
        String result = "";
        for (String ip : Server.getIpAddress()) {
            result += "Ip: " + ip + ":" + port + "\n";
        }

        return result;
    }

    /**Gets the list of AGVs in the DataBase
     *
     * @return List of DTO with all AGVs
     */
    public List<AGVDTO> getAgvsDTO() {
        JpaRepository<AGV, Integer> agvRepo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        return new AGVMapper().toDTO(agvRepo.findAll());
    }

    /**Gets the list of Plants in the DataBase.
     * <p> (Only first plant being used here)</p>
     *
     * @return List of DTO with all PLants
     */
    public List<PlantDTO> getPlants() {
        JpaRepository<Plant, Integer> plantRepo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        return new PlantMapper().toDTO(plantRepo.findAll());
    }

    /**Gets the list of Aisles in the DataBase
     *
     * @return List of DTO with all Aisles
     */
    public List<AisleDTO> getAisles() {
        JpaRepository<Aisle, Integer> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        return new AisleMapper().toDTO(repo.findAll());
    }

    /**Gets the list of Docks in the DataBase
     *
     * @return List of DTO with all Docks
     */
    public List<DockDTO> getDocks() {
        JpaRepository<Dock, String> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        List<DockDTO> result = new ArrayList<>();
        for (Dock dock : repo.findAll()) {
            result.add(dock.toDTO());
        }
        return result;
    }
}
