package eapli.base.categorymanagement.mapper.dto;

import eapli.base.categorymanagement.domain.Code;

/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class CategoryDTO {
    public Code code;
    public String toString;

    /**
     * Converts a Category to a CategoryDTO
     * @param code
     * @param toString
     */
    public CategoryDTO(Code code, String toString) {
        this.code = code;
        this.toString = toString;
    }
}