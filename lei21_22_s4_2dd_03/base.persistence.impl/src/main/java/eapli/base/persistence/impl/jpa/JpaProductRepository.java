package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.productmanagement.domain.BrandName;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author Luís Araújo
 */
public class JpaProductRepository extends JpaAutoTxRepository<Product, InternalCode, InternalCode> implements ProductRepository {
    public JpaProductRepository(final TransactionalContext transactionalContext) {
        super(transactionalContext, "internalCode");
    }

    public JpaProductRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "internalCode");
    }

    @Override
    public Product add(Product entity) {

        return null;
    }

    @Override
    public Optional<Product> findByCode(InternalCode code) {
        final Map<String, Object> params = new HashMap<>();
        params.put("internalCode", code);
        return matchOne("e.internalCode=:internalCode", params);
    }

    @Override
    public Product save(Product entity) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        Query query = entityManager().createQuery(
                "SELECT e FROM Product e");
        List<Product> list = query.getResultList();
        return list;
    }

    public List<BrandName> findBrands() {
        Query query = entityManager().createQuery(
                "SELECT DISTINCT brandName FROM Product"
        );
        List<BrandName> brands = query.getResultList();
        return brands;
    }

    @Override
    public Optional<Product> ofIdentity(InternalCode id) {
        return Optional.empty();
    }

    @Override
    public boolean contains(Product entity) {
        return ProductRepository.super.contains(entity);
    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public void deleteOfIdentity(InternalCode entityId) {

    }

    @Override
    public long size() {
        return ProductRepository.super.size();
    }

    @Override
    public void remove(Product entity) {
        ProductRepository.super.remove(entity);
    }

    @Override
    public void forEach(Consumer<? super Product> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<Product> spliterator() {
        return super.spliterator();
    }
}
