package eapli.base.countrymanagement.repository;

import eapli.base.countrymanagement.domain.Country;
import eapli.base.ordermanagement.domain.Identifier;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;


public interface CountryRepository extends DomainRepository<Integer, Country> {

    Optional<Country> findByName(String name);
}
