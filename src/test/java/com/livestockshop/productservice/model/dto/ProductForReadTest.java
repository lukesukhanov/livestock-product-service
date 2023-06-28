package com.livestockshop.productservice.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("ProductForRead")
@Tag("dto")
@Tag("product")
class ProductForReadTest {

  @Test
  @DisplayName("equals(Object) - the same object")
  final void equals_sameObject() throws Exception {
    ProductForRead product = new ProductForRead(
        1L, "name", "description", 1, 1.0, "RUB", "Овцы", new HashSet<>());
    assertEquals(product, product);
  }

  @Test
  @DisplayName("equals(Object) - the same id")
  final void equals_sameId() throws Exception {
    ProductForRead product1 = new ProductForRead(
        1L, "name1", "description1", 1, 1.0, "RUB", "Овцы", new HashSet<>());
    ProductForRead product2 = new ProductForRead(
        1L, "name2", "description2", 2, 2.0, "USD", "Коровы", new HashSet<>());
    assertEquals(product1, product2);
  }

  @Test
  @DisplayName("equals(Object) - different id")
  final void equals_differentId() throws Exception {
    ProductForRead product1 = new ProductForRead(
        1L, "name", "description", 1, 1.0, "RUB", "Овцы", new HashSet<>());
    ProductForRead product2 = new ProductForRead(
        2L, "name", "description", 1, 1.0, "RUB", "Овцы", new HashSet<>());
    assertNotEquals(product1, product2);
  }

  @Test
  @DisplayName("equals(Object) - one of the ids is null")
  final void equals_oneOfIdsIsNull() throws Exception {
    ProductForRead product1 = new ProductForRead(
        1L, "name", "description", 1, 1.0, "RUB", "Овцы", new HashSet<>());
    ProductForRead product2 = new ProductForRead(
        null, "name", "description", 1, 1.0, "RUB", "Овцы", new HashSet<>());
    assertNotEquals(product1, product2);
  }

  @Test
  @DisplayName("equals(Object) - both ids are null")
  final void equals_bothIdsAreNull() throws Exception {
    ProductForRead product1 = new ProductForRead(
        null, "name", "description", 1, 1.0, "RUB", "Овцы", new HashSet<>());
    ProductForRead product2 = new ProductForRead(
        null, "name", "description", 1, 1.0, "RUB", "Овцы", new HashSet<>());
    assertNotEquals(product1, product2);
  }

  @Test
  @DisplayName("hashCode() - any other ProductEntity")
  final void hashCode_anyOtherPlayerEntity() throws Exception {
    ProductForRead product1 = new ProductForRead(
        1L, "name1", "description1", 1, 1.0, "RUB", "Овцы", new HashSet<>());
    ProductForRead product2 = new ProductForRead(
        2L, "name2", "description2", 2, 2.0, "USD", "Коровы", new HashSet<>());
    assertEquals(product1.hashCode(), product2.hashCode());
  }

}
