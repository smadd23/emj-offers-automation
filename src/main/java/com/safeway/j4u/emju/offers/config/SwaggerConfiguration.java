package com.safeway.j4u.emju.offers.config;

import static com.safeway.j4u.emju.offers.util.OffersConstants.API_OFFERS_ROOT;
import static com.safeway.j4u.emju.offers.util.OffersConstants.APPLICATION_VND_SAFEWAY_V1_JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurationSupport;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@Configuration
@EnableSwagger2WebFlux
@Import(BeanValidatorPluginsConfiguration.class)
@Profile("!prod")
public class SwaggerConfiguration extends WebFluxConfigurationSupport {

  @Bean
  public Jackson2JsonEncoder jackson2JsonEncoder(ObjectMapper mapper) {
    return new Jackson2JsonEncoder(mapper);
  }

  @Bean
  public Jackson2JsonDecoder jackson2JsonDecoder(ObjectMapper mapper) {
    return new Jackson2JsonDecoder(mapper);
  }

  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations("classpath:META-INF/resources/");
  }

  @Bean
  public Docket apiV1_0() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfoV1_0())
        .enable(true)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.safeway.j4u").and(p -> {
          if (p.produces() != null) {
            for (MediaType mt : p.produces()) {
              if (mt.toString().equals(APPLICATION_VND_SAFEWAY_V1_JSON)) {
                return true;
              }
            }
          }
          return false;
        }))
        .paths(PathSelectors.ant(API_OFFERS_ROOT + "/**"))
        .build();
  }

  private ApiInfo apiInfoV1_0() {
    return new ApiInfoBuilder()
        .title("Offer Preview Microservices")
        .description("Offer Preview Api Documentation")
        .version("1.0")
        .license("@Albertsons Companies")
        .licenseUrl("http://www.safeway.com")
        .build();

  }

}
