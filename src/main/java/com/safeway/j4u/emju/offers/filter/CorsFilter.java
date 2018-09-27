package com.safeway.j4u.emju.offers.filter;

import com.safeway.j4u.emju.offers.util.OffersConstants;
import java.time.Instant;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class CorsFilter implements WebFilter {
 
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain chain) {
        serverWebExchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "*");
        serverWebExchange.getResponse().getHeaders().add("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
        serverWebExchange.getResponse().getHeaders().set(HttpHeaders.LAST_MODIFIED, Instant.now().toString());
        serverWebExchange.getResponse().getHeaders().set(HttpHeaders.CACHE_CONTROL, OffersConstants.NO_CACHE);
        return chain.filter(serverWebExchange);
    }
}