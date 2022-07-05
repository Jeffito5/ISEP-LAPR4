package eapli.base.agvmanagement.repositories;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.Identifier;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.warehousemanagement.domain.Coordinates;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

public interface AGVRepository extends DomainRepository<Integer,AGV> {

    Optional<AGV> findByIdentifier(Identifier identifier);

    List<AGV> isAble(ProductOrder order);

    List<AGV> findAGVByOrderId(eapli.base.ordermanagement.domain.Identifier identifier);

    List<AGV> findAGVOccupied();
}
