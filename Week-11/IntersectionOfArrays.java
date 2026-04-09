package tasks;
import java.util.*;

public class IntersectionOfArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of first array
        System.out.print("Enter size of nums1: ");
        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];

        System.out.println("Enter elements of nums1:");
        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }

        // Input size of second array
        System.out.print("Enter size of nums2: ");
        int n2 = sc.nextInt();
        int[] nums2 = new int[n2];

        System.out.println("Enter elements of nums2:");
        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        int[] result = intersection(nums1, nums2);

        System.out.println("Intersection: " + Arrays.toString(result));

        sc.close();
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        // Store nums1 elements
        for (int num : nums1) {
            set1.add(num);
        }

        // Find intersection
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert to array
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }
}

