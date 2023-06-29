package com.livestockshop.productservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livestockshop.productservice.exception.GeneralResponseEntityExceptionHandler;
import com.livestockshop.productservice.service.CategoryService;

import lombok.RequiredArgsConstructor;

/**
 * Provides the endpoints for accessing product categories.
 * <p>
 * The endpoints {@code /categories/**} are used.
 * <p>
 * The JSON format is used for the response body.
 * 
 * @see CategoryService
 * @see GeneralResponseEntityExceptionHandler
 */
@RestController
@RequestMapping(path = "/categories")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;

  /**
   * Finds all product categories.
   * <p>
   * Serves the {@code GET} requests for the {@code /categories} endpoint.
   * <p>
   * <b>Usage example</b>
   * <p>
   * <i>Request</i>
   * <p>
   * GET /categories
   * <p>
   * <i>Normal response</i>
   * <p>
   * Status: 200<br />
   * Body: [{id: 1, categoryName: "Овцы"}, {id: 1, categoryName: "Коровы"}]
   * 
   * @return a {@code ResponseEntity} with the status {@code 200} and the body
   *         containing all existing product categories
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getAll() {
    return ResponseEntity.ok(this.categoryService.getAll());
  }
}
