package com.livestock.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livestock.productservice.exception.ProductImageNotFoundException;
import com.livestock.productservice.repository.ProductImageRepository;

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

  @Transactional(readOnly = true)
  @Override
  public byte[] getImageById(Long id) {
    return this.productImageRepository.findImageById(id)
        .orElseThrow(() -> new ProductImageNotFoundException(id));
  }
}
