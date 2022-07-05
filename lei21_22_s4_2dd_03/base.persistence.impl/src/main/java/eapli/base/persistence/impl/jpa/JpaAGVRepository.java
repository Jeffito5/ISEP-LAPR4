package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.Identifier;
import eapli.base.agvmanagement.domain.Status;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.warehousemanagement.domain.Coordinates;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;
import java.util.function.Consumer;

public class JpaAGVRepository extends JpaAutoTxRepository<AGV, Integer, Integer> implements AGVRepository {

    public JpaAGVRepository(final TransactionalContext transactionalContext) {
        super(transactionalContext, "id");
    }

    public JpaAGVRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public Optional<AGV> findByIdentifier(Identifier identifier) {
        final Map<String, Object> params = new HashMap<>();
        params.put("identifier", identifier);
        return matchOne("e.identifier=:identifier", params);
    }

    public List<AGV> isAble(ProductOrder order) {
        Iterable<AGV> all = findAll();
        List<AGV> able = new ArrayList<>();

        for (AGV agv : all) {
            if (isAvailable(agv) && (order.orderMeasurements().maxWeight() <= agv.maxWeight()) && (order.orderMeasurements().volume() <= agv.volume())) {
                able.add(agv);
            }
        }

        return able;
    }

    public boolean isAvailable(AGV agv) {
        return agv.status().equalsIgnoreCase(Status.FREE);
    }

    @Override
    public void forEach(Consumer<? super AGV> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<AGV> spliterator() {
        return super.spliterator();
    }

    @Override
    public List<AGV> findAGVByOrderId(eapli.base.ordermanagement.domain.Identifier identifier) {
        Query query = Persistence.createEntityManagerFactory("eapli.base").createEntityManager().createQuery(
                "SELECT e FROM AGV e WHERE e.status.order.identifier=:m");
        query.setParameter("m", identifier);
        List<AGV> list = query.getResultList();
        return list;
    }

    @Override
    public List<AGV> findAGVOccupied(){
        Query query = Persistence.createEntityManagerFactory("eapli.base").createEntityManager().createQuery(
                "SELECT e FROM AGV e WHERE e.status.status=:m");
        query.setParameter("m", Status.OCCUPIED);
        List<AGV> list = query.getResultList();
        return list;
    }
}
