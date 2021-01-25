package task3.src.main.java.com.example.app;

import java.util.Objects;

class Word {
    private String word;
    private String firstLetter;

    public Word(String word) {
        this.word = word;
        this.firstLetter = word.substring(0, 1).toUpperCase();
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word) &&
                Objects.equals(firstLetter, word1.firstLetter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, firstLetter);
    }
}
