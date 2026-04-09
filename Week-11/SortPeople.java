package tasks;
import java.util.Arrays;

public class SortPeople {

    public static String[] sortPeople(String[] names, int[] heights) {

        int n = names.length;

        // Sort heights in descending order and swap names accordingly
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (heights[i] < heights[j]) {

                    // swap heights
                    int tempH = heights[i];
                    heights[i] = heights[j];
                    heights[j] = tempH;

                    // swap names
                    String tempN = names[i];
                    names[i] = names[j];
                    names[j] = tempN;
                }
            }
        }
        return names;
    }

    public static void main(String[] args) {

        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};

        String[] result = sortPeople(names, heights);

        System.out.println(Arrays.toString(result));
    }
}

