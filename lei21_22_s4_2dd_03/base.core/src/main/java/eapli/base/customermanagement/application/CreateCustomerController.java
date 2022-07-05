package eapli.base.customermanagement.application;

import eapli.base.clientusermanagement.application.AcceptRefuseSignupFactory;
import eapli.base.clientusermanagement.application.AcceptRefuseSignupRequestController;
import eapli.base.clientusermanagement.domain.SignupRequest;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.customermanagement.domain.*;
import eapli.base.countrymanagement.domain.Country;
import eapli.base.customermanagement.domain.Name;
import eapli.base.customermanagement.dto.CustomerDTO;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.myclientuser.application.SignupController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
public class CreateCustomerController {

    private final AcceptRefuseSignupRequestController acceptController = AcceptRefuseSignupFactory
            .build();

    private final SignupController signupController = new SignupController();


    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();

    private final UserRepository userRepository = PersistenceContext.repositories().users();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();

    /**
     * passes the customer attributes to Jpa Repository creating the customer persisted
     *
     * @param firstName             firstName
     * @param lastName              lastName
     * @param vat                   vat
     * @param email                 email
     * @param countryIdentification country
     * @param phoneNumber           phone number
     * @param gender                gender
     * @param billingAddress        billing address
     * @param deliveryAddress       delivery address
     * @param birthDate             birthdate
     */
    public void createCustomer(String username, String password, String mecanographicNumber, String firstName, String lastName, String vat, String email, String countryIdentification, String phoneNumber, String gender, List<String> billingAddress, List<String> deliveryAddress, String birthDate) {
        JpaRepository<Customer, Serializable> repository = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        JpaRepository<Country, Serializable> repository2 = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        List<Address> billing = new ArrayList<>();
        List<Address> delivery = new ArrayList<>();
        makeAddressAndCountry(billingAddress, billing, repository2);
        makeAddressAndCountry(deliveryAddress, delivery, repository2);
        Telephone telephone = Telephone.valueOf(countryIdentification, Integer.parseInt(phoneNumber));
        Name name1 = Name.valueOf(firstName, lastName);
        VAT vat1 = VAT.valueOf(vat);
        Email email1 = Email.valueOf(email);
        Gender gender1 = Gender.valueOf(gender);
        BirthDate birthDate1 = BirthDate.valueOf(birthDate);
        JpaRepository<ShoppingCart, Serializable> repository1 = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        ShoppingCart shoppingCart = ShoppingCart.valueOf(new ArrayList<>(), 0);
        repository1.add(shoppingCart);

        Customer customer = Customer.valueOf(name1, vat1, email1, telephone, gender1, billing, delivery, birthDate1, shoppingCart);
        signupAndApprove(username, password, firstName, lastName, email, mecanographicNumber);
        repository.add(customer);
    }

    public SignupRequest signupAndApprove(final String username, final String password,
                                          final String firstName, final String lastName, final String email,
                                          final String mecanographicNumber) {
        SignupRequest request = null;
        try {
            request = signupController.signup(username, password, firstName, lastName, email,
                    mecanographicNumber);
            acceptController.acceptSignupRequest(request);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
        }
        return request;
    }

    /**
     * creates the address and/or the country persisted
     *
     * @param givingList    list of strings
     * @param receivingList list of address
     * @param repository2   Jpa repository
     */
    private void makeAddressAndCountry(List<String> givingList, List<Address> receivingList, JpaRepository<Country, Serializable> repository2) {
        for (int i = 0; i < givingList.size(); i += 5) {
            Country country = Country.valueOf(givingList.get(i + 4));
            boolean b = true;
            Address address = null;
            for (Country c : repository2.findAll()) {
                if (c.name().equalsIgnoreCase(country.name())) {
                    address = Address.valueOf(givingList.get(i), Integer.parseInt(givingList.get(i + 1)), givingList.get(i + 2), givingList.get(i + 3), c);
                    b = false;
                    break;
                }
            }
            if (b) {
                repository2.add(country);
                address = Address.valueOf(givingList.get(i), Integer.parseInt(givingList.get(i + 1)), givingList.get(i + 2), givingList.get(i + 3), country);
            }
            receivingList.add(address);
        }
    }


    /**
     * finds the customer
     *
     * @param vatString vat
     * @return customer
     */
    public CustomerDTO findCustomer(String vatString) {
        VAT vat = VAT.valueOf(vatString);
        if (customerRepository.findByVat(vat).isPresent())
            return customerRepository.findByVat(vat).get().toDTO();
        return null;
    }
}
