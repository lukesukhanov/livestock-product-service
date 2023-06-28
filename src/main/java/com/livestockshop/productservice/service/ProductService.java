package com.livestockshop.productservice.service;

import java.util.List;

import com.livestockshop.productservice.model.dto.ProductForRead;
import com.livestockshop.productservice.model.entity.ProductEntity;

/**
 * The service for managing products.
 * 
 * @see ProductEntity
 */
public interface ProductService {

  /**
   * Finds products using filtering and paging.
   * 
   * @param categoryName a {@code String} with the category name
   * @return a {@code List} of products found using filtering and paging
   */
  List<ProductForRead> getFilteredAndPaged(String categoryName);
}
