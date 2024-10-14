package com.stbasarab.componets;

public class Word {
    private final Letter[] letters;

    public Word(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Word word = (Word) obj;
        String thisValue = this.toString().toLowerCase();
        String otherValue = word.toString().toLowerCase();
        return thisValue.equals(otherValue);
    }

    @Override
    public int hashCode() {
        return toString().toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Letter letter : letters) {
            result.append(letter.getCharacter());
        }
        return result.toString();
    }
}
