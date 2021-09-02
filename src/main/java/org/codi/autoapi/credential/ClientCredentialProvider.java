package org.codi.autoapi.credential;

public interface ClientCredentialProvider {

    ClientCredentialType getType();

    String getKey();

    String getValue();
}
