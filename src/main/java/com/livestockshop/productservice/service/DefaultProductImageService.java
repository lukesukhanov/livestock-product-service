package com.livestockshop.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livestockshop.productservice.repository.ProductImageRepository;

import lombok.RequiredArgsConstructor;

/**
 * The default {@code ProductImageService} implementation.
 */
@Service
@RequiredArgsConstructor
public class DefaultProductImageService implements ProductImageService {

  private final ProductImageRepository productImageRepository;

  @Transactional(readOnly = true)
  @Override
  public List<Long> getIdsOfImagesByProductId(Long productId) {
    return this.productImageRepository.findIdsOfImagesByProductId(productId);
  }

}
