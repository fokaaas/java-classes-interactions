package com.stbasarab.componets;

/**
 * Represents a collection of sentences derived from a given text.
 * This class provides methods to construct a text object from a string and retrieve its sentences.
 */
public class Text {

    /** The array of sentences that make up the text. */
    private final Sentence[] sentences;

    /**
     * Constructs a Text object from a given string.
     * The string is split into sentences based on punctuation marks followed by whitespace.
     *
     * @param text the string representation of the text
     */
    public Text(String text) {
        String[] splitSentences = text.trim().split("(?<=[.!?]|\\.\\.\\.)\\s+");
        sentences = new Sentence[splitSentences.length];
        for (int i = 0; i < splitSentences.length; i++) {
            sentences[i] = new Sentence(splitSentences[i]);
        }
    }

    /**
     * Retrieves the sentences of the text.
     *
     * @return an array of Sentence objects that make up the text
     */
    public Sentence[] getSentences() {
        return sentences;
    }
}
