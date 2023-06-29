package com.livestockshop.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.livestockshop.productservice.model.entity.CategoryEntity;

/**
 * Allows accessing persistent information about product categories.
 * 
 * @see CategoryEntity
 */
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

  /**
   * Finds all category names.
   * 
   * @return a {@code List} of category names
   */
  @Query(name = CategoryEntity.JPQL_FIND_ALL_CATEGORY_NAMES)
  List<String> findAllCategoryNames();
}
