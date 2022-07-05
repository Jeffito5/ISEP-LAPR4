package eapli.base.customermanagement.repositories;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.domain.Email;
import eapli.base.customermanagement.domain.VAT;
import eapli.base.surveymanagement.domain.survey.TargetAudience;
import eapli.base.surveymanagement.domain.survey.TimeInterval;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author 1201217 Marco Ramos
 */
public interface CustomerRepository extends DomainRepository<Integer, Customer> {

    Optional<Customer> findByVat(VAT vat);

    Optional<Customer> findByEmail(Email email);

    List<Customer> findByTarget(TargetAudience target);
}
