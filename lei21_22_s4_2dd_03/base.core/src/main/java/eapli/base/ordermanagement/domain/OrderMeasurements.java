package eapli.base.ordermanagement.domain;


import javax.persistence.Embeddable;

@Embeddable
public class OrderMeasurements {

    private double maxPrice;

    private double volume;

    private double maxWeight;

    protected OrderMeasurements() {
    }

    protected OrderMeasurements(double maxPrice, double volume, double maxWeight) {
        this.maxPrice = maxPrice;
        this.volume = volume;
        this.maxWeight = maxWeight;
    }

    /**
     * @param maxPrice  order's max price
     * @param volume    order's full volume
     * @param maxWeight order's max weight
     * @return the new Measurements
     */
    public static OrderMeasurements valueOf(double maxPrice, double volume, double maxWeight) {
        return new OrderMeasurements(maxPrice, volume, maxWeight);
    }

    /**
     * Returns the order's volume
     *
     * @return order's volume
     */
    public double volume() {
        return this.volume;
    }

    /**
     * Returns the order's max weight
     *
     * @return order's max weight
     */
    public double maxWeight() {
        return this.maxWeight;
    }

    @Override
    public String toString() {
        return "OrderMeasurements{" +
                "maxPrice=" + maxPrice +
                ", volume=" + volume +
                ", maxWeight=" + maxWeight +
                '}';
    }
}
