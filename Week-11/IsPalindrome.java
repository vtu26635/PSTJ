package tasks;
	import java.util.Scanner;

	public class IsPalindrome {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a string: ");
	        String str = sc.nextLine();
	        
	        if (isPalindrome(str)) {
	            System.out.println(str + " is a palindrome.");
	        } else {
	            System.out.println(str + " is not a palindrome.");
	        }
	        sc.close();
	    }

	    public static boolean isPalindrome(String str) {
	        // Remove spaces and convert to lowercase for uniformity
	        str = str.replaceAll("\\s+", "").toLowerCase();
	        int left = 0;
	        int right = str.length() - 1;
	        
	        while (left < right) {
	            if (str.charAt(left) != str.charAt(right)) {
	                return false; // Mismatch found
	            }
	            left++;
	            right--;
	        }
	        return true; // No mismatches, it's a palindrome
	    }
	}



