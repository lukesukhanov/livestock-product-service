package com.livestockshop.productservice.model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("CategoryEntity")
@Tag("entity")
@Tag("category")
class CategoryEntityTest {

  @Test
  @DisplayName("equals(Object) - the same object")
  final void equals_sameObject() throws Exception {
    CategoryEntity category = new CategoryEntity();
    category.setId(1L);
    category.setCategoryName("name");
    assertEquals(category, category);
  }

  @Test
  @DisplayName("equals(Object) - the same id")
  final void equals_sameId() throws Exception {
    CategoryEntity category1 = new CategoryEntity();
    category1.setId(1L);
    category1.setCategoryName("name1");
    CategoryEntity category2 = new CategoryEntity();
    category2.setId(1L);
    category2.setCategoryName("name2");
    assertEquals(category1, category2);
  }

  @Test
  @DisplayName("equals(Object) - different id")
  final void equals_differentId() throws Exception {
    CategoryEntity category1 = new CategoryEntity();
    category1.setId(1L);
    category1.setCategoryName("name");
    CategoryEntity category2 = new CategoryEntity();
    category2.setId(2L);
    category2.setCategoryName("name");
    assertNotEquals(category1, category2);
  }

  @Test
  @DisplayName("equals(Object) - one of the ids is null")
  final void equals_oneOfIdsIsNull() throws Exception {
    CategoryEntity category1 = new CategoryEntity();
    category1.setId(1L);
    category1.setCategoryName("name");
    CategoryEntity category2 = new CategoryEntity();
    category2.setId(null);
    category2.setCategoryName("name");
    assertNotEquals(category1, category2);
  }

  @Test
  @DisplayName("equals(Object) - both ids are null")
  final void equals_bothIdsAreNull() throws Exception {
    CategoryEntity category1 = new CategoryEntity();
    category1.setId(null);
    category1.setCategoryName("name");
    CategoryEntity category2 = new CategoryEntity();
    category2.setId(null);
    category2.setCategoryName("name");
    assertNotEquals(category1, category2);
  }

  @Test
  @DisplayName("hashCode() - any other CategoryEntity")
  final void hashCode_anyOtherCategoryEntity() throws Exception {
    CategoryEntity category1 = new CategoryEntity();
    category1.setId(1L);
    category1.setCategoryName("name1");
    CategoryEntity category2 = new CategoryEntity();
    category2.setId(2L);
    category2.setCategoryName("name2");
    assertEquals(category1.hashCode(), category2.hashCode());
  }

}
