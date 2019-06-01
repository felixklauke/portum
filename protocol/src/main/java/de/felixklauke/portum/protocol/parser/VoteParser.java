package de.felixklauke.portum.protocol.parser;

import de.felixklauke.portum.protocol.model.Vote;

import java.util.StringTokenizer;

public class VoteParser {

    private static final String DELIMITER = "\n";

    /**
     * Parse a vote from a string.
     *
     * @param string The serialized vote.
     * @return The vote model.
     */
    public static Vote parseVote(String string) {


        return new Vote("", "", "", "");
    }
}
