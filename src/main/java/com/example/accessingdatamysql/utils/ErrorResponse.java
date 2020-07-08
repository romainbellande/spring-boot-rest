package com.example.accessingdatamysql.utils;

import java.util.List;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;

public class ErrorResponse {
  private List<String> errors = new ArrayList<>();

  private Date timestamp;

  private int code;

  private String message;

  public ErrorResponse() {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    this.timestamp = new Date();
    this.code = status.value();
    this.message = status.getReasonPhrase();
  }

  public ErrorResponse(String error, HttpStatus status) {
    this.errors.add(error);
    this.timestamp = new Date();
    this.code = status.value();
    this.message = status.getReasonPhrase();
  }

  public ErrorResponse(List<String> errors, HttpStatus status) {
    this.errors = errors;
    this.timestamp = new Date();
    this.code = status.value();
    this.message = status.getReasonPhrase();
  }

  public ErrorResponse(List<String> errors, Date timestamp, int code, String message) {
    this.errors = errors;
    this.timestamp = timestamp;
    this.code = code;
    this.message = message;
  }

  public List<String> getErrors() {
    return this.errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

  public Date getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public int getCode() {
    return this.code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorResponse httpStatus(HttpStatus status) {
    this.code = status.value();
    this.message = status.getReasonPhrase();
    return this;
  }

  public ErrorResponse error(String error) {
    this.errors.add(error);
    return this;
  }

  public ErrorResponse errors(List<String> errors) {
    this.errors = errors;
    return this;
  }

  public ErrorResponse timestamp(Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public ErrorResponse code(int code) {
    this.code = code;
    return this;
  }

  public ErrorResponse message(String message) {
    this.message = message;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " errors='" + getErrors() + "'" +
      ", timestamp='" + getTimestamp() + "'" +
      ", code='" + getCode() + "'" +
      ", message='" + getMessage() + "'" +
      "}";
  }
}
