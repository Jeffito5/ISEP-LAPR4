package eapli.base.productmanagement.mapper;

import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.mapper.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class ProductMapper {

    /**
     * Converts a Product to a ProductDTO with the internal code, category, shortest description, brand name and the toString
     *
     * @param product to be converted
     * @return new product dto
     */
    public ProductDTO toDTO(Product product) {
        return new ProductDTO(product.internalCode(), product.category(), product.shortDescription(), product.brandName(), product.toString());
    }

    /**
     * Converts a Product to a ProductDTO with the toString
     *
     * @param product to be converted
     * @return new product dto
     */
    public ProductDTO basicToDTO(Product product) {
        return new ProductDTO(product.internalCode(),product.basicToString());
    }

    /**
     * Converts a list of products to a list of products dto with only the toString
     *
     * @param products list of products
     * @return new product dto list
     */
    public List<ProductDTO> basicToDTO(List<Product> products) {
        List<ProductDTO> result = new ArrayList<>();

        for (Product product : products)
            result.add(basicToDTO(product));
        return result;
    }

    /**
     * Converts a list of products to a list of products dto with the internal code, category, shortest description, brand name and the toString
     *
     * @param products list of products
     * @return new product dto list
     */
    public List<ProductDTO> toDTO(List<Product> products) {
        List<ProductDTO> result = new ArrayList<>();

        for (Product product : products)
            result.add(toDTO(product));
        return result;
    }
}
