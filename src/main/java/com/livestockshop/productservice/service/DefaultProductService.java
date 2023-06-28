package com.livestockshop.productservice.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livestockshop.productservice.model.dto.ProductForRead;
import com.livestockshop.productservice.model.entity.ProductEntity;
import com.livestockshop.productservice.model.mapper.ProductMapper;
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

  private final ProductMapper productMapper;

  @Transactional(readOnly = true)
  @Override
  public List<ProductForRead> getFilteredAndPaged(String categoryName) {
    Specification<ProductEntity> spec = Specification.where(null);
    if (categoryName != null) {
      spec = spec.and(ProductSpecification.byCategoryName(categoryName));
    }
    List<ProductEntity> foundProducts = this.productRepository.findAll(spec);
    return this.productMapper.productEntityToProductForRead(foundProducts);
  }
}
