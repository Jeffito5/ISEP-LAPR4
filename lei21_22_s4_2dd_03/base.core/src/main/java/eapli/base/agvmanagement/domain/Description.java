package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;


/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Embeddable
public class Description implements ValueObject, Serializable {

    private String description;

    protected Description(){}

    protected Description(String description){
        ruleDescription(description);
        this.description=description;
    }

    /**
     * new constructor
     * @param description description
     * @return description
     */
    public static Description valueOf(String description){
        return new Description(description);
    }

    /**
     * description rules
     * @param description description
     */
    private void ruleDescription(String description){
        if(description.isBlank())
            throw new IllegalArgumentException("Invalid description.");
        if (description.length() > 30)
            throw new IllegalArgumentException("Invalid description lenght.");
    }

    @Override
    public String toString() {
        return "Description{" +
                "description='" + description + '\'' +
                '}';
    }
}
