package com.livestockshop.productservice.service;

import org.springframework.data.domain.Page;

import com.livestockshop.productservice.model.dto.ProductFilter;
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
   * @param productFilter a {@code ProductFilter} with product filters
   * @return a {@code List} of products found using paging and filtering
   */
  Page<ProductEntity> getWithPagingAndFiltering(ProductFilter productFilter);
}
