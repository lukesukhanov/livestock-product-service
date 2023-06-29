package com.livestockshop.productservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.livestockshop.productservice.LivestockShopProductServiceApplication;
import com.livestockshop.productservice.repository.CategoryRepository;

@SpringBootTest(classes = LivestockShopProductServiceApplication.class)
@DisplayName("DefaultCategoryService")
@Tag("service")
@Tag("category")
class DefaultCategoryServiceTest {

  @MockBean
  private CategoryRepository categoryRepository;

  @Autowired
  private DefaultCategoryService categoryService;

  private final List<String> existingCategoryNames = List.of("Овцы", "Коровы", "Свиньи");

  @Test
  @DisplayName("getAllCategoryNames(...) - normal return")
  final void getAllCategoryNames_normalReturn() throws Exception {
    when(this.categoryRepository.findAllCategoryNames())
        .thenReturn(this.existingCategoryNames);
    List<String> result = this.categoryService.getAllCategoryNames();
    assertEquals(result, this.existingCategoryNames);
  }
}
