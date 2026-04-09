package tasks;
import java.util.Scanner;

public class RotateString {

    public static boolean rotateString(String s, String goal) {

        // Check length
        if (s.length() != goal.length()) {
            return false;
        }

        // Check if goal is substring of s + s
        String doubled = s + s;
        return doubled.contains(goal);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter goal string: ");
        String goal = sc.nextLine();

        boolean result = rotateString(s, goal);
        System.out.println(result);

        sc.close();
    }
}


