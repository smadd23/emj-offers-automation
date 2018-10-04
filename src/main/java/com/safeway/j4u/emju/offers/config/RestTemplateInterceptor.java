package com.safeway.j4u.emju.offers.config;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

@Slf4j
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

    logRequestDetails(request, new String(body));

    return execution.execute(request, body);
  }

  private void logRequestDetails(HttpRequest request, String body) {
    log.info("Request Headers: {}", request.getHeaders());
    log.info("Request Method: {}", request.getMethod());
    log.info("Request URI: {}", request.getURI());
    log.info("RequestBody: {}", body);
  }
}
