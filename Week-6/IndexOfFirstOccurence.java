package tasks;
import java.util.Scanner;

public class IndexOfFirstOccurence {

    public static int strStr(String haystack, String needle) {
        
        if (needle.length() == 0) return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            
            int j = 0;

            while (j < needle.length() &&
                   haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter haystack string: ");
        String haystack = sc.nextLine();

        System.out.print("Enter needle string: ");
        String needle = sc.nextLine();

        int result = strStr(haystack, needle);

        System.out.println("Index of first occurrence: " + result);

        sc.close();
    }
}

