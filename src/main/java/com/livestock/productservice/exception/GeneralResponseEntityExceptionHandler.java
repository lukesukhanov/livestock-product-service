package com.livestock.productservice.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles general controller exceptions.
 */
@ControllerAdvice
@Slf4j
public class GeneralResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException e, HttpHeaders headers,
      HttpStatusCode status, WebRequest request) {

    log.debug("Handling {}", e.toString());
    Map<String, ?> responseBody = Map.of(
        "type", request.getContextPath() + "/probs/requestPropertyTypeMismatch",
        "title", "Request property type mismatch",
        "status", "400",
        "detail", e.getMessage(),
        "property", e.getPropertyName(),
        "requiredType", e.getRequiredType(),
        "value", e.getValue());
    headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);
    return handleExceptionInternal(e, responseBody, headers, HttpStatus.BAD_REQUEST, request);
  }

  /**
   * Handles the {@code ConstraintViolationException} which may be thrown in
   * case of invalid request parameters.
   * 
   * @param e the catched {@code ConstraintViolationException}
   * @param request the current {@code WebRequest}
   * @return a {@code ResponseEntity} with the problem details
   */
  @ExceptionHandler(ConstraintViolationException.class)
  private ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e,
      WebRequest request) {

    log.debug("Handling {}", e.toString());
    List<Map<String, ?>> invalidParams = new ArrayList<>(2);
    for (ConstraintViolation<?> invalidParam : e.getConstraintViolations()) {
      String paramPath = invalidParam.getPropertyPath().toString();
      String paramName = paramPath.substring(paramPath.lastIndexOf(".") + 1);
      invalidParams.add(Map.of(
          "name", paramName,
          "reason", invalidParam.getMessage()));
    }
    Map<String, ?> responseBody = Map.of(
        "type", request.getContextPath() + "/probs/invalidRequestParameters",
        "title", "Invalid request parameters",
        "status", "400",
        "invalid-params", invalidParams);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);
    return handleExceptionInternal(e, responseBody, headers, HttpStatus.BAD_REQUEST, request);
  }

  /**
   * Handles the {@code NotFoundException} which may be thrown in case a
   * resource wasn't found.
   * 
   * @param e the catched {@code NotFoundException}
   * @param request the current {@code WebRequest}
   * @return a {@code ResponseEntity} with the problem details
   */
  @ExceptionHandler(NotFoundException.class)
  private ResponseEntity<Object> handleNotFoundException(NotFoundException e, WebRequest request) {
    log.debug("Handling {}", e.toString());
    Map<String, ?> responseBody = Map.of(
        "type", request.getContextPath() + "/probs/resourceNotFound",
        "title", e.getMessage(),
        "status", "404");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);
    return handleExceptionInternal(e, responseBody, headers, HttpStatus.NOT_FOUND, request);
  }
  
  /**
   * Handles the {@code DataIntegrityViolationException} which may be thrown in
   * case of duplicating email and so on.
   * 
   * @param e the catched {@code DataIntegrityViolationException}
   * @param request the current {@code WebRequest}
   * @return a {@code ResponseEntity} with the problem details
   */
  @ExceptionHandler(DataIntegrityViolationException.class)
  private ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException e,
      WebRequest request) {
    log.debug("Handling {}", e.toString());
    Map<String, ?> responseBody = Map.of(
        "type", request.getContextPath()
            + "/probs/dataIntegrityViolation",
        "title", e.getMessage(),
        "status", "400");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);
    return handleExceptionInternal(e, responseBody, headers, HttpStatus.BAD_REQUEST, request);
  }
}
