package com.livestockshop.productservice.model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("ProductImageEntity")
@Tag("entity")
@Tag("productImage")
class ProductImageEntityTest {

  @Test
  @DisplayName("equals(Object) - the same object")
  final void equals_sameObject() throws Exception {
    ProductImageEntity productImage = new ProductImageEntity();
    productImage.setId(1L);
    assertEquals(productImage, productImage);
  }

  @Test
  @DisplayName("equals(Object) - the same id")
  final void equals_sameId() throws Exception {
    ProductImageEntity productImage1 = new ProductImageEntity();
    productImage1.setId(1L);
    productImage1.setProduct(new ProductEntity());
    ProductImageEntity productImage2 = new ProductImageEntity();
    productImage2.setId(1L);
    productImage2.setProduct(new ProductEntity());
    assertEquals(productImage1, productImage2);
  }

  @Test
  @DisplayName("equals(Object) - different id")
  final void equals_differentId() throws Exception {
    ProductImageEntity productImage1 = new ProductImageEntity();
    productImage1.setId(1L);
    ProductImageEntity productImage2 = new ProductImageEntity();
    productImage2.setId(2L);
    assertNotEquals(productImage1, productImage2);
  }

  @Test
  @DisplayName("equals(Object) - one of the ids is null")
  final void equals_oneOfIdsIsNull() throws Exception {
    ProductImageEntity productImage1 = new ProductImageEntity();
    productImage1.setId(1L);
    ProductImageEntity productImage2 = new ProductImageEntity();
    productImage2.setId(null);
    assertNotEquals(productImage1, productImage2);
  }

  @Test
  @DisplayName("equals(Object) - both ids are null")
  final void equals_bothIdsAreNull() throws Exception {
    ProductImageEntity productImage1 = new ProductImageEntity();
    productImage1.setId(null);
    ProductImageEntity productImage2 = new ProductImageEntity();
    productImage2.setId(null);
    assertNotEquals(productImage1, productImage2);
  }

  @Test
  @DisplayName("hashCode() - any other ProductImageEntity")
  final void hashCode_anyOtherProductImageEntity() throws Exception {
    ProductImageEntity productImage1 = new ProductImageEntity();
    productImage1.setId(1L);
    ProductImageEntity productImage2 = new ProductImageEntity();
    productImage2.setId(2L);
    assertEquals(productImage1.hashCode(), productImage2.hashCode());
  }
}
