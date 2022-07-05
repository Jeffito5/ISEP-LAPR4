package eapli.base.ordermanagement.domain;

import eapli.base.customermanagement.domain.Customer;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * @author 1201217 Marco Ramos
 */
@Embeddable
public class Stakeholders implements ValueObject, Serializable {

    @OneToOne
    private Customer customer;

    @OneToOne
    private SystemUser systemUser;

    private String conversation;

    protected Stakeholders() {
    }


    protected Stakeholders(Customer customer, SystemUser systemUser, String conversation) {
        this.customer = customer;
        this.systemUser = systemUser;
        this.conversation = conversation;
    }

    /**
     * create the new order's stakeholders
     *
     * @param customer     order's customer
     * @param systemUser   order's system user
     * @param conversation order's conversation
     * @return the new order's stakeholders
     */
    public static Stakeholders valueOf(Customer customer, SystemUser systemUser, String conversation) {
        return new Stakeholders(customer, systemUser, conversation);
    }

    public Customer customer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Stakeholders{" +
                "customer=" + customer +
                ", systemUser=" + systemUser +
                ", conversation='" + conversation + '\'' +
                '}';
    }
}
