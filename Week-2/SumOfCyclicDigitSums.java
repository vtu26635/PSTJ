package tasks;

import java.util.Scanner;

public class SumOfCyclicDigitSums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String num = sc.nextLine();
        int totalSum = 0;
        int n = num.length();

        // Loop for each rotation
        for (int i = 0; i < n; i++) {
            int sum = 0;

            // Sum digits of current rotation
            for (int j = 0; j < n; j++) {
                sum += Character.getNumericValue(num.charAt((i + j) % n));
            }

            totalSum += sum;
        }

        System.out.println("Sum of sums of digits in cyclic order: " + totalSum);
        sc.close();
    }
}
