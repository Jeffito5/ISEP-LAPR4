package eapli.base.productmanagement.mapper.dto;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.domain.BrandName;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.ShortDescription;

/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class ProductDTO {
    public InternalCode code;
    public Category category;
    public ShortDescription shortDescription;
    public BrandName brandName;
    public String toString;

    /**
     * Converts a Product to a ProductDTO with the internal code, category, shortest description, brand name and the toString
     * @param code
     * @param category
     * @param shortDescription
     * @param brandName
     * @param toString
     */
    public ProductDTO(InternalCode code, Category category, ShortDescription shortDescription, BrandName brandName, String toString) {
        this.code = code;
        this.category = category;
        this.shortDescription = shortDescription;
        this.brandName = brandName;
        this.toString = toString;
    }

    /**
     * Converts a Product to a ProductDTO with the toString
     * @param toString
     */
    public ProductDTO(InternalCode internalCode,String toString) {
        this.toString = toString;
        this.code=internalCode;
    }

    @Override
    public String toString(){
        return toString;
    }
}

