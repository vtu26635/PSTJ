package tasks;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SubArrayDivision {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s.add(sc.nextInt());
        }

   
        int d = sc.nextInt();
        int m = sc.nextInt();

       
        int result = solve(s, d, m);
        System.out.println(result);

        sc.close();
    }

    public static int solve(List<Integer> s, int d, int m) {
        int count = 0;

        for (int i = 0; i <= s.size() - m; i++) {
            int currentSum = 0;
            
           
            for (int j = 0; j < m; j++) {
                currentSum += s.get(i + j);
            }

            if (currentSum == d) {
                count++;
            }
        }
        return count;
    }
}
