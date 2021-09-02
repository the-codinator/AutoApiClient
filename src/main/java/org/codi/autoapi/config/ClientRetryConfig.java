package org.codi.autoapi.config;

import java.util.Set;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;
import lombok.With;

@Value
@With
@Builder
public class ClientRetryConfig {

    private static final ClientRetryConfig none = ClientRetryConfig.builder().build();
    private static final ClientRetryConfig basic = ClientRetryConfig.builder()
        .maxRetries(1)
        .delay(1000)
        .retryableStatus(429)
        .retryableStatus(502)
        .retryableStatus(503)
        .retryableStatus(504)
        .build();
    private static final ClientRetryConfig recommended = ClientRetryConfig.builder()
        .maxRetries(2)
        .delay(500)
        .maxDelay(Integer.MAX_VALUE)
        .retryableStatus(429)
        .retryableStatus(502)
        .retryableStatus(503)
        .retryableStatus(504)
        .build();

    /**
     * Maximum number of retries after first attempt
     *
     * Non-positive values disable retry
     */
    int maxRetries;

    /**
     * Delay between 2 attempts in milliseconds
     *
     * Non-positive values disable delay
     */
    int delay;

    /**
     * Maximum delay in milliseconds between any 2 attempts
     *
     * Positive values automatically enable exponential backoff, starting from {@link #getDelay()}
     */
    int maxDelay;

    /**
     * Http status codes to perform retries on
     *
     * Empty set indicates no retry
     */
    @Singular
    @NonNull Set<Integer> retryableStatuses;
}
