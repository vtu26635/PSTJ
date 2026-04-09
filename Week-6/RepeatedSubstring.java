package tasks;
import java.util.Scanner;

public class RepeatedSubstring {

    public static boolean repeatedSubstringPattern(String s) {

        String doubled = s + s;
        String trimmed = doubled.substring(1, doubled.length() - 1);

        return trimmed.contains(s);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        boolean result = repeatedSubstringPattern(s);

        System.out.println(result);

        sc.close();
    }
}

