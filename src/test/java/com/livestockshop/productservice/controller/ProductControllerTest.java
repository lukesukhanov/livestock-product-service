package com.livestockshop.productservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.livestockshop.productservice.LivestockShopProductServiceApplication;
import com.livestockshop.productservice.model.entity.CategoryEntity;
import com.livestockshop.productservice.model.entity.ProductEntity;
import com.livestockshop.productservice.model.entity.ProductEntity_;
import com.livestockshop.productservice.service.ProductService;

@SpringBootTest(classes = LivestockShopProductServiceApplication.class)
@DisplayName("ProductController")
@Tag("controller")
@Tag("product")
@AutoConfigureMockMvc
class ProductControllerTest {

  @MockBean
  private ProductService productService;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  private final List<ProductEntity> existingProducts;

  {
    List<ProductEntity> products = new ArrayList<>();
    ProductEntity product1 = new ProductEntity();
    product1.setId(1L);
    product1.setProductName("name1");
    product1.setDescription("decription1");
    product1.setQuantity(1);
    product1.setPrice(1.0);
    product1.setCurrency("RUB");
    product1.setCategory(new CategoryEntity());
    Collections.addAll(products, product1);
    this.existingProducts = Collections.unmodifiableList(products);
  }

  @Test
  @DisplayName("getWithPagingAndFiltering(...) - normal return")
  final void getWithPagingAndFiltering_normalReturn() throws Exception {
    Integer page = 0;
    Integer size = 10;
    Long categoryId = 1L;
    Double minPrice = 0d;
    Double maxPrice = 10000d;
    Pageable pageable = PageRequest.of(page, size, Sort.by(ProductEntity_.ID));
    Page<ProductEntity> products = new PageImpl<>(this.existingProducts, pageable,
        this.existingProducts.size());
    Map<String, Object> responseBody = Map.of(
        "content", products.getContent(),
        "numberOfElements", products.getNumberOfElements(),
        "first", products.isFirst(),
        "last", products.isLast(),
        "totalElements", products.getTotalElements(),
        "totalPages", products.getTotalPages());
    when(this.productService.getWithPagingAndFiltering(page, size, categoryId, minPrice, maxPrice))
        .thenReturn(products);
    this.mockMvc.perform(get("/products")
        .accept(MediaType.APPLICATION_JSON)
        .param("page", page.toString())
        .param("size", size.toString())
        .param("category", categoryId.toString())
        .param("minPrice", minPrice.toString())
        .param("maxPrice", maxPrice.toString()))
        .andExpectAll(
            status().isOk(),
            content().contentType(MediaType.APPLICATION_JSON),
            content().bytes(this.objectMapper.writeValueAsBytes(responseBody)));
  }
}
