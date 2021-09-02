package org.codi.autoapi.credential;

import java.util.Base64;
import java.util.function.Supplier;
import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthorizationHeaderCredentialFactory {

    @Getter
    private static class AuthorizationHeaderCredentialImpl extends AuthorizationHeaderCredential {

        private final Supplier<String> tokenSupplier;

        private AuthorizationHeaderCredentialImpl(String tokenType, Supplier<String> tokenSupplier) {
            super(tokenType);
            this.tokenSupplier = tokenSupplier;
        }

        @Override
        public final String getToken() {
            return tokenSupplier.get();
        }
    }

    public AuthorizationHeaderCredential tokenCredential(String token) {
        return new AuthorizationHeaderCredentialImpl("token", () -> token);
    }

    public AuthorizationHeaderCredential basicCredential(String username, String password) {
        String token = Base64.getEncoder().encodeToString(String.format("%s:%s", username, password).getBytes());
        return new AuthorizationHeaderCredentialImpl("Basic", () -> token);
    }

    public AuthorizationHeaderCredential bearerCredential(Supplier<String> tokenProvider) {
        return new AuthorizationHeaderCredentialImpl("Bearer", tokenProvider);
    }
}
