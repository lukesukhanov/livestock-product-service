package com.livestockshop.productservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.livestockshop.productservice.LivestockShopProductServiceApplication;
import com.livestockshop.productservice.model.dto.ProductFilter;
import com.livestockshop.productservice.model.entity.ProductEntity;
import com.livestockshop.productservice.model.entity.ProductEntity_;
import com.livestockshop.productservice.repository.ProductRepository;

@SpringBootTest(classes = LivestockShopProductServiceApplication.class)
@DisplayName("DefaultProductService")
@Tag("service")
@Tag("product")
class DefaultProductServiceTest {

  @MockBean
  private ProductRepository productRepository;

  @Autowired
  private DefaultProductService productService;

  private final Page<ProductEntity> existingProductEntities;

  {
    List<ProductEntity> products = new ArrayList<>();
    ProductEntity product1 = new ProductEntity();
    product1.setId(1L);
    product1.setProductName("name1");
    product1.setDescription("decription1");
    product1.setQuantity(1);
    product1.setPrice(1.0);
    product1.setCurrency("RUB");
    product1.setCategory(null);
    Collections.addAll(products, product1);
    this.existingProductEntities = new PageImpl<ProductEntity>(products);
  }

  @Test
  @DisplayName("getWithPagingAndFiltering(...) - normal return")
  final void getWithPagingAndFiltering_normalReturn() throws Exception {
    Integer page = 0;
    Integer size = 10;
    Pageable pageable = PageRequest.of(page, size, Sort.by(ProductEntity_.ID));
    Specification<ProductEntity> spec = Specification.where(null);
    when(this.productRepository.findAll(spec, pageable))
        .thenReturn(this.existingProductEntities);
    Page<ProductEntity> result = this.productService
        .getWithPagingAndFiltering(new ProductFilter(page, size, null, null, null, null));
    assertEquals(result, this.existingProductEntities);
  }
}
