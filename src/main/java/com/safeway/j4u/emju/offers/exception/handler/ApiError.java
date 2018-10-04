package com.safeway.j4u.emju.offers.exception.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.codec.DecodingException;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Data
@Slf4j
public class ApiError {

  private String timestamp;
  private HttpStatus status;
  private String message;
  private List<String> errors;

  public ApiError(final HttpStatus status, final String message, final List<String> errors) {
    this.timestamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
    this.status = status;
    this.message = message;
    this.errors = errors;
  }

  public ApiError(HttpStatus status, String message, String error) {
    this.timestamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
    this.status = status;
    this.message = message;
    errors = Arrays.asList(error);
  }

  // 500
  public static Mono<DataBuffer> fromUnknownException(ServerWebExchange exchange, Throwable ex, ObjectMapper objectMapper) throws JsonProcessingException {
    log.error("Unknown Exception", ex);
    exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
    exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
    return Mono.just(
        new DefaultDataBufferFactory().wrap(objectMapper.writeValueAsBytes(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "Unknown error occurred"))));
  }

  // 500
  public static Mono<DataBuffer> fromWebClientResponseException(ServerWebExchange exchange, Throwable ex, ObjectMapper objectMapper) throws JsonProcessingException {
    log.error("Unknown Exception", ex);
    exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
    exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
    return Mono.just(
        new DefaultDataBufferFactory().wrap(objectMapper.writeValueAsBytes(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "Client Response Error."))));
  }

  // 4xx
  public static Mono<DataBuffer> fromBindException(ServerWebExchange exchange, WebExchangeBindException ex, ObjectMapper objectMapper) throws JsonProcessingException {
    log.debug("Errors received:: " + ex.getFieldErrors());
    final List<String> errors = Lists.newArrayList();
    ex.getFieldErrors().forEach(e -> errors.add(e.getField() + ": " + e.getCode() + ": " + e.getDefaultMessage()));
    ex.getGlobalErrors().forEach(e -> errors.add(e.getObjectName() + ": " + e.getCode() + ": " + e.getDefaultMessage()));
    log.debug("Errors to be sent:: " + errors);
    exchange.getResponse().setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY);
    exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
    return Mono.just(
        new DefaultDataBufferFactory().wrap(objectMapper.writeValueAsBytes(new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, ex.getLocalizedMessage(), errors))));
  }

  public static Mono<DataBuffer> fromTypeMismatchException(ServerWebExchange exchange, TypeMismatchException ex, ObjectMapper objectMapper) throws JsonProcessingException {
    final String error = ex.getValue() + " value for " + ex.getPropertyName() + " should be of type " + ex.getRequiredType();
    exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
    exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
    return Mono.just(
        new DefaultDataBufferFactory().wrap(objectMapper.writeValueAsBytes(new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ImmutableList.of(error)))));
  }

  public static Mono<DataBuffer> fromMethodArgumentTypeMismatchException(ServerWebExchange exchange, MethodArgumentTypeMismatchException ex, ObjectMapper objectMapper) throws JsonProcessingException {
    final String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();
    exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
    exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
    return Mono.just(
        new DefaultDataBufferFactory().wrap(objectMapper.writeValueAsBytes(new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ImmutableList.of(error)))));
  }
  
  public static Mono<DataBuffer> fromDecodingException(ServerWebExchange exchange, DecodingException ex, ObjectMapper objectMapper) throws JsonProcessingException {
	  log.error("Decoding error" , ex);
	    final String error = ex.getLocalizedMessage();
	    exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
	    exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
	    return Mono.just(
	        new DefaultDataBufferFactory().wrap(objectMapper.writeValueAsBytes(new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ImmutableList.of(error)))));
	  }

  public static Mono<DataBuffer> fromConstraintViolationException(ServerWebExchange exchange, ConstraintViolationException ex, ObjectMapper objectMapper) throws JsonProcessingException {
    final List<String> errors = Lists.newArrayList();
    for (final ConstraintViolation<?> violation : ex.getConstraintViolations()) {
      errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": " + violation.getMessage());
    }
    exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
    exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
    return Mono.just(
        new DefaultDataBufferFactory().wrap(objectMapper.writeValueAsBytes(new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors))));
  }

  // For Application Exceptions
  public static Mono<DataBuffer> fromResponseStatusException(ServerWebExchange exchange, ResponseStatusException ex, ObjectMapper objectMapper) throws JsonProcessingException {
    final List<String> errors = Lists.newArrayList();
    errors.add("Reason: " + ex.getReason());
    errors.add("Message: " + ex.getMessage());
    exchange.getResponse().setStatusCode(ex.getStatus());
    exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
    return Mono.just(
        new DefaultDataBufferFactory().wrap(objectMapper.writeValueAsBytes(new ApiError(ex.getStatus(), ex.getLocalizedMessage(), errors))));
  }
}