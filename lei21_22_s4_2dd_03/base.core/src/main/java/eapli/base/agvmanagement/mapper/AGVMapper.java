package eapli.base.agvmanagement.mapper;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.mapper.dto.AGVDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ana Rita Silva
 */
public class AGVMapper {

    /**
     * Converts an AGV to an AGV dto
     *
     * @param agv agv to be converted
     * @return new agv dto
     */
    public AGVDTO toDTO(AGV agv) {
        return new AGVDTO(agv);
    }

    /**
     * Converts a list of agvs to a list of agvs dto
     *
     * @param agvList list of agvs
     * @return new agv dto list
     */
    public List<AGVDTO> toDTO(List<AGV> agvList) {
        List<AGVDTO> dtoList = new ArrayList<>();
        for (AGV agv : agvList) {
            dtoList.add(new AGVDTO(agv));
        }
        return dtoList;
    }
}
