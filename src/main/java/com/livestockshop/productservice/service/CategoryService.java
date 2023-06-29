package com.livestockshop.productservice.service;

import java.util.List;

import com.livestockshop.productservice.model.entity.CategoryEntity;

/**
 * The service for managing product categories.
 * 
 * @see CategoryEntity
 */
public interface CategoryService {

  /**
   * Finds all category names.
   * 
   * @return a {@code List} of category names
   */
  List<String> getAllCategoryNames();
}
