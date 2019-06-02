package de.felixklauke.portum.server.config;

import java.security.KeyPair;

public class PortumServerConfig {

    private final String host;
    private final int port;
    private final KeyPair keyPair;

    public PortumServerConfig(String host, int port, KeyPair keyPair) {
        this.host = host;
        this.port = port;
        this.keyPair = keyPair;
    }

    public KeyPair getKeyPair() {
        return keyPair;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
