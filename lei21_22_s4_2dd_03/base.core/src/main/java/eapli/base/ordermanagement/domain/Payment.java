package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

/**
 * @author 1201217 Marco Ramos
 */
@Embeddable
public class Payment implements ValueObject, Serializable {

    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod paymentMethod;

    private String paymentConfirmation;

    protected Payment() {
    }

    protected Payment(PaymentMethod paymentMethod, String paymentConfirmation) {
        confirmationRules(paymentConfirmation);
        this.paymentMethod = paymentMethod;
        this.paymentConfirmation = paymentConfirmation;
    }

    /**
     *
     * @param paymentMethod payment method
     * @param paymentConfirmation payment confirmation
     * @return new Payment
     */
    public static Payment valueOf(PaymentMethod paymentMethod, String paymentConfirmation) {
        return new Payment(paymentMethod, paymentConfirmation);
    }

    /**
     * rules for the payment confirmation
     * @param paymentConfirmation payment confirmation
     */
    private void confirmationRules(String paymentConfirmation) {
        if (paymentConfirmation.length() > 512) {
            throw new IllegalArgumentException("Payment confirmation must be less than 512 chars");
        }
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentMethod=" + paymentMethod +
                ", paymentConfirmation='" + paymentConfirmation + '\'' +
                '}';
    }
}
