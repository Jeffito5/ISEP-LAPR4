package eapli.base.productmanagement.repositories;

import eapli.base.productmanagement.domain.BrandName;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Luís Araújo
 */
public interface ProductRepository extends DomainRepository<InternalCode, Product> {
    public Product add(Product entity);

    public Product save(Product entity);

    public Optional<Product> findByCode(InternalCode code);

    public List<BrandName> findBrands();

    @Override
    public List<Product> findAll();

    @Override
    default void delete(Product entity) {

    }

    @Override
    default long count() {
        return 0;
    }
}
