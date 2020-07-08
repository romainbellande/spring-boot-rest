package com.example.accessingdatamysql;

import java.util.List;
import java.util.stream.Collectors;

import com.example.accessingdatamysql.utils.ErrorResponse;

import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value
    = { PropertyReferenceException.class, IllegalArgumentException.class })
  protected ResponseEntity<Object> handleConflict(
    RuntimeException ex, WebRequest request) {
      ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
      return handleExceptionInternal(ex, error,
        new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
    MethodArgumentNotValidException ex,
    HttpHeaders headers,
    HttpStatus status,
    WebRequest request) {
      List<String> errors = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(x -> x.getDefaultMessage())
        .collect(Collectors.toList());

      ErrorResponse error = new ErrorResponse().errors(errors);

      return handleExceptionInternal(ex, error,
        new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }
}
