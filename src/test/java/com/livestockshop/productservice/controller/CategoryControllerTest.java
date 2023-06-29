package com.livestockshop.productservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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
import com.livestockshop.productservice.service.CategoryService;

@SpringBootTest(classes = LivestockShopProductServiceApplication.class)
@DisplayName("CategoryController")
@Tag("controller")
@Tag("category")
@AutoConfigureMockMvc
class CategoryControllerTest {

  @MockBean
  private CategoryService categoryService;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  private final List<String> existingCategoryNames = List.of("Овцы", "Коровы", "Свиньи");

  @Test
  @DisplayName("getAllCategoryNames(...) - normal return")
  final void getAllCategoryNames_normalReturn() throws Exception {
    when(this.categoryService.getAllCategoryNames())
        .thenReturn(this.existingCategoryNames);
    this.mockMvc.perform(get("/categories")
        .accept(MediaType.APPLICATION_JSON))
        .andExpectAll(
            status().isOk(),
            content().contentType(MediaType.APPLICATION_JSON),
            content().bytes(this.objectMapper.writeValueAsBytes(this.existingCategoryNames)));
  }
}
