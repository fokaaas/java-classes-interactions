package com.stbasarab.componets;

public class SentenceElement {
    private Word word;
    private PunctuationMark punctuationMark;

    public SentenceElement(Word word) {
        this.word = word;
    }

    public SentenceElement(PunctuationMark punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    public boolean isWord() {
        return word != null;
    }

    public Word getWord() {
        return word;
    }

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

    @Override
    public int hashCode() {
        return isWord() ? word.hashCode() : (punctuationMark != null ? punctuationMark.hashCode() : 0);
    }
}
