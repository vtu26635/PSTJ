package tasks;
import java.util.*;

public class CircularPalindrome {

    /**
     * Manacher's Algorithm to find the longest palindromic substring.
     * Complexity: O(n)
     */
    public static int getLongestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        
        // Transform string: "abc" -> "^#a#b#c#$" to handle even/odd lengths
        StringBuilder sb = new StringBuilder();
        sb.append("^");
        for (char c : s.toCharArray()) {
            sb.append("#").append(c);
        }
        sb.append("#$");

        char[] arr = sb.toString().toCharArray();
        int n = arr.length;
        int[] p = new int[n];
        int center = 0, right = 0;
        int maxLen = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Attempt to expand around center i
            while (arr[i + (1 + p[i])] == arr[i - (1 + p[i])]) {
                p[i]++;
            }

            // Update center and right boundary if the expanded palindrome is further right
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            maxLen = Math.max(maxLen, p[i]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        if (!sc.hasNext()) return;
        String s = sc.next();

        // Handle rotations by concatenating the string with itself
        String doubled = s + s;

        for (int i = 0; i < n; i++) {
            // Extract the rotation starting at index i
            String rotation = doubled.substring(i, i + n);
            System.out.println(getLongestPalindrome(rotation));
        }

        sc.close();
    }
}
