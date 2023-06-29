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
   * @param categoryName a {@code String} with the category name
   * @return a {@code List} of products found using paging and filtering
   */
  Page<ProductEntity> getWithPagingAndFiltering(
      Integer page,
      Integer size,
      Long categoryId,
      Double minPrice,
      Double maxPrice);
}
