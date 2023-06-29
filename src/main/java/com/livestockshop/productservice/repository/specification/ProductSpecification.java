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
   * Filters products by category id.
   * 
   * @param categoryId a {@code Long} representing the category id
   * @return a {@code Specification} filtering products by category id
   */
  public static Specification<ProductEntity> byCategoryId(Long categoryId) {
    return (root, query, builder) -> builder
        .equal(root.get(ProductEntity_.category).get(CategoryEntity_.id), categoryId);
  }

  /**
   * Filters products with price greater than or equal to the given value.
   * 
   * @param minPrice a {@code Double} with the minimal price value
   * @return a {@code Specification} filtering products with the price greater
   *         than or equal to the given value
   */
  public static Specification<ProductEntity> withPriceGreaterThanOrEqualTo(Double minPrice) {
    return (root, query, builder) -> builder
        .greaterThanOrEqualTo(root.get(ProductEntity_.price), minPrice);
  }

  /**
   * Filters products with price less than or equal to the given value.
   * 
   * @param maxPrice a {@code Double} with the maximal price value
   * @return a {@code Specification} filtering products with the price less than
   *         or equal to the given value
   */
  public static Specification<ProductEntity> withPriceLessThanOrEqualTo(Double maxPrice) {
    return (root, query, builder) -> builder
        .lessThanOrEqualTo(root.get(ProductEntity_.price), maxPrice);
  }
}
