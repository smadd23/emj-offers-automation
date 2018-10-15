package com.safeway.j4u.emju.offers.filter;

import static com.safeway.j4u.emju.offers.util.OffersConstants.APPLICATION_VND_SAFEWAY_V1_JSON;
import static java.lang.String.format;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.okta.jwt.JoseException;
import com.okta.jwt.Jwt;
import com.okta.jwt.JwtVerifier;
import com.safeway.j4u.emju.offers.exception.handler.ApiError;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
//@Component
public class OktaFilter implements WebFilter {

    @Value("${okta.read}")
    private String oktaReadRole;

    @Value("${okta.write}")
    private String oktaWriteRole;

    private static final Pattern PATTERN = Pattern.compile("^Bearer *([^ ]+) *$", Pattern.CASE_INSENSITIVE);
    private static final String WRONG_TOKEN_MESSAGE = "Wrong token";
    private static final String ERROR_DECODING_TOKEN = "Cannot decode access token";
    private static final String UNPARSEABLE = "{\"error\":\"json parse error\"}";

    @Autowired
    private JwtVerifier jwtVerifier;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     *
     *  Main method is an object that performs filtering tasks on the request to a resource.
     *
     * @param serverWebExchange
     * @param webFilterChain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        String authorizationHeaderValue =
                serverWebExchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        Jwt jwt = null;
        if (StringUtils.isNotBlank(authorizationHeaderValue)) {
            Matcher matcher = PATTERN.matcher(authorizationHeaderValue);
            if (!matcher.matches()) {
                String message = format("Authorization header value ('%s') does not match expected pattern - '%s'",
                                        authorizationHeaderValue, PATTERN.toString());
                return invalidAuthorizationHeaderResponse(serverWebExchange, message, ERROR_DECODING_TOKEN);
            }
            try {
                String accessToken = matcher.group(1);
                jwt = jwtVerifier.decodeAccessToken(accessToken);
            } catch (JoseException e) {
                String message = "The request requires user authentication.";
                return invalidAuthorizationHeaderResponse(serverWebExchange, message, ERROR_DECODING_TOKEN);
            }
        }
        Map<String, Object> claims = jwt.getClaims();
        if (serverWebExchange.getRequest().getMethod().equals(HttpMethod.GET)) {
            return webFilterChain.filter(serverWebExchange);
        } else if (claims.containsKey("jpr") && claims.get("jpr").toString().contains(oktaWriteRole) &&
                (serverWebExchange.getRequest().getMethod().equals(HttpMethod.POST) ||
                (serverWebExchange.getRequest().getMethod().equals(HttpMethod.PUT)))) {
            return webFilterChain.filter(serverWebExchange);
        } else {
            return invalidAuthorizationHeaderResponse(serverWebExchange, WRONG_TOKEN_MESSAGE, WRONG_TOKEN_MESSAGE);
        }
    }

    private Mono<Void> invalidAuthorizationHeaderResponse(ServerWebExchange serverWebExchange, String message, String error)  {
        ApiError apiError = new ApiError(UNAUTHORIZED, message, error);
        serverWebExchange.getResponse().setStatusCode(UNAUTHORIZED);
        serverWebExchange.getResponse().getHeaders().set(CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON);
        byte[] errorMessage = UNPARSEABLE.getBytes();
        try {
            errorMessage = objectMapper.writeValueAsBytes(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, message, error));
        } catch (JsonProcessingException e) {}
        return serverWebExchange.getResponse().writeWith(Mono.just(new DefaultDataBufferFactory().wrap(errorMessage)));
    }
}