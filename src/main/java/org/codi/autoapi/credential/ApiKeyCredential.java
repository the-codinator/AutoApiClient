package org.codi.autoapi.credential;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiKeyCredential implements ClientCredentialProvider {

    private final ClientCredentialType type = ClientCredentialType.query;
    private final String key;
    private final String value;

    public ApiKeyCredential(String apiKey) {
        this("api_key", apiKey);
    }
}
