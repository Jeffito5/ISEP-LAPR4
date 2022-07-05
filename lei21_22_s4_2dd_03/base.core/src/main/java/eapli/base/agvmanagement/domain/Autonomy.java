package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;


/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Embeddable
public class Autonomy implements ValueObject, Serializable {

    private int autonomy;

    protected Autonomy(){}

    protected Autonomy(int autonomy){
        ruleAutonomy(autonomy);
        this.autonomy=autonomy;
    }

    /**
     * new constructor
     * @param autonomy autonomy
     * @return autonomy
     */
    public static Autonomy valueOf(int autonomy){
        return new Autonomy(autonomy);
    }

    /**
     * autonomy rule
     * @param autonomy autonomy
     */
    private void ruleAutonomy(int autonomy) {
        if (autonomy <= 0)
            throw new IllegalArgumentException("Autonomy invalid");
    }

    public int autonomy(){
        return autonomy;
    }

    @Override
    public String toString() {
        return "Autonomy{" +
                "autonomy=" + autonomy +
                '}';
    }
}
