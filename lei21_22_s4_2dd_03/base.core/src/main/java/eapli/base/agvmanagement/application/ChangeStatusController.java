package eapli.base.agvmanagement.application;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.Identifier;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
public class ChangeStatusController {

    private final AGVRepository agvRepository = PersistenceContext.repositories().agvs();

    private AGV agv;

    /**
     * gets the agv
     * @param agvIdentifier agv identifier
     * @return agv
     */
    public boolean getAGVByIdentifier(String agvIdentifier) {
        if (agvRepository.findByIdentifier(Identifier.valueOf(agvIdentifier)).isPresent()) {
            agv = agvRepository.findByIdentifier(Identifier.valueOf(agvIdentifier)).get();
            return true;
        }
        return false;

    }

    /**
     * checks agv status
     * @param status status
     * @return true or false
     */
    public boolean checkAGVStatus(String status) {
        return agv.agvStatus().status().equals(status.toUpperCase());
    }

    /**
     * checks if the status exists
     * @param status status
     * @return true or false
     */
    public boolean checkStatusExistence(String status) {
        return agv.agvStatus().changeStatus(status.toUpperCase());
    }

    /**
     * updates the agv status
     * @return new agv
     */
    public String updateStatusForAGV() {
        agvRepository.save(agv);
        return agv.toString();
    }
}
