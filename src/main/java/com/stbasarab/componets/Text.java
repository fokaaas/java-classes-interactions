package com.stbasarab.componets;

public class Text {
    private final Sentence[] sentences;

    public Text(String text) {
        String[] splitSentences = text.trim().split("(?<=[.!?]|\\.\\.\\.)\\s+");
        sentences = new Sentence[splitSentences.length];
        for (int i = 0; i < splitSentences.length; i++) {
            sentences[i] = new Sentence(splitSentences[i]);
        }
    }

    public Sentence[] getSentences() {
        return sentences;
    }
}
