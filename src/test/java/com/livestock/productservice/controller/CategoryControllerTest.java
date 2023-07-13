package com.livestock.productservice.controller;

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
import com.livestock.productservice.Application;
import com.livestock.productservice.model.entity.CategoryEntity;
import com.livestock.productservice.service.CategoryService;

@SpringBootTest(classes = Application.class)
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

  private final List<CategoryEntity> existingCategories = List.of(new CategoryEntity());

  @Test
  @DisplayName("getAllCategoryNames(...) - normal return")
  final void getAllCategoryNames_normalReturn() throws Exception {
    when(this.categoryService.getAll())
        .thenReturn(this.existingCategories);
    this.mockMvc.perform(get("/categories")
        .accept(MediaType.APPLICATION_JSON))
        .andExpectAll(
            status().isOk(),
            content().contentType(MediaType.APPLICATION_JSON),
            content().bytes(this.objectMapper.writeValueAsBytes(this.existingCategories)));
  }
}
