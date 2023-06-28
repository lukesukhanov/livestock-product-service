package com.livestockshop.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.livestockshop.productservice.model.entity.ProductEntity;

/**
 * Allows to access persistent information about products.
 * 
 * @see ProductEntity
 */
public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Long>,
    JpaSpecificationExecutor<ProductEntity> {

  /**
   * Finds products using filtering and paging.
   * <p>
   * The products are fetched with category names and ids of their images.
   * 
   * @param spec a {@code Specification} for filtering products
   * @return a {@code List} of products after filtering and paging
   */
  @EntityGraph(ProductEntity.ENTITY_GRAPH_WITH_CATEGORY_AND_IDS_OF_IMAGES)
  @Override
  List<ProductEntity> findAll(Specification<ProductEntity> spec);
}
