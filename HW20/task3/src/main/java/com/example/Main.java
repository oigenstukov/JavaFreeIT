package task2;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Программа принимает на вход английский текст, произвольной длины,
 * обрабатывает его и выводит все слова, которые встречаются в тексте (без
 * дубликатов) группируя их по первой букве в алфавитном порядке. Знаки
 * препинания игнорируются. Регистр заглавных букв не учитывается.
 */
public class Main {

    static Logger log = LoggerFactory.getLogger(Main.class.getName());
    static String text = "Once upon a time a Wolf was lapping at a spring on a hillside, when, looking " +
            "up, what should he see but a Lamb just beginning to drink a little lower down.";

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

//        wordsCountShort(textA);
        wordsCountStream(text);

    }

    // option 1
    public static void wordsCountShort(String text) {
        String[] words = text.replaceAll("[^A-z ]", "")
                .toLowerCase()
                .split("\\s+");
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] lettersArray = letters.split("");

        Map<String, Set<String>> allWords = new HashMap<>();
        Set<String> wordsOnLetter = new HashSet<>();
        for (String s : lettersArray) {
            for (String s1 : words) {
                if (s.equalsIgnoreCase(s1.substring(0, 1))) {
                    wordsOnLetter.add(s1);
                }
            }
            allWords.put(s, new HashSet<>(wordsOnLetter));
            wordsOnLetter.clear();
        }
        allWords.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    public static String removePunctuation(String s) {
        return s.replaceAll("[^A-z ]", "");
    }

    public static String textToLowerCase(String s) {
        return s.toLowerCase();
    }

    public static String[] textToStringArray(String s) {
        return s.split("\\s+");
    }

    public static String[] removeDuplicates(String[] s) {
        Set<String> tempSet = new LinkedHashSet<>(Arrays.asList(s));
        return tempSet.toArray(new String[0]);
    }

    public static Word stringToWord(String s) {
        return new Word(s);
    }

    public static Word[] stringsToWords(String[] s) {
        Word[] words = new Word[s.length];
        for (int i = 0; i < s.length; i++) {
            words[i] = stringToWord(s[i]);
        }
        return words;
    }
    // option 2
    public static void wordsCountStream(String text) {
        text = removePunctuation(text);
        text = textToLowerCase(text);
        String[] temp = textToStringArray(text);
        temp = removeDuplicates(temp);

        Word[] words = stringsToWords(temp);

        Stream<Word> wordsStream = Stream.of(words);
        Map<String, List<Word>> textMap = wordsStream.collect(
                Collectors.groupingBy(Word::getFirstLetter));

        for (Map.Entry<String, List<Word>> item : textMap.entrySet()) {
            log.info(item.getKey() + " : ");

            for (Word w : item.getValue()) {
                log.info(w.getWord() + " ");
            }
        }
    }
}