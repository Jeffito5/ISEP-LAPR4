package eapli.base.categorymanagement.mapper;

import eapli.base.categorymanagement.mapper.dto.CategoryDTO;
import eapli.base.categorymanagement.domain.Category;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 */

public class CategoryMapper {

    /**
     * Converts a Category to a CategoryDTO
     *
     * @param category to be converted
     * @return new category dto
     */
    public CategoryDTO toDTO(Category category){
        return new CategoryDTO(category.code(),category.toString());
    }

    /**
     * Converts a list of categories to a list of categories dto
     *
     * @param categories list of categories
     * @return new category dto list
     */
    public List<CategoryDTO> toDTO(List<Category> categories){
        List<CategoryDTO> result = new ArrayList<>();
        for (Category category : categories)
            result.add(toDTO(category));
        return result;
    }
}
