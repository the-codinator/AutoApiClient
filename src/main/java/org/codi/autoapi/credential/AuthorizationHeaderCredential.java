package org.codi.autoapi.credential;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class AuthorizationHeaderCredential implements ClientCredentialProvider {

    private final ClientCredentialType type = ClientCredentialType.header;
    private final String key = "Authorization";
    private final String tokenType;

    public final String getValue() {
        return String.format("%s %s", tokenType, getToken());
    }

    public abstract String getToken();
}
