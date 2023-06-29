package com.livestockshop.productservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.livestockshop.productservice.model.entity.ProductEntity;

/**
 * Allows accessing persistent information about products.
 * 
 * @see ProductEntity
 */
public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Long>,
    JpaSpecificationExecutor<ProductEntity> {

  /**
   * Finds products using paging and filtering.
   * <p>
   * The products are fetched with category names and ids of their images.
   * 
   * @param spec a {@code Specification} for filtering products
   * @return a {@code List} of products after paging and filtering
   */
  @EntityGraph(ProductEntity.ENTITY_GRAPH_WITH_CATEGORY)
  @Override
  Page<ProductEntity> findAll(Specification<ProductEntity> spec, Pageable pageable);
}
