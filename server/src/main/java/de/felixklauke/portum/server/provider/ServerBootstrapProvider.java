package de.felixklauke.portum.server.provider;

import de.d3adspace.constrictor.netty.NettyUtils;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import javax.inject.Inject;
import javax.inject.Provider;

public class ServerBootstrapProvider implements Provider<ServerBootstrap> {

  private final ChannelInitializer<SocketChannel> channelInitializer;

  @Inject
  public ServerBootstrapProvider(ChannelInitializer<SocketChannel> channelInitializer) {
    this.channelInitializer = channelInitializer;
  }

  @Override
  public ServerBootstrap get() {

    // Create event loops
    EventLoopGroup bossGroup = NettyUtils.createBossGroup(1);
    EventLoopGroup workerGroup = NettyUtils.createWorkerGroup(4);

    // Create Server socket channels
    Class<? extends ServerSocketChannel> serverSocketChannel = NettyUtils.getServerSocketChannel();

    // Construct server bootstrap
    return new ServerBootstrap()
        .group(bossGroup, workerGroup)
        .childHandler(channelInitializer)
        .childOption(ChannelOption.TCP_NODELAY, true)
        .channel(serverSocketChannel);
  }
}
