package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Embeddable
public class MaxWeight implements ValueObject, Serializable {

    private double maxWeight;

    protected MaxWeight() {
    }

    protected MaxWeight(double maxWeight) {
        ruleMaxWeight(maxWeight);
        this.maxWeight = maxWeight;
    }

    /**
     * new constructor
     *
     * @param maxWeight max weight
     * @return max weight
     */
    public static MaxWeight valueOf(double maxWeight) {
        return new MaxWeight(maxWeight);
    }

    /**
     * Returns the max weight
     *
     * @return max weigth
     */
    public double maxWeight() {
        return this.maxWeight;
    }

    /**
     * max weight rule
     *
     * @param maxWeight max weight
     */
    private void ruleMaxWeight(double maxWeight) {
        if (maxWeight <= 0)
            throw new IllegalArgumentException("Max weight invalid");
    }

    @Override
    public String toString() {
        return "MaxWeight{" +
                "maxWeight=" + maxWeight +
                '}';
    }
}
