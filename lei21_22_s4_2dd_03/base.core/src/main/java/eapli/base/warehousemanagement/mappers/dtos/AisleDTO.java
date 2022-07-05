package eapli.base.warehousemanagement.mappers.dtos;

import eapli.base.warehousemanagement.domain.Coordinates;

public class AisleDTO {
    public Coordinates begin;
    public Coordinates end;

    public AisleDTO(Coordinates begin, Coordinates end){
        this.begin = begin;
        this.end = end;
    }
}
