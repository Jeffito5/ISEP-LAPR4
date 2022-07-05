package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.CatalogId;
import eapli.base.catalogmanagement.repositories.CatalogRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author Luís Araújo
 */
public class JpaCatalogRepository extends JpaAutoTxRepository<Catalog, CatalogId, CatalogId> implements CatalogRepository {
    public JpaCatalogRepository(final TransactionalContext transactionalContext) {
        super(transactionalContext, "id");
    }

    public JpaCatalogRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public Catalog add(Catalog entity) {
        return null;
    }

    @Override
    public Catalog findByCode(String code) {
        return null;
    }

    @Override
    public Catalog save(Catalog entity) {
        return null;
    }

    @Override
    public Iterable<Catalog> findAll() {
        return null;
    }

    @Override
    public Optional<Catalog> ofIdentity(CatalogId id) {
        return Optional.empty();
    }

    @Override
    public boolean contains(Catalog entity) {
        return CatalogRepository.super.contains(entity);
    }

    @Override
    public void delete(Catalog entity) {

    }

    @Override
    public void deleteOfIdentity(CatalogId entityId) {

    }

    @Override
    public long size() {
        return CatalogRepository.super.size();
    }

    @Override
    public void remove(Catalog entity) {
        CatalogRepository.super.remove(entity);
    }

    @Override
    public void forEach(Consumer<? super Catalog> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<Catalog> spliterator() {
        return super.spliterator();
    }
}
