package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.countrymanagement.domain.Country;
import eapli.base.countrymanagement.repository.CountryRepository;
import eapli.base.ordermanagement.domain.Identifier;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;

/**
 * @author 1201217 Marco Ramos
 */
public class JpaCountryRepository extends JpaAutoTxRepository<Country, Integer, Integer> implements CountryRepository {
    public JpaCountryRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaCountryRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

    @Override
    public Optional<Country> findByName(String name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.name=:name", params);
    }

    @Override
    public boolean containsOfIdentity(Integer id) {
        return CountryRepository.super.containsOfIdentity(id);
    }

    @Override
    public boolean contains(Country entity) {
        return CountryRepository.super.contains(entity);
    }

    @Override
    public long size() {
        return CountryRepository.super.size();
    }

    @Override
    public void remove(Country entity) {
        CountryRepository.super.remove(entity);
    }

    @Override
    public void removeOfIdentity(Integer entityId) {
        CountryRepository.super.removeOfIdentity(entityId);
    }

    @Override
    public Spliterator<Country> spliterator() {
        return super.spliterator();
    }


}
