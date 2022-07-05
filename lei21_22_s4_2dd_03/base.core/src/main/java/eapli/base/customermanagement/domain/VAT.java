package eapli.base.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;


/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Embeddable
public class VAT implements ValueObject, Serializable {

    private String vat;

    protected VAT(){}

    protected VAT(String vat) {
        ruleVAT(vat);
        this.vat=vat;
    }

    /**
     * new constructor
     * @param vat vat
     * @return vat
     */
    public static VAT valueOf(String vat){
        return new VAT(vat);
    }

    /**
     * rule vat
     * @param vat vat
     */
    private void ruleVAT(String vat) {
        if (vat.isBlank())
            throw new IllegalArgumentException("Invalid VAT.");
        if (vat.length() < 8) {
            throw new IllegalArgumentException("Invalid VAT.");
        }
    }

    @Override
    public String toString() {
        return "VAT{" +
                "vat='" + vat + '\'' +
                '}';
    }

}
