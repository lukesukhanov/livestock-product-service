package com.livestockshop.productservice.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.livestockshop.productservice.model.dto.ProductForRead;
import com.livestockshop.productservice.model.entity.ProductEntity;
import com.livestockshop.productservice.service.ProductService;

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
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  /**
   * Finds products using filtering and paging.
   * <p>
   * Serves the {@code GET} requests for the {@code /products} endpoint.
   * <p>
   * <b>Usage example</b>
   * <p>
   * <i>Request</i>
   * <p>
   * GET /products?category=Овцы<br />
   * <p>
   * <i>Normal response</i>
   * <p>
   * Status: 200<br />
   * Body: [{id: 1, productName: "Овцы бараны", category: "Овцы", description:
   * "Продаю баранов и овец", quantity: 57, price: 10500, currency: "RUB",
   * idsOfImages: [1, 2]}, ...]
   * 
   * @return a {@code ResponseEntity} with the status {@code 200} and the body
   *         containing all the players found using filtering and paging
   */
  @GetMapping
  public ResponseEntity<List<ProductForRead>> getPagedAndFiltered(
      @RequestParam("category") String category) {
    List<ProductForRead> products = this.productService.getFilteredAndPaged(category);
    return ResponseEntity.ok(products);
  }
}
