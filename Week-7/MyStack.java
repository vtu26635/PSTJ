package tasks;
import java.util.*;

public class MyStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int x) {
        q1.add(x);
    }

    int pop() {
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int val = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return val;
    }

    int top() {
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int val = q1.peek();
        q2.add(q1.remove());

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return val;
    }

    boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {

        MyStack s = new MyStack();

        s.push(1);
        s.push(2);

        System.out.println(s.top());   // 2
        System.out.println(s.pop());   // 2
        System.out.println(s.empty()); // false
    }
}
