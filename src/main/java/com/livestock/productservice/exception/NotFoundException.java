package com.livestock.productservice.exception;

/**
 * May be thrown in case a resource wasn't found.
 * 
 * @see GeneralResponseEntityExceptionHandler
 */
public abstract class NotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public NotFoundException(String message) {
    super(message);
  }
}