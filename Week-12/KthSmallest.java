package tasks;

public class KthSmallest {
	
	    public static void main(String[] args) {
	        int[] arr = {7, 10, 4, 3, 20, 15};
	        int k = 3;

	        // Sorting the array
	        for (int i = 0; i < arr.length - 1; i++) {
	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[i] > arr[j]) {
	                    int temp = arr[i];
	                    arr[i] = arr[j];
	                    arr[j] = temp;
	                }
	            }
	        }

	        // Kth smallest element
	        System.out.println(k + "rd smallest element is: " + arr[k - 1]);
	    }
	}


