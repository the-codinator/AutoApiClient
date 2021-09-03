package org.codi.autoapi.impl;

import io.github.resilience4j.retrofit.RetryCallAdapter;
import io.github.resilience4j.retry.Retry;
import org.codi.autoapi.config.ClientRetryConfig;

public class RetryAdapterFactory {
    // TODO: honor 429 response header - retry after
    // TODO: @ClientRetry annotation? override the call adapter factory, and override the "get" method to include what
    //  we need? (hijack with decorators)

    public static RetryCallAdapter create(ClientRetryConfig config) {
        return RetryCallAdapter.of(Retry.ofDefaults("auto-api-retry")); // TODO: configure
    }
}
