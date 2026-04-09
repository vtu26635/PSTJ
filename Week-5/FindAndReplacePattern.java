package tasks;
import java.util.*;

public class FindAndReplacePattern {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private static boolean matches(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            if (map1.containsKey(p)) {
                if (map1.get(p) != w) {
                    return false;
                }
            } else {
                map1.put(p, w);
            }

            // word -> pattern
            if (map2.containsKey(w)) {
                if (map2.get(w) != p) {
                    return false;
                }
            } else {
                map2.put(w, p);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        sc.nextLine();  // consume newline

        String[] words = new String[n];

        System.out.println("Enter words:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }

        System.out.print("Enter pattern: ");
        String pattern = sc.nextLine();

        List<String> result = findAndReplacePattern(words, pattern);

        System.out.println("Matching words: " + result);

        sc.close();
    }
}



