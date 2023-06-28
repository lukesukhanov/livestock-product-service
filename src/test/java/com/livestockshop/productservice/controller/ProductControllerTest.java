package com.livestockshop.productservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.livestockshop.productservice.LivestockShopProductServiceApplication;
import com.livestockshop.productservice.model.dto.ProductForRead;
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

  private final List<ProductForRead> existingProducts;

  {
    List<ProductForRead> products = new ArrayList<>();
    ProductForRead product1 = new ProductForRead(1L, "name1", "decription1", 1, 1.0, "RUB", null,
        Set.of(1L));
    Collections.addAll(products, product1);
    this.existingProducts = Collections.unmodifiableList(products);
  }

  @Test
  @DisplayName("getPagedAndFiltered(...) - normal return")
  final void getPagedAndFiltered_normalReturn() throws Exception {
    String category = "Овцы";
    when(this.productService.getFilteredAndPaged(category))
        .thenReturn(this.existingProducts);
    this.mockMvc.perform(get("/products")
        .accept(MediaType.APPLICATION_JSON)
        .param("category", category))
        .andExpectAll(
            status().isOk(),
            content().contentType(MediaType.APPLICATION_JSON),
            content().bytes(this.objectMapper.writeValueAsBytes(
                this.productService.getFilteredAndPaged(category))));
  }
}
