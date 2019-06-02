package de.felixklauke.portum.protocol.listener;

import de.felixklauke.portum.protocol.model.Vote;

public interface VoteListener {

    void handleVote(Vote vote);
}
