package tasks;
	import java.util.Scanner;

	public class HillPatern {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter number of rows: ");
	        int n = sc.nextInt();
	        int sum = 0;

	        for (int i = 1; i <= n; i++) {
	            // Print leading spaces
	            for (int j = 1; j <= n - i; j++) {
	                System.out.print("  "); // 2 spaces for alignment
	            }

	            // Print increasing numbers
	            for (int j = 1; j <= i; j++) {
	                System.out.print(j + " ");
	                sum += j; // Add to weight
	            }

	            // Print decreasing numbers
	            for (int j = i - 1; j >= 1; j--) {
	                System.out.print(j + " ");
	                sum += j; // Add to weight
	            }

	            System.out.println();
	        }

	        System.out.println("Weight (sum of all numbers) of the hill: " + sum);
	        sc.close();
	    }
	}



