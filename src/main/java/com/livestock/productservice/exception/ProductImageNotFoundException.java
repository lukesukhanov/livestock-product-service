package com.livestock.productservice.exception;

/**
 * May be thrown in case a product image wasn't found.
 * 
 * @see GeneralResponseEntityExceptionHandler
 */
public class ProductImageNotFoundException extends NotFoundException {

  private static final long serialVersionUID = 1L;

  public ProductImageNotFoundException(Long id) {
    super("Can't find a product image with id %d".formatted(id));
  }
}
