package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.countrymanagement.domain.Country;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.framework.actions.Action;

import java.io.Serializable;

/**
 * @author Guilherme Araújo Sencadas
 */
public class CountryBootstrapper implements Action{

    /**Executes the bootstrap.
     * <p>For More information read Bootstraps' (US1900) README.md
     *
     * @return true if no error appeared.
     */
    @Override
    public boolean execute() {
        registerCountry("Portugal");
        registerCountry("Spain");
        registerCountry("Greece");
        registerCountry("Afghanistan");
        registerCountry("Argentina");
        registerCountry("Jamaica");
        registerCountry("Liberia");
        registerCountry("Mongolia");
        registerCountry("Niger");
        registerCountry("North Macedonia");
        registerCountry("Peru");
        registerCountry("Romania");
        registerCountry("Somalia");
        registerCountry("Sudan");
        return true;
    }

    private void registerCountry(String name) {
        JpaRepository<Country, Serializable> repository = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        repository.add(Country.valueOf(name));
    }
}
