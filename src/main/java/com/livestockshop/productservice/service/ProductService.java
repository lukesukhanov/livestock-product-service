package com.livestockshop.productservice.service;

import org.springframework.data.domain.Page;

import com.livestockshop.productservice.model.entity.ProductEntity;

/**
 * The service for managing products.
 * 
 * @see ProductEntity
 */
public interface ProductService {

  /**
   * Finds products using paging and filtering.
   * 
   * @param page a {@code Integer} representing page ordinal
   * @param size a {@code Integer} representing page size
   * @param search a {@code String} with search pattern
   * @param categoryId a {@code Long} representing id of the product category
   * @param size a {@code Double} representing minimal product price
   * @param size a {@code Double} representing maximal product price
   * @return a {@code List} of products found using paging and filtering
   */
  Page<ProductEntity> getWithPagingAndFiltering(
      Integer page,
      Integer size,
      String search,
      Long categoryId,
      Double minPrice,
      Double maxPrice);
}
