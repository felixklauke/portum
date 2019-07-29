package com.felixklauke.portum.server.config;

import com.felixklauke.portum.protocol.listener.VoteListener;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

public class PortumServerConfigBuilder {

  private List<VoteListener> listeners = new ArrayList<>();
  private String host = "127.0.0.1";
  private int port = 8192;
  private KeyPair keyPair;

  PortumServerConfigBuilder() {
  }

  public PortumServerConfigBuilder addListener(VoteListener voteListener) {
    listeners.add(voteListener);
    return this;
  }

  public PortumServerConfigBuilder setListeners(List<VoteListener> listeners) {
    this.listeners = listeners;
    return this;
  }

  public PortumServerConfigBuilder setHost(String host) {
    this.host = host;
    return this;
  }

  public PortumServerConfigBuilder setPort(int port) {
    this.port = port;
    return this;
  }

  public PortumServerConfigBuilder setKeyPair(KeyPair keyPair) {
    this.keyPair = keyPair;
    return this;
  }

  public PortumServerConfig createPortumServerConfig() {
    return new PortumServerConfig(listeners, host, port, keyPair);
  }
}
