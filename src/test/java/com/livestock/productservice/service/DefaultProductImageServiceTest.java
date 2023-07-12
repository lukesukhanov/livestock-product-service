package com.livestock.productservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.livestock.productservice.LivestockShopProductServiceApplication;
import com.livestock.productservice.repository.ProductImageRepository;

@SpringBootTest(classes = LivestockShopProductServiceApplication.class)
@DisplayName("DefaultProductImageService")
@Tag("service")
@Tag("productImage")
class DefaultProductImageServiceTest {

  @MockBean
  private ProductImageRepository productImageRepository;

  @Autowired
  private DefaultProductImageService productImageService;

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
    when(this.productImageRepository.findIdsOfImagesByProductId(productId))
        .thenReturn(this.existingIdsOfImagesForOneProduct);
    List<Long> result = this.productImageService.getIdsOfImagesByProductId(productId);
    assertEquals(result, this.existingIdsOfImagesForOneProduct);
  }

  @Test
  @DisplayName("getImageById(Long) - normal return")
  final void getImageById_normalReturn() throws Exception {
    Long id = 1L;
    byte[] existingImage = { 1, 2, 3 };
    when(this.productImageRepository.findImageById(id))
        .thenReturn(Optional.of(existingImage));
    byte[] result = this.productImageService.getImageById(id);
    assertEquals(result, existingImage);
  }
}
