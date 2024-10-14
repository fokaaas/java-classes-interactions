package com.stbasarab;

import com.stbasarab.componets.Sentence;
import com.stbasarab.componets.SentenceElement;
import com.stbasarab.componets.Text;
import com.stbasarab.componets.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws RuntimeException {
        String line;
        try {
            line = new String(Files.readAllBytes(Paths.get("text.txt")));
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + e.getMessage());
        }

        Text text = new Text(line);

        try {
            Word uniqueWord = findUniqueWordInFirstSentence(text);
            System.out.println("The first unique word in the text is: " + uniqueWord);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error finding unique word: " + e.getMessage());
        }
    }

    public static Word findUniqueWordInFirstSentence(Text text) {
        if (isEmptyText(text)) {
            throw new RuntimeException("No sentences found in the text.");
        }
        Sentence[] sentences = text.getSentences();

        SentenceElement[] firstSentenceElements = sentences[0].getElements();

        int totalOtherElements = 0;
        for (int i = 1; i < sentences.length; i++) {
            totalOtherElements += sentences[i].getElements().length;
        }

        if (totalOtherElements == 0) throw new RuntimeException("There are no other sentences to compare.");

        SentenceElement[] otherSentenceElements = new SentenceElement[totalOtherElements];
        int index = 0;
        for (int i = 1; i < sentences.length; i++) {
            for (SentenceElement element : sentences[i].getElements()) {
                otherSentenceElements[index++] = element;
            }
        }
        for (SentenceElement element : firstSentenceElements) {
            if (isUniqueInOtherSentences(element, otherSentenceElements)) {
                return element.getWord();
            }
        }
        throw new RuntimeException("No unique word found");
    }

    private static boolean isUniqueInOtherSentences (SentenceElement element, SentenceElement[] otherSentenceElements) {
        for (SentenceElement other : otherSentenceElements) {
            if (element.equals(other)) return false;
        }
        return true;
    }

    private static boolean isEmptyText(Text text) {
        Sentence[] sentences = text.getSentences();
        return Objects.equals(sentences[0].getElements()[0].getWord().toString(), "");
    }
}