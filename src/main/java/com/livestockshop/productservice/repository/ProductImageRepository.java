package com.livestockshop.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.livestockshop.productservice.model.entity.ProductImageEntity;

/**
 * Allows accessing persistent information about product's images.
 * 
 * @see ProductImageEntity
 */
public interface ProductImageRepository extends CrudRepository<ProductImageEntity, Long> {

  /**
   * Finds ids of the images related to the required product.
   * 
   * @param productId a {@code Long} representing the product's id
   * @return a {@code List} containing ids of the images related to the required
   *         product
   */
  @Query(name = ProductImageEntity.JPQL_FIND_IDS_OF_IMAGES_BY_PRODUCT_ID)
  List<Long> findIdsOfImagesByProductId(Long productId);
}
