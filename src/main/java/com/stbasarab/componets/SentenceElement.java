package com.stbasarab.componets;

/**
 * Represents an element of a sentence, which can be either a word or a punctuation mark.
 * This class provides methods to determine the type of element and to compare elements for equality.
 */
public class SentenceElement {

    /** The word component of the sentence element, if applicable. */
    private Word word;

    /** The punctuation mark component of the sentence element, if applicable. */
    private PunctuationMark punctuationMark;

    /**
     * Constructs a SentenceElement object with a word.
     *
     * @param word the word that this sentence element represents
     */
    public SentenceElement(Word word) {
        this.word = word;
    }

    /**
     * Constructs a SentenceElement object with a punctuation mark.
     *
     * @param punctuationMark the punctuation mark that this sentence element represents
     */
    public SentenceElement(PunctuationMark punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    /**
     * Checks if this sentence element is a word.
     *
     * @return true if this element is a word; false otherwise
     */
    public boolean isWord() {
        return word != null;
    }

    /**
     * Retrieves the word component of this sentence element.
     *
     * @return the word, or null if this element is not a word
     */
    public Word getWord() {
        return word;
    }

    /**
     * Compares this sentence element to another object for equality.
     * Two sentence elements are considered equal if both are words and are equal,
     * or if both are punctuation marks and are equal.
     *
     * @param obj the object to compare this sentence element against
     * @return true if the given object is equivalent to this sentence element; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SentenceElement that = (SentenceElement) obj;
        if (this.isWord() && that.isWord()) {
            return this.word.equals(that.word);
        }
        if (!this.isWord() && !that.isWord()) {
            return this.punctuationMark.equals(that.punctuationMark);
        }
        return false;
    }

    /**
     * Returns a hash code value for the sentence element.
     *
     * @return a hash code value for this sentence element
     */
    @Override
    public int hashCode() {
        return isWord() ? word.hashCode() : (punctuationMark != null ? punctuationMark.hashCode() : 0);
    }
}
