package de.felixklauke.portum.server.config;

import java.security.KeyPair;

public class PortumServerConfig {

    private final KeyPair keyPair;

    public PortumServerConfig(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    public KeyPair getKeyPair() {
        return keyPair;
    }
}
