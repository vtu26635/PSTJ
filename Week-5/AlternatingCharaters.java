package tasks;
import java.util.Scanner;

public class AlternatingCharaters {

    public static int alternatingCharacters(String s) {
        int deletions = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                deletions++;
            }
        }

        return deletions;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of test cases:");
        int q = sc.nextInt();

        while (q > 0) {
            System.out.println("Enter string:");
            String s = sc.next();

            int result = alternatingCharacters(s);
            System.out.println("Minimum deletions required: " + result);

            q--;
        }

        sc.close();
    }
}


