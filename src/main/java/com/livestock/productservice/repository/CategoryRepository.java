package com.livestock.productservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.livestock.productservice.model.entity.CategoryEntity;

/**
 * Allows accessing persistent information about product categories.
 * 
 * @see CategoryEntity
 */
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
  
  /**
   * Finds all categories.
   * 
   * @return a {@code List} of all existing categories
   */
  List<CategoryEntity> findAll();
}
