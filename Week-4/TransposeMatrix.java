package tasks;
import java.util.Arrays;

public class TransposeMatrix {

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                result[c][r] = matrix[r][c];
            }
        }
        return result;
    }

    public static void main(String[] args) {
       
        int[][] input = {
            {1, 2, 3},
            {4, 5, 6}
        };

        System.out.println("Original Matrix:");
        printMatrix(input);

        int[][] output = transpose(input);

        System.out.println("\nTransposed Matrix:");
        printMatrix(output);
    }

    // Helper method to print 2D arrays nicely in the Eclipse console
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}

