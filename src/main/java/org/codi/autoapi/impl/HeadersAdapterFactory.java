package org.codi.autoapi.impl;

import java.util.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.codi.autoapi.credential.ClientCredentialProvider;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HeadersAdapterFactory {

    public static HeadersAdapterFactory create(Map<String, String> defaultHeaders,
        ClientCredentialProvider credentialProvider) {
        if (defaultHeaders == null && credentialProvider == null) {
            return null;
        }
        return new HeadersAdapterFactory();
    }
}
