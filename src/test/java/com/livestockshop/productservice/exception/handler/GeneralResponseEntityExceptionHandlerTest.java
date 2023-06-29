package com.livestockshop.productservice.exception.handler;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.livestockshop.productservice.LivestockShopProductServiceApplication;

@SpringBootTest(classes = LivestockShopProductServiceApplication.class)
@DisplayName("GeneralResponseEntityExceptionHandler")
@Tag("exceptionHandler")
@Tag("controller")
@AutoConfigureMockMvc
class GeneralResponseEntityExceptionHandlerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("handleConstraintViolationException(...) - invalid request parameter")
  final void handleConstraintViolationException_invalidRequestParameter() throws Exception {
    Integer page = -1;
    Integer size = 10;
    String category = "Овцы";
    Double minPrice = 0d;
    Double maxPrice = 10000d;
    this.mockMvc.perform(get("/products")
        .accept(MediaType.APPLICATION_JSON)
        .param("page", page.toString())
        .param("size", size.toString())
        .param("category", category)
        .param("minPrice", minPrice.toString())
        .param("maxPrice", maxPrice.toString()))
        .andExpectAll(
            status().isBadRequest(),
            content().contentType(MediaType.APPLICATION_PROBLEM_JSON));
  }

  @Test
  @DisplayName("handleTypeMismatch(...) - request parameter has invalid type")
  final void handleTypeMismatch_invalidRequestParameter() throws Exception {
    Double page = 1.1;
    Integer size = 10;
    String category = "Овцы";
    Double minPrice = 0d;
    Double maxPrice = 10000d;
    this.mockMvc.perform(get("/products")
        .accept(MediaType.APPLICATION_JSON)
        .param("page", page.toString())
        .param("size", size.toString())
        .param("category", category)
        .param("minPrice", minPrice.toString())
        .param("maxPrice", maxPrice.toString()))
        .andExpectAll(
            status().isBadRequest(),
            content().contentType(MediaType.APPLICATION_PROBLEM_JSON));
  }
}
