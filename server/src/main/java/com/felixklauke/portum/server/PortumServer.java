package com.felixklauke.portum.server;

import com.google.common.util.concurrent.ListenableFuture;
import com.felixklauke.portum.protocol.listener.VoteListener;

public interface PortumServer {

  ListenableFuture<Void> start();

  ListenableFuture<Void> stop();

  void registerVoteListener(VoteListener voteListener);
}
