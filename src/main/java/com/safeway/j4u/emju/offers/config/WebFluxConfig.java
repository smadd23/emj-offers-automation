package com.safeway.j4u.emju.offers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer {

  @Autowired
  private Validator defaultValidator;

  @Override
  public Validator getValidator() {
    return defaultValidator;
  }

}
