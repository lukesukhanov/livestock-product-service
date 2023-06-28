package com.livestockshop.productservice.model.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.Getter;

/**
 * A product.<br />
 * <p>
 * The {@code equals} method should be used for comparisons.
 * The {@code ProductForRead} objects are compared by {@code id}.
 * The {@code ProductForRead} with {@code id = null} is equal only to itself.
 * <p>
 * The {@code hashCode} method always returns the same value.
 * <p>
 * This class is immutable and thread-safe.
 */
@Getter
public final class ProductForRead implements Serializable {

  private static final long serialVersionUID = 1L;

  private final Long id;

  private final String productName;

  private final String description;

  private final Integer quantity;

  private final Double price;

  private final String currency;

  private final String categoryName;

  private final Set<Long> idsOfImages;

  public ProductForRead(Long id, String productName, String description, Integer quantity,
      Double price, String currency, String categoryName, Set<Long> idsOfImages) {
    this.id = id;
    this.productName = productName;
    this.description = description;
    this.quantity = quantity;
    this.price = price;
    this.currency = currency;
    this.categoryName = categoryName;
    this.idsOfImages = Set.copyOf(idsOfImages);
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ProductForRead)) {
      return false;
    }
    ProductForRead other = (ProductForRead) o;
    return this.id != null && this.id.equals(other.getId());
  }

}
