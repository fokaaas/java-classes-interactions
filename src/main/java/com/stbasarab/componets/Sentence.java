package com.stbasarab.componets;

public class Sentence {
    private final SentenceElement[] elements;

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

    public SentenceElement[] getElements() {
        return elements;
    }
}