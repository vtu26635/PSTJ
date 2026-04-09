package tasks;
import java.util.*;

public class BrowserHistory {

    static ArrayList<String> history = new ArrayList<>();
    static int current = 0;

    public static void visit(String url) {
        // remove forward history
        while (history.size() > current + 1) {
            history.remove(history.size() - 1);
        }

        history.add(url);
        current++;
    }

    public static String back(int steps) {
        current = Math.max(0, current - steps);
        return history.get(current);
    }

    public static String forward(int steps) {
        current = Math.min(history.size() - 1, current + steps);
        return history.get(current);
    }

    public static void main(String[] args) {

        history.add("google.com");

        visit("facebook.com");
        visit("youtube.com");
        visit("leetcode.com");

        System.out.println(back(1));
        System.out.println(back(1));
        System.out.println(forward(1));

        visit("linkedin.com");

        System.out.println(forward(2));
        System.out.println(back(2));
        System.out.println(back(7));
    }
}

