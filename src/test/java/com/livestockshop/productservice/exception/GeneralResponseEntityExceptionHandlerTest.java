package com.livestockshop.productservice.exception;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.livestockshop.productservice.LivestockShopProductServiceApplication;
import com.livestockshop.productservice.controller.ProductImageController;

@SpringBootTest(classes = LivestockShopProductServiceApplication.class)
@DisplayName("GeneralResponseEntityExceptionHandler")
@Tag("exceptionHandler")
@Tag("controller")
@AutoConfigureMockMvc
class GeneralResponseEntityExceptionHandlerTest {

  @MockBean
  private ProductImageController productImageController;

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
  final void handleTypeMismatch_requestParameterHasInvalidType() throws Exception {
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

  @Test
  @DisplayName("handleNotFoundException(...) - resource not found")
  final void handleNotFoundException_resourceNotFound() throws Exception {
    Long id = 1L;
    when(this.productImageController.getImageById(id))
        .thenThrow(new ProductImageNotFoundException(id));
    this.mockMvc.perform(get("/productImages/" + id)
        .accept(MediaType.IMAGE_JPEG))
        .andExpectAll(
            status().isNotFound());
  }
}
