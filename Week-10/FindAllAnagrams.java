package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Fill frequency for string p and the first window of s
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Check if the first window is an anagram
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Sliding window: move one character at a time
        for (int i = p.length(); i < s.length(); i++) {
            // Add the new character (right side of window)
            sCount[s.charAt(i) - 'a']++;
            // Remove the old character (left side of window)
            sCount[s.charAt(i - p.length()) - 'a']--;

            // Compare frequency arrays
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllAnagrams solver = new FindAllAnagrams();
        
        // Test Case 1
        String s1 = "cbaebabacd", p1 = "abc";
        System.out.println("Test 1: " + solver.findAnagrams(s1, p1)); // Expected: [0, 6]

        // Test Case 2
        String s2 = "abab", p2 = "ab";
        System.out.println("Test 2: " + solver.findAnagrams(s2, p2)); // Expected: [0, 1, 2]
    }
}

