package eapli.base.catalogmanagement.mapper;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.mapper.dto.CatalogDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luís Araújo
 *
 */public class CatalogMapper {
    /**
     * Converts a Catalog to a CatalogDTO
     *
     * @param catalog to be converted
     * @return new catalog dto
     */
    public CatalogDTO toDTO(Catalog catalog) {
        return new CatalogDTO(catalog.id(), catalog.listOfProducts(), catalog.toString());
    }

    /**
     * Converts a list of catalogs to a list of catalogs dto
     *
     * @param catalogList list of catalogs
     * @return new catalog dto list
     */
    public List<CatalogDTO> toDTO(List<Catalog> catalogList) {
        List<CatalogDTO> dtoList = new ArrayList<>();
        for (Catalog catalog : catalogList) {
            dtoList.add(toDTO(catalog));
        }
        return dtoList;
    }
}
