package com.felixklauke.portum.server;

import com.felixklauke.portum.protocol.listener.VoteListener;
import com.google.common.util.concurrent.ListenableFuture;

public interface PortumServer {

  ListenableFuture<Void> start();

  ListenableFuture<Void> stop();

  void registerVoteListener(VoteListener voteListener);
}
