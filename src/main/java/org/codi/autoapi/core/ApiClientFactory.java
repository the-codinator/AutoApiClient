package org.codi.autoapi.core;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.codi.autoapi.config.ApiClientConfig;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiClientFactory {

    /**
     * Jackson's ObjectMapper builder available for customizations
     */
    private static final JacksonMapperProvider jsonMapperProvider = new JacksonMapperProvider();

    private final Retrofit retrofit;

    public static ApiClientFactory createFactory(@NonNull ApiClientConfig config) {
        JacksonConverterFactory jacksonFactory = JacksonConverterFactory.create(
            config.getMapper() == null ? jsonMapperProvider.getInstance() : config.getMapper());

        Retrofit retrofit = new Retrofit.Builder().baseUrl(config.getBaseUrl())
            .addConverterFactory(jacksonFactory)
            .build();
        return new ApiClientFactory(retrofit);
    }

    private <T> T createApiClient(Class<T> apiInterface) {
        return retrofit.create(apiInterface);
    }
}
