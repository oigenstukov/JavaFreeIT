package task2;

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
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //String text = sc.nextLine();
        String textA = "Once upon a time a Wolf was lapping at a spring on a hillside, when, looking " +
                "up, what should he see but a Lamb just beginning to drink a little lower down.";

//        wordsCountLong(textA);
//        wordsCountShort(textA);
        wordsCountStream(textA);

    }

    // option 1
//    public static void wordsCountLong(String text) {
//        String[] words = text.replaceAll("[^a-zA-Z ]", "")
//                .toLowerCase()
//                .split("\\s+");
//        Map<Character, Set<String>> allWords = new HashMap<>();
//        Set<String> aWords = new HashSet<>();
//        Set<String> bWords = new HashSet<>();
//        Set<String> cWords = new HashSet<>();
//        Set<String> dWords = new HashSet<>();
//        Set<String> eWords = new HashSet<>();
//        Set<String> fWords = new HashSet<>();
//        Set<String> gWords = new HashSet<>();
//        Set<String> hWords = new HashSet<>();
//        Set<String> iWords = new HashSet<>();
//        Set<String> jWords = new HashSet<>();
//        Set<String> kWords = new HashSet<>();
//        Set<String> lWords = new HashSet<>();
//        Set<String> mWords = new HashSet<>();
//        Set<String> nWords = new HashSet<>();
//        Set<String> oWords = new HashSet<>();
//        Set<String> pWords = new HashSet<>();
//        Set<String> qWords = new HashSet<>();
//        Set<String> rWords = new HashSet<>();
//        Set<String> sWords = new HashSet<>();
//        Set<String> tWords = new HashSet<>();
//        Set<String> uWords = new HashSet<>();
//        Set<String> vWords = new HashSet<>();
//        Set<String> wWords = new HashSet<>();
//        Set<String> xWords = new HashSet<>();
//        Set<String> yWords = new HashSet<>();
//        Set<String> zWords = new HashSet<>();
//        for (String s : words) {
//            if (s.substring(0, 1).equals("a")) {
//                aWords.add(s);
//                allWords.put('a', aWords);
//            }
//            if (s.substring(0, 1).equals("b")) {
//                bWords.add(s);
//                allWords.put('b', bWords);
//            }
//            if (s.substring(0, 1).equals("c")) {
//                cWords.add(s);
//                allWords.put('c', cWords);
//            }
//            if (s.substring(0, 1).equals("d")) {
//                dWords.add(s);
//                allWords.put('d', dWords);
//            }
//            if (s.substring(0, 1).equals("e")) {
//                eWords.add(s);
//                allWords.put('e', eWords);
//            }
//            if (s.substring(0, 1).equals("f")) {
//                fWords.add(s);
//                allWords.put('f', fWords);
//            }
//            if (s.substring(0, 1).equals("g")) {
//                gWords.add(s);
//                allWords.put('g', gWords);
//            }
//            if (s.substring(0, 1).equals("h")) {
//                hWords.add(s);
//                allWords.put('h', hWords);
//            }
//            if (s.substring(0, 1).equals("i")) {
//                iWords.add(s);
//                allWords.put('i', iWords);
//            }
//            if (s.substring(0, 1).equals("j")) {
//                jWords.add(s);
//                allWords.put('j', jWords);
//            }
//            if (s.substring(0, 1).equals("k")) {
//                kWords.add(s);
//                allWords.put('k', kWords);
//            }
//            if (s.substring(0, 1).equals("l")) {
//                lWords.add(s);
//                allWords.put('l', lWords);
//            }
//            if (s.substring(0, 1).equals("m")) {
//                mWords.add(s);
//                allWords.put('m', mWords);
//            }
//            if (s.substring(0, 1).equals("n")) {
//                nWords.add(s);
//                allWords.put('n', nWords);
//            }
//            if (s.substring(0, 1).equals("o")) {
//                oWords.add(s);
//                allWords.put('o', oWords);
//            }
//            if (s.substring(0, 1).equals("p")) {
//                pWords.add(s);
//                allWords.put('p', pWords);
//            }
//            if (s.substring(0, 1).equals("q")) {
//                qWords.add(s);
//                allWords.put('q', qWords);
//            }
//            if (s.substring(0, 1).equals("r")) {
//                rWords.add(s);
//                allWords.put('r', rWords);
//            }
//            if (s.substring(0, 1).equals("s")) {
//                sWords.add(s);
//                allWords.put('s', sWords);
//            }
//            if (s.substring(0, 1).equals("t")) {
//                tWords.add(s);
//                allWords.put('t', tWords);
//            }
//            if (s.substring(0, 1).equals("u")) {
//                uWords.add(s);
//                allWords.put('u', uWords);
//            }
//            if (s.substring(0, 1).equals("v")) {
//                vWords.add(s);
//                allWords.put('v', vWords);
//            }
//            if (s.substring(0, 1).equals("w")) {
//                wWords.add(s);
//                allWords.put('w', wWords);
//            }
//            if (s.substring(0, 1).equals("x")) {
//                xWords.add(s);
//                allWords.put('x', xWords);
//            }
//            if (s.substring(0, 1).equals("y")) {
//                yWords.add(s);
//                allWords.put('y', yWords);
//            }
//            if (s.substring(0, 1).equals("z")) {
//                zWords.add(s);
//                allWords.put('z', zWords);
//            }
//        }
//        allWords.forEach((k, v) -> System.out.println(k.toString().toUpperCase() + " : " + v));
//    }

    // option 2
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

    // option 3
    public static void wordsCountStream(String text) {
        String[] temp = text.replaceAll("[^A-z ]", "")
                .toLowerCase()
                .split("\\s+");
        Set<String> tempSet = new LinkedHashSet<>(Arrays.asList(temp));
        temp = tempSet.toArray(new String[0]);
        Word[] words = new Word[tempSet.size()];
        for (int i = 0; i < temp.length; i++) {
            words[i] = new Word(temp[i]);
        }

        Stream<Word> wordsStream = Stream.of(words);
        Map<String, List<Word>> textMap = wordsStream.collect(
                Collectors.groupingBy(Word::getFirstLetter));

        for (Map.Entry<String, List<Word>> item : textMap.entrySet()) {
            System.out.print(item.getKey() + " : ");

            for (Word w : item.getValue()) {
                System.out.print(w.getWord() + " ");
            }
            System.out.println();
        }
    }
}

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
}

