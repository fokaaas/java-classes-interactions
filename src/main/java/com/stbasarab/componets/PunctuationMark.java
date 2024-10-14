package com.stbasarab.componets;

public class PunctuationMark {
    private final char mark;

    public PunctuationMark(char mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PunctuationMark that = (PunctuationMark) obj;
        return mark == that.mark;
    }

    @Override
    public int hashCode() {
        return Character.hashCode(mark);
    }
}
