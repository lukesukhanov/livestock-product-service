package com.livestockshop.productservice.controller;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.livestockshop.productservice.model.entity.ProductEntity;
import com.livestockshop.productservice.service.ProductService;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;

/**
 * Provides the endpoints for accessing products.<br />
 * <p>
 * The endpoints {@code /products/**} are used.
 * <p>
 * The JSON format is used for the response body.
 * 
 * @see ProductEntity
 * @see ProductService
 */
@RestController
@RequestMapping(path = "/products",
    produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  /**
   * Finds products using paging and filtering.
   * <p>
   * Serves the {@code GET} requests for the {@code /products} endpoint.
   * <p>
   * <b>Usage example</b>
   * <p>
   * <i>Request</i>
   * <p>
   * GET /products?page=0?size=5?category=Овцы?minPrice=0?maxPrice=10000
   * <p>
   * <i>Normal response</i>
   * <p>
   * Status: 200<br />
   * Body: {numberOfElements: 5, first: true, last: false, totalElements: 10,
   * totalPages: 2, content: [{id: 1, productName: "Овцы бараны", description:
   * "Продаю баранов и овец", quantity: 57, price: 9500, currency: "RUB",
   * category: "Овцы"}, ...]}
   * 
   * @return a {@code ResponseEntity} with the status {@code 200} and the body
   *         containing all the players found using paging and filtering
   */
  @GetMapping
  public ResponseEntity<?> getWithPagingAndFiltering(
      @RequestParam(name = "page", required = false)
      @PositiveOrZero(message = "Page ordinal must be greater than or equal to 0") Integer page,

      @RequestParam(name = "size", required = false)
      @Positive(message = "Page size must be positive") Integer size,

      @RequestParam(name = "category", required = false) String categoryName,

      @RequestParam(name = "minPrice", required = false)
      @PositiveOrZero(message = "Minimal price must be greater than or equal to 0") Double minPrice,

      @RequestParam(name = "maxPrice", required = false)
      @Positive(message = "Maximal price must be positive") Double maxPrice) {

    Page<ProductEntity> products = this.productService.getWithPagingAndFiltering(page, size,
        categoryName, minPrice, maxPrice);
    Map<String, Object> responseBody = Map.of(
        "numberOfElements", products.getNumberOfElements(),
        "first", products.isFirst(),
        "last", products.isLast(),
        "totalElements", products.getTotalElements(),
        "totalPages", products.getTotalPages(),
        "content", products.getContent());
    return ResponseEntity.ok(responseBody);
  }
}
