package com.livestockshop.productservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livestockshop.productservice.model.entity.ProductEntity;
import com.livestockshop.productservice.model.entity.ProductEntity_;
import com.livestockshop.productservice.repository.ProductRepository;
import com.livestockshop.productservice.repository.specification.ProductSpecification;

import lombok.RequiredArgsConstructor;

/**
 * The default {@code ProductService} implementation.
 */
@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

  private final ProductRepository productRepository;

  @Transactional(readOnly = true)
  @Override
  public Page<ProductEntity> getWithPagingAndFiltering(
      Integer page,
      Integer size,
      String categoryName,
      Double minPrice,
      Double maxPrice) {

    Pageable pageable;
    if (page != null && size != null) {
      pageable = PageRequest.of(page, size, Sort.by(ProductEntity_.ID));
    } else {
      pageable = Pageable.unpaged();
    }
    Specification<ProductEntity> spec = Specification.where(null);
    if (categoryName != null) {
      spec = spec.and(ProductSpecification.byCategoryName(categoryName));
    }
    if (minPrice != null) {
      spec = spec.and(ProductSpecification.withPriceGreaterThanOrEqualTo(minPrice));
    }
    if (maxPrice != null) {
      spec = spec.and(ProductSpecification.withPriceLessThanOrEqualTo(maxPrice));
    }
    return this.productRepository.findAll(spec, pageable);
  }
}
