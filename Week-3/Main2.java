package tasks;
import java.util.*;

public class Main2 {

    public static String frequencySort(String s) {

        // Step 1: Count frequency
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sort characters by frequency
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        // Step 3: Build result
        StringBuilder result = new StringBuilder();
        for (char c : list) {
            int freq = map.get(c);
            for (int i = 0; i < freq; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "tree";

        String output = frequencySort(s);
        System.out.println(output);  // eetr or eert
    }
}

