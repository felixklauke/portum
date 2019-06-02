package de.felixklauke.portum.server.config;

import de.felixklauke.portum.protocol.listener.VoteListener;

import java.security.KeyPair;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PortumServerConfig {

    private final List<VoteListener> listeners;
    private final String host;
    private final int port;
    private final KeyPair keyPair;

    public PortumServerConfig(List<VoteListener> listeners, String host, int port, KeyPair keyPair) {
        this.listeners = new CopyOnWriteArrayList<>(listeners);
        this.host = host;
        this.port = port;
        this.keyPair = keyPair;
    }

    public List<VoteListener> getListeners() {
        return listeners;
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
