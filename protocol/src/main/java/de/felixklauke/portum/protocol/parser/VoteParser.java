package de.felixklauke.portum.protocol.parser;

import de.felixklauke.portum.protocol.model.Vote;

import java.util.StringTokenizer;

public class VoteParser {

    /**
     * The delimiter of the vote string.
     */
    private static final String DELIMITER = "\n";

    /**
     * The vote integrity token to check decryption.
     */
    private static final String VOTE_INTEGRITY_TOKEN = "";

    /**
     * Parse a vote from a string.
     *
     * @param string The serialized vote.
     * @return The vote model.
     */
    public static Vote parseVote(String string) {

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
}
