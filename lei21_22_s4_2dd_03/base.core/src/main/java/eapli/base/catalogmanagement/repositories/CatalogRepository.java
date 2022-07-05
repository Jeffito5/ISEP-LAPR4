package eapli.base.catalogmanagement.repositories;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.CatalogId;
import eapli.framework.domain.repositories.DomainRepository;

/**
 * @author Luís Araújo
 */
public interface CatalogRepository extends DomainRepository<CatalogId, Catalog> {
    public Catalog add(Catalog entity);

    public Catalog save(Catalog entity);

    public Catalog findByCode(String code);

    @Override
    public Iterable<Catalog> findAll();

    @Override
    default void delete(Catalog entity) {

    }

    @Override
    default long count() {
        return 0;
    }
}
