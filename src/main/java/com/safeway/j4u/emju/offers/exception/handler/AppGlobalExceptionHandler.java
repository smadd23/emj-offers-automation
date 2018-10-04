package com.safeway.j4u.emju.offers.exception.handler;

import static com.safeway.j4u.emju.offers.exception.handler.ApiError.fromBindException;
import static com.safeway.j4u.emju.offers.exception.handler.ApiError.fromConstraintViolationException;
import static com.safeway.j4u.emju.offers.exception.handler.ApiError.fromDecodingException;
import static com.safeway.j4u.emju.offers.exception.handler.ApiError.fromMethodArgumentTypeMismatchException;
import static com.safeway.j4u.emju.offers.exception.handler.ApiError.fromResponseStatusException;
import static com.safeway.j4u.emju.offers.exception.handler.ApiError.fromTypeMismatchException;
import static com.safeway.j4u.emju.offers.exception.handler.ApiError.fromUnknownException;
import static com.safeway.j4u.emju.offers.exception.handler.ApiError.fromWebClientResponseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.codec.DecodingException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebInputException;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

@Order(-2)
@RestControllerAdvice
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AppGlobalExceptionHandler implements WebExceptionHandler {

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public Mono<Void> handle(ServerWebExchange exchange, Throwable cause) {
    log.info(cause.getClass().getName(),cause);
    try {
      if(cause instanceof WebClientResponseException) {
          return exchange.getResponse().writeWith(fromWebClientResponseException(exchange, cause, objectMapper));
      }
      if(cause instanceof  ResponseStatusException) {
        if (cause instanceof ServerWebInputException) {
          return handleServerWebInputException(exchange, cause);
        } else {
          // Applicaton exceptions
          return handleResponseStatusException(exchange, cause);
        }
      } else {
        return exchange.getResponse().writeWith(fromUnknownException(exchange, cause, objectMapper));
      }

    } catch (JsonProcessingException e) {
      log.debug("JsonProcessingException while building error:: " , e);
      return Mono.empty();
    }
  }

  private Mono<Void> handleServerWebInputException(ServerWebExchange exchange, Throwable cause) throws JsonProcessingException {
    if (cause instanceof WebExchangeBindException) {
      return exchange.getResponse().writeWith(
          fromBindException(exchange, (WebExchangeBindException) cause, objectMapper));
    } else if (cause instanceof TypeMismatchException) {
      return handleTypeMismatchException(exchange, cause);
    } else if (cause instanceof ConstraintViolationException) {
      return exchange.getResponse().writeWith(
          fromConstraintViolationException(exchange, (ConstraintViolationException) cause,
              objectMapper));
    } else if (cause.getCause() instanceof DecodingException) {
    	return exchange.getResponse().writeWith(fromDecodingException(exchange, (DecodingException) cause.getCause(), objectMapper));
    } 
    return exchange.getResponse().writeWith(fromUnknownException(exchange, cause, objectMapper));
  }

  private Mono<Void> handleTypeMismatchException(ServerWebExchange exchange, Throwable cause) throws JsonProcessingException {
    if (cause instanceof MethodArgumentTypeMismatchException) {
      return exchange.getResponse().writeWith(
          fromMethodArgumentTypeMismatchException(exchange,
              (MethodArgumentTypeMismatchException) cause, objectMapper));
    }
    return exchange.getResponse().writeWith(
        fromTypeMismatchException(exchange, (TypeMismatchException) cause, objectMapper));
  }

  private Mono<Void> handleResponseStatusException(ServerWebExchange exchange, Throwable cause) throws JsonProcessingException {
    return exchange.getResponse().writeWith(
        fromResponseStatusException(exchange, (ResponseStatusException) cause,
            objectMapper));
  }
}
