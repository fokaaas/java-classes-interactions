package com.stbasarab.componets;

/**
 * Represents a punctuation mark as a single character.
 * This class provides methods for equality comparison and hash code generation.
 */
public class PunctuationMark {

    /** The character representing the punctuation mark. */
    private final char mark;

    /**
     * Constructs a PunctuationMark object from a given character.
     *
     * @param mark the character representing the punctuation mark
     */
    public PunctuationMark(char mark) {
        this.mark = mark;
    }

    /**
     * Compares this punctuation mark to another object for equality.
     * Two punctuation marks are considered equal if their character values are the same.
     *
     * @param obj the object to compare this punctuation mark against
     * @return true if the given object is equivalent to this punctuation mark; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PunctuationMark that = (PunctuationMark) obj;
        return mark == that.mark;
    }

    /**
     * Returns a hash code value for the punctuation mark.
     *
     * @return a hash code value for this punctuation mark
     */
    @Override
    public int hashCode() {
        return Character.hashCode(mark);
    }
}
