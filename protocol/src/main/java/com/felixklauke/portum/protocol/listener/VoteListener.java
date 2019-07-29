package com.felixklauke.portum.protocol.listener;

import com.felixklauke.portum.protocol.model.Vote;

public interface VoteListener {

  void handleVote(Vote vote);
}
