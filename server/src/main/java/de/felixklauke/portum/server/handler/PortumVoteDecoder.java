package de.felixklauke.portum.server.handler;

import de.felixklauke.portum.protocol.model.Vote;
import de.felixklauke.portum.protocol.parser.VoteParser;
import de.felixklauke.portum.server.config.PortumServerConfig;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class PortumVoteDecoder extends ByteToMessageDecoder {

  private static final String CIPHER = "RSA";
  private static final int MESSAGE_SIZE = 256;

  private final PortumServerConfig serverConfig;

  PortumVoteDecoder(PortumServerConfig serverConfig) {
    this.serverConfig = serverConfig;
  }

  @Override
  protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf,
      List<Object> list) {

    // Check message size
    int readableBytes = byteBuf.readableBytes();
    if (readableBytes != 256) {
      throw new IllegalStateException(
          "Message size of v1 payloads has to be " + MESSAGE_SIZE + " bytes.");
    }

    // Read message into array
    byte[] bytes = new byte[MESSAGE_SIZE];
    byteBuf.readBytes(bytes);

    // Decrypt message
    bytes = decrypt(bytes);

    // Parse Vote
    String string = new String(bytes);
    Vote vote = VoteParser.parseVote(string);

    list.add(vote);
  }

  /**
   * Decrypt the given bytes.
   *
   * @param bytes The bytes.
   * @return The decrypted data.
   */
  private byte[] decrypt(byte[] bytes) {

    Cipher cipher;
    try {
      cipher = Cipher.getInstance(CIPHER);
      cipher.init(Cipher.DECRYPT_MODE, serverConfig.getKeyPair().getPrivate());
    } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
      throw new IllegalStateException("Couldn't get cipher.", e);
    } catch (InvalidKeyException e) {
      throw new IllegalStateException("Key is invalid", e);
    }

    try {
      return cipher.doFinal(bytes);
    } catch (IllegalBlockSizeException | BadPaddingException e) {
      throw new IllegalStateException("Error during decrption.", e);
    }
  }
}
