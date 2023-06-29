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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.livestockshop.productservice.LivestockShopProductServiceApplication;
import com.livestockshop.productservice.service.ProductImageService;

@SpringBootTest(classes = LivestockShopProductServiceApplication.class)
@DisplayName("ProductImageController")
@Tag("controller")
@Tag("productImage")
@AutoConfigureMockMvc
class ProductImageControllerTest {

  @MockBean
  private ProductImageService productImageService;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  private final List<Long> existingIdsOfImagesForOneProduct;

  {
    List<Long> idsOfImagesForOneProduct = new ArrayList<>();
    Collections.addAll(idsOfImagesForOneProduct, 1L, 2L, 3L);
    this.existingIdsOfImagesForOneProduct = Collections.unmodifiableList(idsOfImagesForOneProduct);
  }

  @Test
  @DisplayName("getIdsOfImagesByProductId(Long) - normal return")
  final void getIdsOfImagesByProductId_normalReturn() throws Exception {
    Long productId = 1L;
    Map<String, ?> responseBody = Map.of("idsOfImages", this.existingIdsOfImagesForOneProduct);
    when(this.productImageService.getIdsOfImagesByProductId(productId))
        .thenReturn(this.existingIdsOfImagesForOneProduct);
    this.mockMvc.perform(get("/productImages")
        .accept(MediaType.APPLICATION_JSON)
        .param("productId", productId.toString()))
        .andExpectAll(
            status().isOk(),
            content().contentType(MediaType.APPLICATION_JSON),
            content().string(this.objectMapper.writeValueAsString(responseBody)));
  }

  @Test
  @DisplayName("getImageById(Long) - normal return")
  final void getImageById_normalReturn() throws Exception {
    Long id = 1L;
    byte[] existingImage = { 1, 2, 3 };
    when(this.productImageService.getImageById(id))
        .thenReturn(existingImage);
    this.mockMvc.perform(get("/productImages/" + id)
        .accept(MediaType.IMAGE_JPEG))
        .andExpectAll(
            status().isOk(),
            content().contentType(MediaType.IMAGE_JPEG),
            content().bytes(existingImage));
  }
}
