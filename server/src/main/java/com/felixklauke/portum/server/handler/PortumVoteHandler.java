package com.felixklauke.portum.server.handler;

import com.felixklauke.portum.protocol.listener.VoteListener;
import com.felixklauke.portum.protocol.model.Vote;
import com.felixklauke.portum.server.config.PortumServerConfig;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.List;
import javax.inject.Inject;

public class PortumVoteHandler extends SimpleChannelInboundHandler<Vote> {

  private final PortumServerConfig serverConfig;

  @Inject
  public PortumVoteHandler(PortumServerConfig serverConfig) {
    this.serverConfig = serverConfig;
  }

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext, Vote vote)
    throws Exception {

    List<VoteListener> listeners = serverConfig.getListeners();
    listeners.forEach(listener -> listener.handleVote(vote));
  }
}
