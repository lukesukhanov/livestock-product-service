package com.livestockshop.productservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.livestockshop.productservice.service.ProductImageService;

import lombok.RequiredArgsConstructor;

/**
 * Provides the endpoints for accessing product's images.
 * <p>
 * The endpoints {@code /productImages/**} are used.
 * <p>
 * The JSON format is used for the response body.
 * 
 * @see ProductImageService
 * @see ProductImageExceptionHandler
 */
@RestController
@RequestMapping(path = "/productImages")
@RequiredArgsConstructor
public class ProductImageController {

  private final ProductImageService productImageService;

  /**
   * Finds ids of the images related to the required product.
   * <p>
   * Serves the {@code GET} requests for the {@code /productImages} endpoint.
   * <p>
   * Request parameters:
   * <ul>
   * <li>productId - the product's id, type: long, required</li>
   * </ul>
   * <p>
   * <b>Usage example</b>
   * <p>
   * <i>Request</i>
   * <p>
   * GET /productImages?productId=1
   * <p>
   * <i>Normal response</i>
   * <p>
   * Status: 200<br />
   * Body: {idsOfImages: [1, 2, 3]}
   * 
   * @return a {@code ResponseEntity} with the status {@code 200} and the body
   *         containing ids of the images related to the required product
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getIdsOfImagesByProductId(
      @RequestParam(name = "productId") Long productId) {

    List<Long> products = this.productImageService.getIdsOfImagesByProductId(productId);
    Map<String, Object> responseBody = Map.of("idsOfImages", products);
    return ResponseEntity.ok(responseBody);
  }
}
