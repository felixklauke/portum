package de.felixklauke.portum.server.handler;

import de.felixklauke.portum.protocol.model.Vote;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class PortumVoteHandler extends SimpleChannelInboundHandler<Vote> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Vote vote) throws Exception {

    }
}
