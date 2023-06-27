package com.livestockshop.productservice.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.livestockshop.productservice.dto.Product;
import com.livestockshop.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

/**
 * Provides the endpoints for accessing products.<br />
 * <p>
 * The endpoints {@code /products/**} are used.
 * <p>
 * The JSON format is used for the response body.
 * 
 * @author Luke Sukhanov
 * @version 1.0
 * @see Product
 * @see ProductService
 */
@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
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
   * GET /products?category=Овцы<br />
   * <p>
   * <i>Normal response</i>
   * <p>
   * Status: 200<br />
   * Body: [{id: 1, productName: "Овцы бараны", category: "Овцы", description: "Продаю баранов и овец"}, ... ]
   * 
   * @return a {@code ResponseEntity} with the status {@code 200} and the body
   *         containing all the players found
   */
  @GetMapping
  public ResponseEntity<List<Product>> getPagedAndFiltered(
      @RequestParam("category") String category) {
    List<Product> products = this.productService.getPagedAndFiltered(category);
    return ResponseEntity.ok(products);
  }
}
