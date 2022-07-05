package eapli.base.warehousemanagement.repositories;

import eapli.base.warehousemanagement.domain.Dock;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;


public interface DockRepository  extends DomainRepository<String, Dock> {

    List<Dock> findAvailableDock();


}