package com.livestock.productservice.model.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * A product filter.
 * <p>
 * The {@code equals} method should be used for comparisons.
 * The {@code ProductEntity} objects are compared by {@code page}, {@code size},
 * {@code search}, {@code categoryId}, {@code minPrice} and {@code maxPrice}.
 * <p>
 * This class is immutable and thread-safe.
 */
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class ProductFilter {

  @PositiveOrZero(message = "Page ordinal must be greater than or equal to 0")
  private final Integer page;

  @Positive(message = "Page size must be positive")
  private final Integer size;

  private final String search;

  private final Long categoryId;

  private final Double minPrice;

  private final Double maxPrice;
}
