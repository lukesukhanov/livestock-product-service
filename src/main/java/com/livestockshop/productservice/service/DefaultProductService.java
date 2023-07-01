package com.livestockshop.productservice.service;

import static com.livestockshop.productservice.repository.specification.ProductSpecification.byCategoryId;
import static com.livestockshop.productservice.repository.specification.ProductSpecification.withDescriptionIgnoreCaseLike;
import static com.livestockshop.productservice.repository.specification.ProductSpecification.withNameIgnoreCaseLike;
import static com.livestockshop.productservice.repository.specification.ProductSpecification.withPriceGreaterThanOrEqualTo;
import static com.livestockshop.productservice.repository.specification.ProductSpecification.withPriceLessThanOrEqualTo;

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
      String search,
      Long categoryId,
      Double minPrice,
      Double maxPrice) {

    Pageable pageable;
    if (page != null && size != null) {
      pageable = PageRequest.of(page, size, Sort.by(ProductEntity_.ID));
    } else {
      pageable = Pageable.unpaged();
    }
    Specification<ProductEntity> spec = Specification.where(null);
    if (search != null) {
      String pattern = "%" + search.toLowerCase() + "%";
      spec = spec.and(withNameIgnoreCaseLike(pattern).or(withDescriptionIgnoreCaseLike(pattern)));
    }
    if (categoryId != null) {
      spec = spec.and(byCategoryId(categoryId));
    }
    if (minPrice != null) {
      spec = spec.and(withPriceGreaterThanOrEqualTo(minPrice));
    }
    if (maxPrice != null) {
      spec = spec.and(withPriceLessThanOrEqualTo(maxPrice));
    }
    return this.productRepository.findAll(spec, pageable);
  }
}
