package de.felixklauke.portum.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class PortumVoteDecoder extends ByteToMessageDecoder {

    private static final int MESSAGE_SIZE = 256;

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

        // Check message size
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes != 256) {
            throw new IllegalStateException("Message size of v1 payloads has to be " + MESSAGE_SIZE + " bytes.");
        }

        // Read message into array
        byte[] bytes = new byte[MESSAGE_SIZE];
        byteBuf.readBytes(bytes);
     }
}
