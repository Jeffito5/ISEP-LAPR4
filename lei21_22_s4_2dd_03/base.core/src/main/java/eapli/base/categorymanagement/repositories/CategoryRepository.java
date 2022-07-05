package eapli.base.categorymanagement.repositories;

import eapli.base.categorymanagement.domain.Code;
import eapli.base.categorymanagement.domain.Category;
import eapli.framework.domain.repositories.DomainRepository;


/**
 * @author Ana Rita Silva
 */
public interface CategoryRepository extends DomainRepository<Code, Category>{

    public Category add(Category entity);

    public Category save(Category entity);

    public Category findByCode(String code);

    @Override
    public Iterable<Category> findAll();

    @Override
    default void delete(Category entity) {

    }

    @Override
    default long count() {
        return 0;
    }
}
