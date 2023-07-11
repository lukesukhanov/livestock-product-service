package com.livestockshop.productservice.controller;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livestockshop.productservice.exception.GeneralResponseEntityExceptionHandler;
import com.livestockshop.productservice.model.dto.ProductFilter;
import com.livestockshop.productservice.model.entity.ProductEntity;
import com.livestockshop.productservice.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * Provides the endpoints for accessing products.
 * <p>
 * The endpoints {@code /products/**} are used.
 * <p>
 * The JSON format is used for the response body.
 * 
 * @see ProductService
 * @see GeneralResponseEntityExceptionHandler
 */
@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  /**
   * Finds products using paging and filtering.
   * <p>
   * Serves the {@code GET} requests for the {@code /products} endpoint.
   * <p>
   * Request parameters:
   * <ul>
   * <li>page - the required page, type: integer, greater than or equal to 0,
   * not required</li>
   * <li>size - the page size, type: integer, positive, not required</li>
   * <li>categoryId - the category id, type: long, not required</li>
   * <li>minPrice - the minimal price of a product, type: double, not
   * required</li>
   * <li>maxPrice - the maximal price of a product, type: double, not
   * required</li>
   * </ul>
   * <p>
   * <b>Usage example</b>
   * <p>
   * <i>Request</i>
   * <p>
   * GET /products?page=0&size=5&categoryId=1&minPrice=0&maxPrice=10000
   * <p>
   * <i>Normal response</i>
   * <p>
   * Status: 200<br />
   * Body: {numberOfElements: 5, first: true, last: false, totalElements: 10,
   * totalPages: 2, content: [{id: 1, productName: "Овцы бараны", description:
   * "Продаю баранов и овец", quantity: 57, price: 9500, currency: "RUB",
   * category: "Овцы"}, ...]}
   * <p>
   * <i>Response in case of invalid request parameters</i>
   * <p>
   * Status: 400<br />
   * Body: {type: "/probs/invalidRequestParameters", title: "Invalid request
   * parameters", status: 400, invalid-params: [{"name": "page", "reason": "Page
   * ordinal must be greater than or equal to 0"}]}
   * <p>
   * <i>Response in case request parameter has invalid type</i>
   * <p>
   * Status: 400<br />
   * Body: {type: "/probs/requestPropertyTypeMismatch", title: "Request property
   * type mismatch", status: 400, detail: "Failed to convert value of type
   * 'java.lang.String' to required type 'java.lang.Integer'; For input string:
   * \"1.1\"", property: "page", requiredType: "java.lang.Integer", value:
   * "1.1"}
   * 
   * @param page a {@code Integer} representing page ordinal
   * @param size a {@code Integer} representing page size
   * @param search a {@code String} with search pattern
   * @param categoryId a {@code Long} representing id of the product category
   * @param size a {@code Double} representing minimal product price
   * @param size a {@code Double} representing maximal product price
   * @return a {@code ResponseEntity} with the status {@code 200} and the body
   *         containing the products found using paging and filtering
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getWithPagingAndFiltering(@Valid ProductFilter productFilter) {

    Page<ProductEntity> products = this.productService.getWithPagingAndFiltering(productFilter);
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
