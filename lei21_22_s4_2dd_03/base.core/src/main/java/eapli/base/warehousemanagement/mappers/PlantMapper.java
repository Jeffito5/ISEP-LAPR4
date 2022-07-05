package eapli.base.warehousemanagement.mappers;

import eapli.base.warehousemanagement.domain.Plant;
import eapli.base.warehousemanagement.mappers.dtos.PlantDTO;

import java.util.ArrayList;
import java.util.List;

public class PlantMapper {

    public PlantDTO toDTO(Plant plant){
        return new PlantDTO(plant.length(), plant.width(), plant.square());
    }

    public List<PlantDTO> toDTO(List<Plant> list){
        List<PlantDTO> result = new ArrayList<>();
        for (Plant plant : list){
            result.add(toDTO(plant));
        }
        return result;
    }

}
