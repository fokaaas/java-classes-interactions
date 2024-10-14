package com.stbasarab.componets;

/**
 * Represents a single letter.
 * This class encapsulates a character and provides access to it.
 */
public class Letter {

    /** The character representing the letter. */
    private final char character;

    /**
     * Constructs a Letter object.
     *
     * @param character the character representing the letter
     */
    public Letter(char character) {
        this.character = character;
    }

    /**
     * Retrieves the character of the letter.
     *
     * @return the character of the letter
     */
    public char getCharacter() {
        return character;
    }
}
