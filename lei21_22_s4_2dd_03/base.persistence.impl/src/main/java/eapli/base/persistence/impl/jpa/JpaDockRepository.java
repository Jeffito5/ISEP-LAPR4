package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.warehousemanagement.domain.Dock;
import eapli.base.warehousemanagement.repositories.DockRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JpaDockRepository extends JpaAutoTxRepository<Dock, String, String> implements DockRepository {
    public JpaDockRepository(final TransactionalContext transactionalContext) {
        super(transactionalContext, "id");
    }

    public JpaDockRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "id");
    }


    @Override
    public List<Dock> findAvailableDock() {
        final Map<String, Object> params = new HashMap<>();
        params.put("status", "FREE");
        return match("e.status=:status", params);
    }
}