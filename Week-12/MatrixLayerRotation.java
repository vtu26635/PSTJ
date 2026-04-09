package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MatrixLayerRotation {
	
	
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	       
	        String[] firstLine = br.readLine().split(" ");
	        int m = Integer.parseInt(firstLine[0]);
	        int n = Integer.parseInt(firstLine[1]);
	        int r = Integer.parseInt(firstLine[2]);

	        int[][] matrix = new int[m][n];
	        for (int i = 0; i < m; i++) {
	            String[] row = br.readLine().split(" ");
	            for (int j = 0; j < n; j++) {
	                matrix[i][j] = Integer.parseInt(row[j]);
	            }
	        }

	        rotateMatrix(matrix, m, n, r);
	    }

	    private static void rotateMatrix(int[][] matrix, int m, int n, int r) {
	    
	        int layers = Math.min(m, n) / 2;

	        for (int layer = 0; layer < layers; layer++) {
	            List<Integer> perimeter = new ArrayList<>();

	            
	          
	            for (int j = layer; j < n - layer; j++) perimeter.add(matrix[layer][j]);
	            
	            for (int i = layer + 1; i < m - layer - 1; i++) perimeter.add(matrix[i][n - 1 - layer]);
	           
	            for (int j = n - 1 - layer; j >= layer; j--) perimeter.add(matrix[m - 1 - layer][j]);
	           
	            for (int i = m - 2 - layer; i > layer; i--) perimeter.add(matrix[i][layer]);

	            
	            int size = perimeter.size();
	            int shift = r % size;

	          
	            int index = shift; 
	            for (int j = layer; j < n - layer; j++) matrix[layer][j] = perimeter.get(index++ % size);
	            for (int i = layer + 1; i < m - layer - 1; i++) matrix[i][n - 1 - layer] = perimeter.get(index++ % size);
	            for (int j = n - 1 - layer; j >= layer; j--) matrix[m - 1 - layer][j] = perimeter.get(index++ % size);
	            for (int i = m - 2 - layer; i > layer; i--) matrix[i][layer] = perimeter.get(index++ % size);
	        }

	      
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                sb.append(matrix[i][j]).append(" ");
	            }
	            sb.append("\n");
	        }
	        System.out.print(sb);
	    }
	}
