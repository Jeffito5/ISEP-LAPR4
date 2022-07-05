package eapli.base.agvmanagement.application;

import eapli.base.agvmanagement.domain.*;
import eapli.base.agvmanagement.mapper.AGVMapper;
import eapli.base.agvmanagement.mapper.dto.AGVDTO;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehousemanagement.domain.Coordinates;
import eapli.base.warehousemanagement.domain.Dock;
import eapli.base.warehousemanagement.mappers.dtos.DockDTO;
import eapli.base.warehousemanagement.repositories.DockRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
public class ConfigureAGVController {

    private final AGVRepository agvRepository = PersistenceContext.repositories().agvs();

    private final DockRepository dockRepository = PersistenceContext.repositories().docks();

    private final AGVMapper agvMapper;

    private final List<DockDTO> dockDTOS;

    private final List<Dock> docks;


    public ConfigureAGVController() {
        this.agvMapper = new AGVMapper();
        this.docks = dockRepository.findAvailableDock();
        this.dockDTOS = convertsToDTO();
    }

    /**
     * passes the agv configurations to Jpa Repository creating the agv persisted
     *
     * @param maxWeight   max weight
     * @param volume      volume
     * @param status      status
     * @param docker      docker
     * @param autonomy    autonomy
     * @param identifier  identifier
     * @param description description
     * @param model       model
     */
    public void configureAGV(double maxWeight, double volume, String status, int docker, int autonomy, String identifier, String description, String model, int speed) {
        JpaRepository<AGV, Serializable> repository = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        Dock dock = docks.get(docker);
        MaxWeight maxWeight1 = MaxWeight.valueOf(maxWeight);
        Volume volume1 = Volume.valueOf(volume);
        Status status1 = Status.valueOf(status);
        Autonomy autonomy1 = Autonomy.valueOf(autonomy);
        Identifier identifier1 = Identifier.valueOf(identifier);
        Description description1 = Description.valueOf(description);
        Model model1 = Model.valueOf(model);
        Speed speed1 = Speed.valueOf(speed);
        dock.changeStatus();
        dockRepository.save(dock);
        AGV agv = AGV.valueOf(maxWeight1, volume1, status1, dock.identity(), autonomy1, identifier1, description1, model1, speed1);
        repository.add(agv);
    }

    public void updateAGVCoordinates(int id, String length, String width) {
        JpaRepository<AGV, Serializable> repository = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        AGV agv = repository.findById(id);
        agv.updateCoordinates(length, width);
        repository.add(agv);
    }


    /**
     * finds the agv
     *
     * @param identifier identifier
     * @return agv
     */
    public AGVDTO findAGV(String identifier) {
        Identifier identifier1 = Identifier.valueOf(identifier);
        if (agvRepository.findByIdentifier(identifier1).isPresent())
            return agvMapper.toDTO(agvRepository.findByIdentifier(identifier1).get());
        return null;
    }


    public List<DockDTO> convertsToDTO() {
        List<DockDTO> available = new ArrayList<>();
        assert docks != null;
        docks.forEach(e -> available.add(e.toDTO()));
        return available;
    }

    public List<DockDTO> availableDockList() {
        return dockDTOS;
    }
}