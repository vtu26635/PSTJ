package tasks;
import java.util.*;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        // Step 1: Length check
        if (pattern.length() != words.length) {
            return false;
        }

        // Step 2: Create two maps
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        // Step 3: Traverse
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            // Check char -> word
            if (map1.containsKey(ch)) {
                if (!map1.get(ch).equals(word)) {
                    return false;
                }
            } else {
                map1.put(ch, word);
            }

            // Check word -> char
            if (map2.containsKey(word)) {
                if (map2.get(word) != ch) {
                    return false;
                }
            } else {
                map2.put(word, ch);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test cases
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";

        String pattern2 = "abba";
        String s2 = "dog cat cat fish";

        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";

        System.out.println(wordPattern(pattern1, s1)); // true
        System.out.println(wordPattern(pattern2, s2)); // false
        System.out.println(wordPattern(pattern3, s3)); // false
    }
}

