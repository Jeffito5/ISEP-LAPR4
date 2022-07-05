package eapli.base.agvmanagement.mapper.dto;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.Identifier;
import eapli.base.warehousemanagement.domain.Coordinates;

/**
 * @author Ana Rita Silva
 */
public class AGVDTO {

    public Identifier identifier;
    public String toString;
    public String status;
    public int autonomy;
    public Coordinates coordinates;

    /**
     * Converts an AGV to an AGV DTO
     *
     * @param agv agv to be converted
     */
    public AGVDTO(AGV agv) {
        this.identifier = agv.identifier();
        this.toString = agv.toString();
        this.status = agv.status();
        this.autonomy = agv.autonomy();
        this.coordinates = agv.coordinates();
    }

    @Override
    public String toString() {
        return toString;
    }
}
