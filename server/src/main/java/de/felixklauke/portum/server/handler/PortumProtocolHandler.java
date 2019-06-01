package de.felixklauke.portum.server.handler;

import de.felixklauke.portum.protocol.version.ProtocolVersion;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class PortumProtocolHandler extends ChannelInboundHandlerAdapter {

    /**
     * The handshake protocol prefix.
     */
    private static final String PROTOCOL_PREFIX = "Votifier ";

    @Override
    public void channelActive(ChannelHandlerContext ctx) {

        // Obtain channel
        Channel channel = ctx.channel();

        // Send handshake
        sendHandshake(channel, ProtocolVersion.V1);
    }

    /**
     * Send a handshake for the given protocol version.
     *
     * @param channel The channel.
     * @param protocolVersion The protocol version.
     */
    private void sendHandshake(Channel channel, ProtocolVersion protocolVersion) {

        if (protocolVersion == ProtocolVersion.V1) {
            channel.writeAndFlush(PROTOCOL_PREFIX + "1.0");
        }
    }
}
