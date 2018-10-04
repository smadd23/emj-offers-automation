package com.safeway.j4u.emju.offers.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.xml.bind.Marshaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class OffersConfig {

	@Bean
	public RestTemplate restTemplate() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(Include.NON_NULL);
    mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
    mapper.findAndRegisterModules();
		return restTemplateBuilder().additionalMessageConverters(
		    new StringHttpMessageConverter(),
        new ByteArrayHttpMessageConverter(),
        new Jaxb2RootElementHttpMessageConverter() {
		      @Override
          protected void customizeMarshaller(Marshaller marshaller) {
		        try {
              marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
              marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            } catch (Exception e) {
		          log.error("Marshaller Error: {}", e.getLocalizedMessage() );
            }
          }

        },
        new MappingJackson2HttpMessageConverter(mapper))
        .build();
	}

  @Bean
  @Qualifier("restTemplateCustomCustomizer")
  public RestTemplateCustomCustomizer restTemplateCustomCustomizer() {
    return new RestTemplateCustomCustomizer();
  }

  @Bean
  @DependsOn(value = {"restTemplateCustomCustomizer"})
  public RestTemplateBuilder restTemplateBuilder() {
    return new RestTemplateBuilder(restTemplateCustomCustomizer());
  }
}
