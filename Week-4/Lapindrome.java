package tasks;
import java.util.*;

public class Lapindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of test cases:");
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            
            while (t-- > 0) {
                String s = sc.next();
                if (isLapindrome(s)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }

    private static boolean isLapindrome(String s) {
        int n = s.length();
        int[] leftFreq = new int[26];
        int[] rightFreq = new int[26];

        // Process left half
        for (int i = 0; i < n / 2; i++) {
            leftFreq[s.charAt(i) - 'a']++;
        }

        // Process right half (skips middle char if length is odd)
        for (int i = (n + 1) / 2; i < n; i++) {
            rightFreq[s.charAt(i) - 'a']++;
        }

        return Arrays.equals(leftFreq, rightFreq);
    }
}

