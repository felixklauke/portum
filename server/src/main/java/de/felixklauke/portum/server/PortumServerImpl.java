package de.felixklauke.portum.server;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.JdkFutureAdapters;
import com.google.common.util.concurrent.ListenableFuture;
import de.felixklauke.portum.protocol.listener.VoteListener;
import de.felixklauke.portum.server.config.PortumServerConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import java.util.List;
import javax.inject.Inject;

public class PortumServerImpl implements PortumServer {

  private final PortumServerConfig serverConfig;
  private final ServerBootstrap serverBootstrap;

  private Channel channel;

  @Inject
  PortumServerImpl(PortumServerConfig serverConfig, ServerBootstrap serverBootstrap) {
    this.serverConfig = serverConfig;
    this.serverBootstrap = serverBootstrap;
  }

  @Override
  public ListenableFuture<Void> start() {

    ChannelFuture channelFuture = serverBootstrap
        .bind(serverConfig.getHost(), serverConfig.getPort())
        .syncUninterruptibly();

    channelFuture.addListener((ChannelFutureListener) future -> {
      channel = future.channel();
    });

    return JdkFutureAdapters.listenInPoolThread(channelFuture);
  }

  @Override
  public ListenableFuture<Void> stop() {

    if (channel == null) {
      return Futures
          .immediateFailedFuture(new IllegalStateException("Can't stop a nun running server."));
    }

    channel.close();
    serverBootstrap.group().shutdownGracefully();
    serverBootstrap.childGroup().shutdownGracefully();

    return Futures.immediateFuture(null);
  }

  @Override
  public void registerVoteListener(VoteListener voteListener) {

    List<VoteListener> listeners = serverConfig.getListeners();
    listeners.add(voteListener);
  }
}
