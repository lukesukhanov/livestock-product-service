package com.livestockshop.productservice.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import com.livestockshop.productservice.model.entity.CategoryEntity_;
import com.livestockshop.productservice.model.entity.ProductEntity;
import com.livestockshop.productservice.model.entity.ProductEntity_;
import com.livestockshop.productservice.repository.ProductRepository;

/**
 * Product specifications.
 * 
 * @see ProductRepository
 * @see ProductEntity
 */
public class ProductSpecification {

  /**
   * Filters products by category name.
   * 
   * @param categoryName a {@code String} with the category name
   * @return a {@code Specification} filtering products by category name.
   */
  public static Specification<ProductEntity> byCategoryName(String categoryName) {
    return (root, query, builder) -> builder
        .equal(root.get(ProductEntity_.category).get(CategoryEntity_.categoryName), categoryName);
  }
}
