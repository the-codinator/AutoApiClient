package org.codi.autoapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.codi.autoapi.credential.ClientCredentialProvider;

@Value
@Builder
public class ApiClientConfig {

    @NonNull String baseUrl;
    String contentType;
    ObjectMapper mapper;
    Map<String, String> defaultHeaders;
    ClientCredentialProvider credential;
    ClientRetryConfig retry;
    ClientCircuitBreakerConfig circuitBreaker;
}
