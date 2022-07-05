package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;


/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Embeddable
public class Model implements ValueObject, Serializable {

    private String model;

    protected Model(){}

    protected Model(String model){
        ruleModel(model);
        this.model=model;
    }

    /**
     * new constructor
     * @param model model
     * @return model
     */
    public static Model valueOf(String model){
        return new Model(model);
    }

    /**
     * model rules
     * @param model model
     */
    private void ruleModel(String model){
        if(model.isBlank())
            throw new IllegalArgumentException("Invalid model.");
        if (model.length() > 50)
            throw new IllegalArgumentException("Invalid model lenght.");
    }

    @Override
    public String toString() {
        return "Model{" +
                "model='" + model + '\'' +
                '}';
    }
}
