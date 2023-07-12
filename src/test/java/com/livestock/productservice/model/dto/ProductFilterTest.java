package com.livestock.productservice.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("ProductFilter")
@Tag("dto")
@Tag("product")
class ProductFilterTest {

  @Test
  @DisplayName("equals(Object) - the same object")
  final void equals_sameObject() throws Exception {
    ProductFilter productFilter = new ProductFilter(1, 1, "search", 1L, 1.0, 10.0);
    assertEquals(productFilter, productFilter);
  }

  @Test
  @DisplayName("equals(Object) - matching object")
  final void equals_matchingObject() throws Exception {
    ProductFilter productFilter1 = new ProductFilter(1, 1, "search", 1L, 1.0, 10.0);
    ProductFilter productFilter2 = new ProductFilter(1, 1, "search", 1L, 1.0, 10.0);
    assertEquals(productFilter1, productFilter2);
  }

  @Test
  @DisplayName("equals(Object) - different page")
  final void equals_differentPage() throws Exception {
    ProductFilter productFilter1 = new ProductFilter(1, 1, "search", 1L, 1.0, 10.0);
    ProductFilter productFilter2 = new ProductFilter(2, 1, "search", 1L, 1.0, 10.0);
    assertNotEquals(productFilter1, productFilter2);
  }

  @Test
  @DisplayName("equals(Object) - different size")
  final void equals_differentSize() throws Exception {
    ProductFilter productFilter1 = new ProductFilter(1, 1, "search", 1L, 1.0, 10.0);
    ProductFilter productFilter2 = new ProductFilter(1, 2, "search", 1L, 1.0, 10.0);
    assertNotEquals(productFilter1, productFilter2);
  }

  @Test
  @DisplayName("equals(Object) - different search")
  final void equals_differentSearch() throws Exception {
    ProductFilter productFilter1 = new ProductFilter(1, 1, "search1", 1L, 1.0, 10.0);
    ProductFilter productFilter2 = new ProductFilter(1, 1, "search2", 1L, 1.0, 10.0);
    assertNotEquals(productFilter1, productFilter2);
  }

  @Test
  @DisplayName("equals(Object) - different categoryId")
  final void equals_differentCategoryId() throws Exception {
    ProductFilter productFilter1 = new ProductFilter(1, 1, "search", 1L, 1.0, 10.0);
    ProductFilter productFilter2 = new ProductFilter(1, 1, "search", 2L, 1.0, 10.0);
    assertNotEquals(productFilter1, productFilter2);
  }

  @Test
  @DisplayName("equals(Object) - different minPrice")
  final void equals_differentMinPrice() throws Exception {
    ProductFilter productFilter1 = new ProductFilter(1, 1, "search", 1L, 1.0, 10.0);
    ProductFilter productFilter2 = new ProductFilter(1, 1, "search", 1L, 2.0, 10.0);
    assertNotEquals(productFilter1, productFilter2);
  }

  @Test
  @DisplayName("equals(Object) - different maxPrice")
  final void equals_differentMaxPrice() throws Exception {
    ProductFilter productFilter1 = new ProductFilter(1, 1, "search", 1L, 1.0, 10.0);
    ProductFilter productFilter2 = new ProductFilter(1, 1, "search", 1L, 1.0, 20.0);
    assertNotEquals(productFilter1, productFilter2);
  }

  @Test
  @DisplayName("hashCode(Object) - matching object")
  final void hashCode_matchingObject() throws Exception {
    ProductFilter productFilter1 = new ProductFilter(1, 1, "search", 1L, 1.0, 10.0);
    ProductFilter productFilter2 = new ProductFilter(1, 1, "search", 1L, 1.0, 10.0);
    assertEquals(productFilter1.hashCode(), productFilter2.hashCode());
  }
}
