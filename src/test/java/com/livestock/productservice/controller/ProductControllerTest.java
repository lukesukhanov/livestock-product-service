package com.livestock.productservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.livestock.productservice.Application;
import com.livestock.productservice.model.dto.ProductFilter;
import com.livestock.productservice.model.entity.CategoryEntity;
import com.livestock.productservice.model.entity.ProductEntity;
import com.livestock.productservice.model.entity.ProductEntity_;
import com.livestock.productservice.service.ProductService;

@SpringBootTest(classes = Application.class)
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
    ProductEntity product1 = new ProductEntity();
    product1.setId(1L);
    product1.setProductName("name1");
    product1.setDescription("decription1");
    product1.setQuantity(1);
    product1.setPrice(1.0);
    product1.setCurrency("RUB");
    product1.setCategory(new CategoryEntity());
    this.existingProducts = List.of(product1);
  }

  @Test
  @DisplayName("getWithPagingAndFiltering(...) - normal return")
  final void getWithPagingAndFiltering_normalReturn() throws Exception {
    Integer page = 0;
    Integer size = 10;
    String search = "search";
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
    when(this.productService.getWithPagingAndFiltering(
        new ProductFilter(page, size, search, categoryId, minPrice, maxPrice)))
        .thenReturn(products);
    this.mockMvc.perform(get("/products")
        .accept(MediaType.APPLICATION_JSON)
        .param("page", page.toString())
        .param("size", size.toString())
        .param("search", search)
        .param("categoryId", categoryId.toString())
        .param("minPrice", minPrice.toString())
        .param("maxPrice", maxPrice.toString()))
        .andExpectAll(
            status().isOk(),
            content().contentType(MediaType.APPLICATION_JSON),
            content().bytes(this.objectMapper.writeValueAsBytes(responseBody)));
  }
}
