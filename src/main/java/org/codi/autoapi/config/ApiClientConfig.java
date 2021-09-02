package org.codi.autoapi.config;

import java.util.Map;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.codi.autoapi.credential.ClientCredentialProvider;

@Value
@Builder
public class ApiClientConfig {

    String baseUrl;
    String contentType;
    Map<String, String> defaultHeaders;
    ClientCredentialProvider credential;
    ClientRetryConfig retry;
    ClientCircuitBreakerConfig circuitBreaker;
}
