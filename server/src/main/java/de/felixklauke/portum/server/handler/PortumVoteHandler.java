package de.felixklauke.portum.server.handler;

import de.felixklauke.portum.protocol.listener.VoteListener;
import de.felixklauke.portum.protocol.model.Vote;
import de.felixklauke.portum.server.config.PortumServerConfig;
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
