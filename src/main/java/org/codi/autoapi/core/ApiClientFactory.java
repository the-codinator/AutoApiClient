package org.codi.autoapi.core;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.codi.autoapi.config.ApiClientConfig;
import org.codi.autoapi.impl.RetryAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiClientFactory {

    /**
     * Jackson's ObjectMapper builder available for customizations
     */
    private static final JacksonMapperProvider jsonMapperProvider = new JacksonMapperProvider();

    private final Retrofit retrofit;

    public static ApiClientFactory createFactory(@NonNull ApiClientConfig config) {
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(config.getBaseUrl()).validateEagerly(true);

        // Converter for serialization & deserialization
        builder.addConverterFactory(ScalarsConverterFactory.create());
        JacksonConverterFactory jacksonFactory = JacksonConverterFactory.create(
            config.getMapper() == null ? jsonMapperProvider.getInstance() : config.getMapper());
        builder.addConverterFactory(jacksonFactory);

        // User provided custom http client
        if (config.getHttpClient() != null) {
            builder.client(config.getHttpClient());
        }

        // Retry adapter
        if (config.getRetry() != null) {
            builder.addCallAdapterFactory(RetryAdapterFactory.create(config.getRetry()));
        }

        // Factory
        return new ApiClientFactory(builder.build());
    }

    private <T> T createApiClient(Class<T> apiInterface) {
        return retrofit.create(apiInterface);
    }
}
