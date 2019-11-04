package com.felixklauke.portum.server.handler;

import com.felixklauke.portum.server.config.PortumServerConfig;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import javax.inject.Inject;

public class PortumChannelInitializer extends ChannelInitializer<SocketChannel> {

  private final PortumProtocolHandler protocolHandler;
  private final PortumServerConfig serverConfig;

  @Inject
  public PortumChannelInitializer(PortumProtocolHandler protocolHandler,
    PortumServerConfig serverConfig) {
    this.protocolHandler = protocolHandler;
    this.serverConfig = serverConfig;
  }

  @Override
  protected void initChannel(SocketChannel socketChannel) throws Exception {
    ChannelPipeline pipeline = socketChannel.pipeline();

    pipeline.addLast("protocolHandler", protocolHandler);
    pipeline.addLast("voteDecoder", new PortumVoteDecoder(serverConfig));
    pipeline.addLast("voteHandler", new PortumVoteHandler(serverConfig));
  }
}
