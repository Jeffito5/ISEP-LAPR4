package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.warehousemanagement.domain.Shelf;
import eapli.base.warehousemanagement.repositories.ShelfRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.List;

public class JpaShelfRepository  extends JpaAutoTxRepository<Shelf, Integer, Integer> implements ShelfRepository {

    public JpaShelfRepository(final TransactionalContext transactionalContext) {
        super(transactionalContext, "identifier");
    }

    public JpaShelfRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "identifier");
    }

    @Override
    public List<Shelf> findAll() {
        Query query = entityManager().createQuery(
                "SELECT e FROM Shelf e");
        List<Shelf> list = query.getResultList();
        return list;
    }
}
