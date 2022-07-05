package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Luís Araújo
 */
@Embeddable
public class ProductionCode implements ValueObject, Comparable<ProductionCode>, Serializable {
    /**
     * Product's production code
     */
    private String productionCode;

    /**
     * Empty constructor
     */
    public ProductionCode() {
    }

    /**
     * Constructor with the parameter productionCode
     * @param productionCode
     */
    public ProductionCode(String productionCode) {
        this.productionCode = productionCode;
    }

    /**
     * Method that returns the productionCode
     * @return productionCode
     */
    public String productionCode() {
        return productionCode;
    }

    @Override
    public String toString() {
        return productionCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductionCode)) return false;
        ProductionCode that = (ProductionCode) o;
        return Objects.equals(productionCode, that.productionCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productionCode);
    }

    @Override
    public int compareTo(ProductionCode o) {
        return 0;
    }
}
