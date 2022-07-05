package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.categorymanagement.domain.Code;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;

public class JpaCategoryRepository extends JpaAutoTxRepository<Category, Code, Code> implements CategoryRepository {

    public JpaCategoryRepository(final TransactionalContext transactionalContext) {
        super(transactionalContext, "code");
    }

    public JpaCategoryRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "code");
    }

    @Override
    public Category add(Category entity) {
        return null;
    }

    @Override
    public Category findByCode(String code) {
        return null;
    }

    @Override
    public Category save(Category entity) {
        return null;
    }

    @Override
    public Iterable<Category> findAll() {
        return null;
    }

    @Override
    public Optional<Category> ofIdentity(Code id) {
        return Optional.empty();
    }

    @Override
    public boolean contains(Category entity) {
        return CategoryRepository.super.contains(entity);
    }

    @Override
    public void delete(Category entity) {

    }

    @Override
    public void deleteOfIdentity(Code entityId) {

    }

    @Override
    public long size() {
        return CategoryRepository.super.size();
    }

    @Override
    public void remove(Category entity) {
        CategoryRepository.super.remove(entity);
    }

    @Override
    public void forEach(Consumer<? super Category> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<Category> spliterator() {
        return super.spliterator();
    }
}
