package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;


/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Embeddable
public class Identifier implements ValueObject, Serializable {

    private String identifier;

    protected Identifier(){}

    protected Identifier(String identifier){
        ruleIdentifier(identifier);
        this.identifier=identifier;
    }

    /**
     * new constructor
     * @param identifier identifier
     * @return identifier
     */
    public static Identifier valueOf(String identifier){
        return new Identifier(identifier);
    }

    /**
     * identifier rules
     * @param identifier identifier
     */
    private void ruleIdentifier(String identifier) {
        if (identifier.isBlank())
            throw new IllegalArgumentException("Invalid identifier.");
        if (identifier.length() > 8)
            throw new IllegalArgumentException("Invalid identifier lenght.");
        for (int i = 0; i < identifier.length(); i++) {
            if (!Character.isLetterOrDigit(identifier.charAt(i)))
                throw new IllegalArgumentException("Identifier must be Alphanumeric.");
        }
    }

    @Override
    public String toString() {
        return "Identifier{" +
                "identifier='" + identifier + '\'' +
                '}';
    }

    public String identifier(){
        return this.identifier;
    }
}
