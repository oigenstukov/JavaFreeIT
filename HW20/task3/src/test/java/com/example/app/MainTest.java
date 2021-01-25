package task2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static task2.Main.*;

public class MainTest {

    @Test
    public void testRemovePunctuation() {
        String text = Main.text;
        String textWithoutPunctuation = "Once upon a time a Wolf was lapping at a spring on a hillside when looking " +
                "up what should he see but a Lamb just beginning to drink a little lower down";
        Assert.assertEquals(textWithoutPunctuation, Main.removePunctuation(text));
    }

    @Test
    public void testTextToLowerCase() {
        String text = Main.text;
        String textToLowerCase = "once upon a time a wolf was lapping at a spring on a hillside, when, looking " +
                "up, what should he see but a lamb just beginning to drink a little lower down.";
        Assert.assertEquals(textToLowerCase, textToLowerCase(text));
    }

    @Test
    public void testToStringArray() {
        String text = Main.text;
        String[] textArr = text.split("\\s+");
        Assert.assertArrayEquals(textArr, textToStringArray(text));
    }

    @Test
    public void testRemoveDuplicates() {
        String[] text = Main.text.replaceAll("[^A-z ]", "")
                .toLowerCase()
                .split("\\s+");

        Set<String> tempSet = new LinkedHashSet<>(Arrays.asList(text));
        String[] expected = tempSet.toArray(new String[0]);

        Assert.assertArrayEquals(expected, removeDuplicates(text));
    }

    @Test
    public void testStringToWord() {
        Word word = new Word("String");
        Assert.assertEquals(word, stringToWord("String"));
    }

    @Test
    public void testStringsToWords() {
        Word[] words = {new Word("a"), new Word("b")};
        String[] strings = {"a", "b"};
        Assert.assertArrayEquals(words, stringsToWords(strings));
    }

    @Test
    public void testGetWord() {
        Word w = new Word("a");
        Assert.assertEquals("a", w.getWord());
    }

    @Test
    public void testGetFirstLetter() {
        Word w = new Word("ab");
        Assert.assertEquals("A", w.getFirstLetter());
    }
}
