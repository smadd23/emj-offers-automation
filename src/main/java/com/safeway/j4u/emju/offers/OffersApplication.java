package com.safeway.j4u.emju.offers;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class OffersApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(OffersApplication.class).web(WebApplicationType.REACTIVE).run(args);
	}
}
	