package eapli.base.warehousemanagement.mappers;

import eapli.base.warehousemanagement.domain.Aisle;
import eapli.base.warehousemanagement.domain.Plant;
import eapli.base.warehousemanagement.mappers.dtos.AisleDTO;
import eapli.base.warehousemanagement.mappers.dtos.PlantDTO;

import java.util.ArrayList;
import java.util.List;

public class AisleMapper {

    public AisleDTO toDTO(Aisle aisle){
        return new AisleDTO(aisle.begin(),aisle.end());
    }

    public List<AisleDTO> toDTO(List<Aisle> list){
        List<AisleDTO> result = new ArrayList<>();
        for (Aisle aisle : list){
            result.add(toDTO(aisle));
        }
        return result;
    }

}
