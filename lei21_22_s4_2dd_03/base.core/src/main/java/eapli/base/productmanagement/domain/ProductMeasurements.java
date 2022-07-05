package eapli.base.productmanagement.domain;

import com.sun.istack.NotNull;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Luís Araújo
 */
@Embeddable
public class ProductMeasurements implements ValueObject, Serializable {
    /**
     * ID of the aisle where the product will be stored
     */
    @NotNull
    private int aisleID;
    /**
     * ID of the row where the product will be stored
     */
    @NotNull
    private int rowID;
    /**
     * ID of the shelf where the product will be stored
     */
    @NotNull
    private int shelfID;
    /**
     * Product's width
     */
    @NotNull
    private double width;
    /**
     * Product's length
     */
    @NotNull
    private double length;
    /**
     * Product's height
     */
    @NotNull
    private double height;
    /**
     * Product's weight
     */
    @NotNull
    private double weight;

    /**
     * Empty constructor
     */
    protected ProductMeasurements() {
    }

    /**
     * Construct with all the parameters
     *
     * @param aisleID
     * @param rowID
     * @param shelfID
     * @param width
     * @param length
     * @param height
     * @param weight
     */
    public ProductMeasurements(int aisleID, int rowID, int shelfID, double width, double length, double height, double weight) {
        ruleAisleID(aisleID);
        ruleRowID(rowID);
        ruleShelfID(shelfID);
        ruleWidth(width);
        ruleLength(length);
        ruleHeight(height);
        ruleWeight(weight);
    }

    /**
     * Method that returns the ID of the aisle where the product will be stored
     *
     * @return the ID of the aisle where the product will be stored
     */
    public int aisleID() {
        return rowID;
    }

    /**
     * Method that verifies if the ID of the aisle is not less or equal to 0
     *
     * @param aisleID
     */
    public void ruleAisleID(int aisleID) {
        if (aisleID <= 0) {
            throw new IllegalArgumentException("Aisle ID cannot be less or equal to 0.");
        } else {
            this.aisleID = aisleID;
        }
    }

    /**
     * Method that returns the ID of the row where the product will be stored
     *
     * @return the ID of the row where the product will be stored
     */
    public int rowID() {
        return rowID;
    }

    /**
     * Method that verifies if the ID of the row is not less or equal to 0
     *
     * @param rowID
     */
    public void ruleRowID(int rowID) {
        if (rowID <= 0) {
            throw new IllegalArgumentException("Row ID cannot be less or equal to 0.");
        } else {
            this.rowID = rowID;
        }
    }

    /**
     * Method that returns the ID of the shelf where the product will be stored
     *
     * @return the ID of the shelf where the product will be stored
     */
    public int shelfID() {
        return shelfID;
    }

    /**
     * Method that verifies if the ID of the shelf is not less or equal to 0
     *
     * @param shelfID
     */
    public void ruleShelfID(int shelfID) {
        if (shelfID <= 0) {
            throw new IllegalArgumentException("Shelf ID cannot be less or equal to 0.");
        } else {
            this.shelfID = shelfID;
        }
    }

    /**
     * Method that returns the width of the product
     *
     * @return the width of the product
     */
    public double width() {
        return width;
    }

    /**
     * Method that verifies if the width of the product is not less or equal to 0
     *
     * @param width
     */
    public void ruleWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be less or equal to 0.");
        } else {
            this.width = width;
        }
    }

    /**
     * Method that returns the length of the product
     *
     * @return the length of the product
     */
    public double length() {
        return length;
    }

    /**
     * Method that verifies if the length of the product is not less or equal to 0
     *
     * @param length
     */
    public void ruleLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be less or equal to 0.");
        } else {
            this.length = length;
        }
    }

    /**
     * Method that returns the height of the product
     *
     * @return the height of the product
     */
    public double height() {
        return height;
    }

    /**
     * Method that verifies if the height of the product is not less or equal to 0
     *
     * @param height
     */
    public void ruleHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be less or equal to 0.");
        } else {
            this.height = height;
        }
    }

    /**
     * Method that returns the weight of the product
     *
     * @return the weight of the product
     */
    public double weight() {
        return weight;
    }

    /**
     * Method that verifies if the weight of the product is not less or equal to 0
     *
     * @param weight
     */
    public void ruleWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight cannot be less or equal to 0.");
        } else {
            this.weight = weight;
        }
    }

    @Override
    public String toString() {
        return String.format("|-------------------------------------------------------------------------Product Measurements---------------------------------------------------------------------------------|\n" +
                "|        Aisle ID                |   " + "%138d|\n" +
                "|        Row ID                  |   " + "%138d|\n" +
                "|        Shelf ID                |   " + "%138d|\n" +
                "|        Width                   |   " + "%138f|\n" +
                "|        Length                  |   " + "%138f|\n" +
                "|        Height                  |   " + "%138f|\n" +
                "|        Weight                  |   " + "%138f|\n",
                aisleID, rowID, shelfID, width, length, height, weight);
    }
}
