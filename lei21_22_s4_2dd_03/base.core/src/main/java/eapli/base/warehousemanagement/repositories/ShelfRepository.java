package eapli.base.warehousemanagement.repositories;

import eapli.base.warehousemanagement.domain.Shelf;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface ShelfRepository extends DomainRepository<Integer, Shelf> {

    List<Shelf> findAll();

}
