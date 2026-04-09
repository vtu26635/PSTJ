package tasks;
import java.util.HashSet;
public class ContainsDuplicate {


	    
	    public boolean containsDuplicate(int[] nums) {
	        // We use a HashSet because it offers O(1) average time complexity for lookups
	        HashSet<Integer> seen = new HashSet<>();
	        
	        for (int num : nums) {
	            // If the number is already in the set, we found a duplicate
	            if (seen.contains(num)) {
	                return true;
	            }
	            // Otherwise, add it to the set and keep checking
	            seen.add(num);
	        }
	        return false;
	    }

	    public static void main(String[] args) {
	        ContainsDuplicate sol = new ContainsDuplicate();
	        
	        // Test Case 1: Should be true
	        int[] nums1 = {1, 2, 3, 1};
	        System.out.println("Test 1 (Expected true): " + sol.containsDuplicate(nums1));
	        
	        // Test Case 2: Should be false
	        int[] nums2 = {1, 2, 3, 4};
	        System.out.println("Test 2 (Expected false): " + sol.containsDuplicate(nums2));
	    }
	}
	

