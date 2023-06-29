package com.livestockshop.productservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
   * <p>
   * <i>Response in case request parameter has invalid type</i>
   * <p>
   * Status: 400<br />
   * Body: {type: "/probs/requestPropertyTypeMismatch", title: "Request property
   * type mismatch", status: 400, detail: "Failed to convert value of type
   * 'java.lang.String' to required type 'java.lang.Long'; For input string:
   * \"1.1\"", property: "productId", requiredType: "java.lang.Long", value:
   * "1.1"}
   * 
   * @return a {@code ResponseEntity} with the status {@code 200} and the body
   *         containing ids of the images related to the required product
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getIdsOfImagesByProductId(@RequestParam("productId") Long productId) {
    List<Long> products = this.productImageService.getIdsOfImagesByProductId(productId);
    Map<String, Object> responseBody = Map.of("idsOfImages", products);
    return ResponseEntity.ok(responseBody);
  }

  /**
   * Finds an image by id.
   * <p>
   * Serves the {@code GET} requests for the {@code /productImages/{id}}
   * endpoints.
   * <p>
   * Path variables:
   * <ul>
   * <li>id - id of the image, type: long</li>
   * </ul>
   * <p>
   * <b>Usage example</b>
   * <p>
   * <i>Request</i>
   * <p>
   * GET /productImages/1
   * <p>
   * <i>Normal response</i>
   * <p>
   * Status: 200<br />
   * Body: <bytes of the image>
   * <p>
   * <i>Response in case request parameter has invalid type</i>
   * <p>
   * Status: 400<br />
   * Body: {type: "/probs/requestPropertyTypeMismatch", title: "Request property
   * type mismatch", status: 400, detail: "Failed to convert value of type
   * 'java.lang.String' to required type 'java.lang.Long'; For input string:
   * \"1.1\"", property: "id", requiredType: "java.lang.Long", value:
   * "1.1"}
   * <p>
   * <i>Response in case an image wasn't found</i>
   * <p>
   * Status: 404<br />
   * Body: {type: "/probs/resourceNotFound", title: "Can't find a product image
   * with id 1", status: 404}
   * 
   * @return a {@code ResponseEntity} with the status {@code 200} and the body
   *         containing bytes of the image
   */
  @GetMapping(path = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
  public ResponseEntity<?> getImageById(@PathVariable("id") Long id) {
    byte[] image = this.productImageService.getImageById(id);
    return ResponseEntity.ok(image);
  }
}
