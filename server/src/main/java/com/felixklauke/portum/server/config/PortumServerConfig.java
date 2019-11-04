package com.felixklauke.portum.server.config;

import com.felixklauke.portum.protocol.listener.VoteListener;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.security.KeyPair;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class PortumServerConfig {

  private final Logger logger = Logger.getLogger(PortumServerConfig.class.getSimpleName());

  private final List<VoteListener> listeners;
  private final String host;
  private final int port;
  private final KeyPair keyPair;

  PortumServerConfig(List<VoteListener> listeners, String host, int port, KeyPair keyPair) {
    Objects.requireNonNull(listeners, "Listeners cannot be null.");
    Objects.requireNonNull(host, "Host cannot be null.");
    Objects.requireNonNull(keyPair, "Key Pair cannot be null.");

    // Warn on empty listeners
    if (listeners.size() == 0) {
      logger.warning(
        "You didn't specify any listeners at the starting. Ensure to register some later on!");
    }

    this.listeners = new CopyOnWriteArrayList<>(listeners);
    this.host = host;
    this.port = port;
    this.keyPair = keyPair;
  }

  public static Builder newBuilder() {
    return new Builder(Lists.newArrayList(), "localhost", 0, null);
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

  public static class Builder {
    private List<VoteListener> listeners;
    private String host;
    private int port;
    private KeyPair keyPair;

    private Builder(List<VoteListener> listeners, String host, int port,
        KeyPair keyPair) {
      this.listeners = listeners;
      this.host = host;
      this.port = port;
      this.keyPair = keyPair;
    }

    public Builder withListeners(List<VoteListener> listeners) {
      Preconditions.checkNotNull(listeners);
      this.listeners = listeners;
      return this;
    }

    public Builder withHost(String host) {
      Preconditions.checkNotNull(host);
      this.host = host;
      return this;
    }

    public Builder withPort(int port) {
      Preconditions.checkState(port >= 0  && port <= 65535, "Port not in range");
      this.port = port;
      return this;
    }

    public Builder withKeyPair(KeyPair keyPair) {
      Preconditions.checkNotNull(keyPair);
      this.keyPair = keyPair;
      return this;
    }

    public PortumServerConfig build() {
      Preconditions.checkNotNull(listeners);
      Preconditions.checkNotNull(host);
      Preconditions.checkState(port >= 0  && port <= 65535, "Port not in range");
      Preconditions.checkNotNull(keyPair);
      return new PortumServerConfig(listeners, host, port, keyPair);
    }
  }
}
