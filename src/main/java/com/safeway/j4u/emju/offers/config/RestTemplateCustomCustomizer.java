package com.safeway.j4u.emju.offers.config;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.web.client.RestTemplate;

public class RestTemplateCustomCustomizer  implements RestTemplateCustomizer {
  @Override
  public void customize(RestTemplate restTemplate) {
    restTemplate.getInterceptors().add(new RestTemplateInterceptor());
  }

}
