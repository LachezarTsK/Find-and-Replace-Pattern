
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static final int ALPHABET_SIZE = 26;
    private static final char EMPTY = '\u0000';

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> allWordsThatMatchPattern = new ArrayList<>();
        for (String word : words) {
            if (wordMatchesPattern(word, pattern)) {
                allWordsThatMatchPattern.add(word);
            }
        }
        return allWordsThatMatchPattern;
    }

    private boolean wordMatchesPattern(String word, String pattern) {
        char[] patternToWord = new char[ALPHABET_SIZE];
        char[] wordToPattern = new char[ALPHABET_SIZE];

        for (int i = 0; i < word.length(); ++i) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);
            if ((patternToWord[p - 'a'] != EMPTY && patternToWord[p - 'a'] != w)
                    || (wordToPattern[w - 'a'] != EMPTY && wordToPattern[w - 'a'] != p)) {
                return false;
            }
            patternToWord[p - 'a'] = w;
            wordToPattern[w - 'a'] = p;
        }
        return true;
    }
}
