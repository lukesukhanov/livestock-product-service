package com.livestockshop.productservice.service;

import java.util.List;

/**
 * The service for managing product's images.
 */
public interface ProductImageService {

  /**
   * Finds ids of the images related to the required product.
   * 
   * @param productId a {@code Long} representing the product's id
   * @return a {@code List} containing ids of the images related to the required
   *         product
   */
  List<Long> getIdsOfImagesByProductId(Long productId);
}
