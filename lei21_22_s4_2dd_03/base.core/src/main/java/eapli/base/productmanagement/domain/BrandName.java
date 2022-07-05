package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Luís Araújo
 */
@Embeddable
public class BrandName implements ValueObject, Comparable<BrandName>, Serializable {
    /**
     * Product's brand name
     */
    private String brandName;

    /**
     * Empty constructor
     */
    public BrandName() {
    }

    /**
     * Constructor with the parameter brandName
     * @param brandName
     */
    public BrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * Method that returns the brandName
     * @return brandName
     */
    public String brandName() {
        return brandName;
    }

    @Override
    public String toString() {
        return brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrandName)) return false;
        BrandName brandName1 = (BrandName) o;
        return Objects.equals(brandName, brandName1.brandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandName);
    }

    @Override
    public int compareTo(BrandName o) {
        return 0;
    }
}
