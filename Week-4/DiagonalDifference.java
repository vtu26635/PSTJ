package tasks;



	import java.util.Scanner;

	public class DiagonalDifference {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Check if there is input available to avoid errors
	        if (sc.hasNextInt()) {
	            int n = sc.nextInt();   // size of the matrix (n x n)
	            int[][] arr = new int[n][n];

	            // Reading the matrix
	            for (int i = 0; i < n; i++) {
	                for (int j = 0; j < n; j++) {
	                    if (sc.hasNextInt()) {
	                        arr[i][j] = sc.nextInt();
	                    }
	                }
	            }

	            int primarySum = 0;
	            int secondarySum = 0;

	            // Calculating diagonal sums
	            for (int i = 0; i < n; i++) {
	                primarySum += arr[i][i];           // left-to-right diagonal
	                secondarySum += arr[i][n - 1 - i]; // right-to-left diagonal
	            }

	            // Absolute difference
	            int result = Math.abs(primarySum - secondarySum);

	            System.out.println("Absolute Diagonal Difference: " + result);
	        }
	        
	        sc.close();
	    }
	}
