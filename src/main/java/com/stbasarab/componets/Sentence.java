package com.stbasarab.componets;

/**
 * Represents a sentence composed of various elements, including words and punctuation marks.
 * This class provides methods to construct a sentence from a string and retrieve its elements.
 */
public class Sentence {

    /** The array of elements that make up the sentence. */
    private final SentenceElement[] elements;

    /**
     * Constructs a Sentence object from a given string.
     * The string is normalized by replacing multiple whitespace characters with a single space,
     * and is then split into words and punctuation marks.
     *
     * @param sentence the string representation of the sentence
     */
    public Sentence(String sentence) {
        String normalizedSentence = sentence.replaceAll("\\s+", " ").trim();
        String[] splitParts = normalizedSentence.trim().split("(?<=\\W)(?=\\s)|(?<=\\W)(?=[,.!?;:—]|\\.\\.\\.)");

        elements = new SentenceElement[splitParts.length];

        for (int i = 0; i < splitParts.length; i++) {
            String part = splitParts[i].trim();
            if (part.matches(".*[ ,.!?;:—]|\\.\\.\\..*")) {
                elements[i] = new SentenceElement(new PunctuationMark(part.charAt(0)));
            } else {
                elements[i] = new SentenceElement(new Word(part));
            }
        }
    }

    /**
     * Retrieves the elements of the sentence.
     *
     * @return an array of SentenceElement objects that make up the sentence
     */
    public SentenceElement[] getElements() {
        return elements;
    }
}
