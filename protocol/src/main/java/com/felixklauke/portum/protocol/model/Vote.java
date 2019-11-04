package com.felixklauke.portum.protocol.model;

import java.util.StringTokenizer;

public class Vote {

  private final String username;
  private final String service;
  private final String timestamp;
  private final String address;

  private Vote(String username, String service, String timestamp, String address) {
    this.username = username;
    this.service = service;
    this.timestamp = timestamp;
    this.address = address;
  }

  /**
   * The delimiter of the vote string.
   */
  private static final String DELIMITER = "\n";

  /**
   * The vote integrity token to check decryption.
   */
  private static final String VOTE_INTEGRITY_TOKEN = "VOTE";

  /**
   * Parse a vote from a string.
   *
   * @param string The serialized vote.
   * @return The vote model.
   */
  public static Vote fromString(String string) {
    // Create tokenizer
    StringTokenizer tokenizer = new StringTokenizer(string, DELIMITER);

    // Check vote integrity token
    String voteToken = tokenizer.nextToken();
    if (!voteToken.equalsIgnoreCase(VOTE_INTEGRITY_TOKEN)) {
      throw new IllegalStateException("Failure during decryption. Couldn't confirm integrity.");
    }

    // Read service name, user name, address, timestamp
    String serviceName = tokenizer.nextToken();
    String userName = tokenizer.nextToken();
    String address = tokenizer.nextToken();
    String timestamp = tokenizer.nextToken();

    // Construct vote
    return new Vote(userName, serviceName, timestamp, address);
  }

  public String getUsername() {
    return username;
  }

  public String getService() {
    return service;
  }

  public String getAddress() {
    return address;
  }

  public String getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "Vote{" + "username='" + username + '\'' +
      ", service='" + service + '\'' +
      ", timestamp='" + timestamp + '\'' +
      ", address='" + address + '\'' +
      '}';
  }
}
