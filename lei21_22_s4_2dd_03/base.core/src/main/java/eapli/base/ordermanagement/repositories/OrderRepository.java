package eapli.base.ordermanagement.repositories;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.ordermanagement.domain.Identifier;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Luís Araújo
 */
public interface OrderRepository extends DomainRepository<Identifier, ProductOrder> {

    ProductOrder add(ProductOrder entity);

    Optional<ProductOrder> findById(Identifier id);

    @Override
    List<ProductOrder> findAll();

    List<ProductOrder> findPaid();

    List<ProductOrder> findNotDeliveredForCustomer(Customer customer);

    List<ProductOrder> listOfOrdersPreparedByAGVs();

    List<ProductOrder> listOfOrdersInAscendingOrder();

    List<ProductOrder> listOfOrdersReceived();

    @Override
    default long count() {
        return 0;
    }
}
