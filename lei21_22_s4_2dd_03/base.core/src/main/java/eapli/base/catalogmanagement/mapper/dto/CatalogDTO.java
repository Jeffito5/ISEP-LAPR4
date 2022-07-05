package eapli.base.catalogmanagement.mapper.dto;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.CatalogId;
import eapli.base.productmanagement.domain.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luís Araújo
 */
public class CatalogDTO {
    public CatalogId id;
    public List<Product> productList = new ArrayList<>();
    public String toString;

    /**
     * Converts a Catalog to a CatalogDTO
     * @param id
     * @param productList
     * @param toString
     */
    public CatalogDTO(CatalogId id, List<Product> productList, String toString) {
        this.id = id;
        this.productList = productList;
        this.toString = toString;
    }

    @Override
    public String toString() {
        return toString;
    }
}
