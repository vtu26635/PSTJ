package tasks;
import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            
            char current = s.charAt(right);
            
            // If duplicate character found
            if (map.containsKey(current)) {
                left = Math.max(left, map.get(current) + 1);
            }
            
            map.put(current, right);
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the string: ");
        String s = sc.nextLine();
        
        int result = lengthOfLongestSubstring(s);
        
        System.out.println("Length of longest substring without repeating characters: " + result);
        
        sc.close();
    }
}

