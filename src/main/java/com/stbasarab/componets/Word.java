package com.stbasarab.componets;

/**
 * Represents a word as an array of letters.
 * This class provides methods to compare words and convert them to a string.
 */
public class Word {

    /** The array of letters that make up the word. */
    private final Letter[] letters;

    /**
     * Constructs a Word object from a given string.
     *
     * @param word the string representation of the word
     */
    public Word(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    /**
     * Compares this word to another object for equality.
     * Two words are considered equal if their string representations are the same,
     * ignoring case.
     *
     * @param obj the object to compare this word against
     * @return true if the given object is equivalent to this word; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Word word = (Word) obj;
        String thisValue = this.toString().toLowerCase();
        String otherValue = word.toString().toLowerCase();
        return thisValue.equals(otherValue);
    }

    /**
     * Returns a hash code value for the word.
     * The hash code is computed from the string representation of the word, ignoring case.
     *
     * @return a hash code value for this word
     */
    @Override
    public int hashCode() {
        return toString().toLowerCase().hashCode();
    }

    /**
     * Returns the string representation of the word.
     *
     * @return the string representation of the word
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Letter letter : letters) {
            result.append(letter.getCharacter());
        }
        return result.toString();
    }
}
