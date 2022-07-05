package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.CatalogId;
import eapli.base.catalogmanagement.mapper.CatalogMapper;
import eapli.base.catalogmanagement.mapper.dto.CatalogDTO;
import eapli.base.categorymanagement.domain.Code;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.productmanagement.domain.BrandName;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.ShortDescription;
import eapli.base.productmanagement.mapper.ProductMapper;
import eapli.base.productmanagement.mapper.dto.ProductDTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author Luís Araújo
 */
public class ViewCatalogController {
    private ProductMapper productMapper;
    private CatalogMapper catalogMapper;

    /**
     * Constructor with variables
     */
    public ViewCatalogController() {
        productMapper = new ProductMapper();
        catalogMapper = new CatalogMapper();
    }

    /**
     * Method that returns a catalog searched by its id
     *
     * @param id
     * @return catalog searched by its id
     */
    public CatalogDTO viewCatalogByItsCode(Long id) {
        CatalogId catalogId = new CatalogId(id);
        JpaRepository<Catalog, Serializable> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        return this.catalogMapper.toDTO(repo.findById(catalogId));
    }

    /**
     * Method that returns a product in a certain catalog searched by its code
     *
     * @param code
     * @param id
     * @return product in a certain catalog searched by its code
     */
    public ProductDTO viewProductOfTheCatalogByCode(String code, Long id) {
        CatalogDTO catalogDTO = viewCatalogByItsCode(id);
        for (ProductDTO p : listOfProducts(catalogDTO)) {
            if (p.code.equals(new InternalCode(code))) {
                return p;
            }
        }
        return null;
    }

    /**
     * Method that returns a product in a certain catalog searched by its category
     *
     * @param category
     * @param id
     * @return product in a certain catalog searched by its category
     */
    public ProductDTO viewProductOfTheCatalogByCategory(String category, Long id) {
        CatalogDTO catalogDTO = viewCatalogByItsCode(id);
        for (ProductDTO p : listOfProducts(catalogDTO)) {
            if (p.category.code().equals(new Code(category))) {
                return p;
            }
        }
        return null;
    }

    /**
     * Method that returns a product in a certain catalog searched by its description
     *
     * @param description
     * @param id
     * @return product in a certain catalog searched by its description
     */
    public ProductDTO viewProductOfTheCatalogByDescription(String description, Long id) {
        CatalogDTO catalogDTO = viewCatalogByItsCode(id);
        for (ProductDTO p : listOfProducts(catalogDTO)) {
            if (p.shortDescription.equals(new ShortDescription(description))) {
                return p;
            }
        }
        return null;
    }

    /**
     * Method that returns a product in a certain catalog searched by its brand
     *
     * @param brand
     * @param id
     * @return product in a certain catalog searched by its brand
     */
    public ProductDTO viewProductOfTheCatalogByBrand(String brand, Long id) {
        CatalogDTO catalogDTO = viewCatalogByItsCode(id);
        for (ProductDTO p : listOfProducts(catalogDTO)) {
            if (p.brandName.equals(new BrandName(brand))) {
                return p;
            }
        }
        return null;
    }

    public List<ProductDTO> listOfProducts(CatalogDTO catalogDTO) {
        JpaRepository<Catalog, Serializable> repo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        Catalog catalog = repo.findById(catalogDTO.id);
        return productMapper.toDTO(catalog.listOfProducts());
    }
}
