package eapli.base.categorymanagement.domain;

import eapli.base.categorymanagement.builder.CategoryBuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;


public class CategoryTest {

    Category category = new CategoryBuilder().withCode("code6").withDescription("category's description").build();
    Category category2 = new CategoryBuilder().withCode("code7").withDescription("category's description").build();
    Category category3 = new CategoryBuilder().withCode("code7").withDescription("category's description2").build();


    @Test
    public void equalCategoriesTest() {
        Assertions.assertTrue(category.sameAs(category));
        Assertions.assertTrue(category.sameAs(new CategoryBuilder().withCode("code6").withDescription("category's description").build()));
        Assertions.assertTrue(category2.sameAs(category3));
    }

    @Test
    public void differentCategoriesTest() {
        Assertions.assertFalse(category.sameAs(category2));
        Assertions.assertTrue(category.sameAs(new CategoryBuilder().withCode("code6").withDescription("category's description2").build()));
    }
}
