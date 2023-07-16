package com.livestock.productservice.service;

import static com.livestock.productservice.repository.specification.ProductSpecification.byCategoryId;
import static com.livestock.productservice.repository.specification.ProductSpecification.withDescriptionIgnoreCaseLike;
import static com.livestock.productservice.repository.specification.ProductSpecification.withNameIgnoreCaseLike;
import static com.livestock.productservice.repository.specification.ProductSpecification.withPriceGreaterThanOrEqualTo;
import static com.livestock.productservice.repository.specification.ProductSpecification.withPriceLessThanOrEqualTo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livestock.productservice.model.dto.ProductFilter;
import com.livestock.productservice.model.entity.ProductEntity;
import com.livestock.productservice.model.entity.ProductEntity_;
import com.livestock.productservice.repository.ProductRepository;

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
  public Page<ProductEntity> getWithPagingAndFiltering(ProductFilter productFilter) {
    Pageable pageable;
    if (productFilter.getPage() != null && productFilter.getSize() != null) {
      pageable = PageRequest.of(
          productFilter.getPage(),
          productFilter.getSize(),
          Sort.by(ProductEntity_.ID));
    } else {
      pageable = Pageable.unpaged();
    }
    Specification<ProductEntity> spec = Specification.where(null);
    if (productFilter.getSearch() != null) {
      String pattern = "%" + productFilter.getSearch().toLowerCase() + "%";
      spec = spec.and(withNameIgnoreCaseLike(pattern).or(withDescriptionIgnoreCaseLike(pattern)));
    }
    if (productFilter.getCategoryId() != null) {
      spec = spec.and(byCategoryId(productFilter.getCategoryId()));
    }
    if (productFilter.getMinPrice() != null) {
      spec = spec.and(withPriceGreaterThanOrEqualTo(productFilter.getMinPrice()));
    }
    if (productFilter.getMaxPrice() != null) {
      spec = spec.and(withPriceLessThanOrEqualTo(productFilter.getMaxPrice()));
    }
    return this.productRepository.findAll(spec, pageable);
  }
}
