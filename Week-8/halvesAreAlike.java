package tasks;
import java.util.*;

public class halvesAreAlike {

    public static boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int mid = s.length() / 2;
        int count = 0;

        for (int i = 0; i < mid; i++) {

            if (vowels.indexOf(s.charAt(i)) != -1) {
                count++;
            }

            if (vowels.indexOf(s.charAt(i + mid)) != -1) {
                count--;
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        boolean result = halvesAreAlike(s);

        if(result)
            System.out.println("Both halves are alike (same number of vowels)");
        else
            System.out.println("Both halves are NOT alike");

        sc.close();
    }
}

