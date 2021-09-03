package org.codi.autoapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import okhttp3.OkHttpClient;
import org.codi.autoapi.credential.ClientCredentialProvider;

@Value
@Builder
public class ApiClientConfig {

    /**
     * API base URL (mandatory)
     */
    @NonNull String baseUrl;

    /**
     * Optional Content Type to include in every request
     */
    String contentType;

    /**
     * Optional Jackson mapper to override default internal mapper (useful if you want to customize and use a shared
     * instance)
     */
    ObjectMapper mapper;

    /**
     * Optional Http client to override default generated instance (useful if you want to fine tune its configuration)
     */
    OkHttpClient httpClient;

    /**
     * Optional default headers to include with every request
     */
    Map<String, String> defaultHeaders;

    /**
     * Optional credential provider to include with every request for authentication
     */
    ClientCredentialProvider credential;

    /**
     * Optional automatic retry configuration
     */
    ClientRetryConfig retry;

    /**
     * Optional circuit breaking configuration
     */
    ClientCircuitBreakerConfig circuitBreaker;
}
