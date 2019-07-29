package de.felixklauke.portum.protocol.model;

public class Vote {

  private final String username;
  private final String service;
  private final String timestamp;
  private final String address;

  public Vote(String username, String service, String timestamp, String address) {
    this.username = username;
    this.service = service;
    this.timestamp = timestamp;
    this.address = address;
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
