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
   * Finds all categories.
   * 
   * @return a {@code List} of all existing categories
   */
  List<CategoryEntity> getAll();
}
