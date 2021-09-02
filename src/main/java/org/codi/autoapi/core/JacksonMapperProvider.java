package org.codi.autoapi.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.module.blackbird.BlackbirdModule;
import lombok.Getter;
import org.codi.autoapi.config.ApiClientConfig;

public final class JacksonMapperProvider {

    private ObjectMapper instance;

    /**
     * Builder available to custom default Jackson Mapper instantiation
     */
    @Getter
    private static final JsonMapper.Builder defaultMapperBuilder = JsonMapper.builder()
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .enable(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)
        .enable(MapperFeature.BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES)
        .serializationInclusion(JsonInclude.Include.NON_NULL)
        .addModule(new BlackbirdModule());

    /**
     * Eagerly initialize Jackson Mapper with current configuration
     */
    public synchronized void initialize() {
        ensureUninitialized();
        instance = defaultMapperBuilder.build();
    }

    /**
     * Eagerly initialize Jackson Mapper with a clone of {@param mapper} to avoid modifications later on
     *
     * Note: If you want to use a shared Mapper, then provide it via the {@link ApiClientConfig} instead
     */
    public synchronized void initialize(ObjectMapper mapper) {
        ensureUninitialized();
        instance = mapper.copy();
    }

    synchronized ObjectMapper getInstance() {
        if (instance == null) {
            initialize();
        }
        return instance;
    }

    private synchronized void ensureUninitialized() {
        if (instance != null) {
            throw new RuntimeException(
                "Attempting to configure Auto Api's Jackson Mapper after it has been initialized");
        }
    }
}
