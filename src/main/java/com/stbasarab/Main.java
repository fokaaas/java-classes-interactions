package com.stbasarab;

import com.stbasarab.componets.Sentence;
import com.stbasarab.componets.SentenceElement;
import com.stbasarab.componets.Text;
import com.stbasarab.componets.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * The main class that handles the execution of the program.
 * It reads a text file, processes the text to find unique words in the first sentence,
 * and prints the result to the console.
 */
public class Main {

    /**
     * The entry point of the application.
     *
     * @param args command-line arguments (not used)
     * @throws RuntimeException if there is an error reading the file or finding the unique word
     */
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

    /**
     * Finds the first unique word in the first sentence of the given text.
     *
     * @param text the Text object containing the sentences
     * @return the first unique Word found in the first sentence
     * @throws RuntimeException if there are no sentences or if no unique word is found
     */
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

    /**
     * Checks if the specified sentence element is unique in the context of other sentence elements.
     *
     * @param element the SentenceElement to check for uniqueness
     * @param otherSentenceElements the array of other SentenceElements to compare against
     * @return true if the element is unique; false otherwise
     */
    private static boolean isUniqueInOtherSentences(SentenceElement element, SentenceElement[] otherSentenceElements) {
        for (SentenceElement other : otherSentenceElements) {
            if (element.equals(other)) return false;
        }
        return true;
    }

    /**
     * Checks if the provided text contains any sentences.
     *
     * @param text the Text object to check
     * @return true if there are no sentences; false otherwise
     */
    private static boolean isEmptyText(Text text) {
        Sentence[] sentences = text.getSentences();
        return Objects.equals(sentences[0].getElements()[0].getWord().toString(), "");
    }
}
