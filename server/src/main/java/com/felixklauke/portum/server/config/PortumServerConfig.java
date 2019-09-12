package com.felixklauke.portum.server.config;

import com.felixklauke.portum.protocol.listener.VoteListener;
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

  public static PortumServerConfigBuilder createBuilder() {

    return new PortumServerConfigBuilder();
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
