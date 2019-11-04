package com.felixklauke.portum.server.module;

import com.felixklauke.portum.server.PortumServer;
import com.felixklauke.portum.server.NettyPortumServer;
import com.felixklauke.portum.server.config.PortumServerConfig;
import com.felixklauke.portum.server.handler.PortumChannelInitializer;
import com.felixklauke.portum.server.handler.PortumProtocolHandler;
import com.felixklauke.portum.server.provider.ServerBootstrapProvider;
import com.google.common.base.Preconditions;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class PortumServerModule extends AbstractModule {

  private final PortumServerConfig serverConfig;

  private PortumServerModule(PortumServerConfig serverConfig) {
    this.serverConfig = serverConfig;
  }

  public static PortumServerModule withConfig(PortumServerConfig serverConfig) {
    Preconditions.checkNotNull(serverConfig);
    return new PortumServerModule(serverConfig);
  }

  @Override
  protected void configure() {
    bind(PortumServerConfig.class).toInstance(serverConfig);
    bind(PortumServer.class).to(NettyPortumServer.class);

    bind(ServerBootstrap.class).toProvider(ServerBootstrapProvider.class);
  }

  @Provides
  public ChannelInitializer<SocketChannel> provideServerChannelInitializer(
    PortumProtocolHandler protocolHandler, PortumServerConfig serverConfig) {
    return new PortumChannelInitializer(protocolHandler, serverConfig);
  }
}
