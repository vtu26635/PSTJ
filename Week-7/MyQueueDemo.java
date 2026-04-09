package tasks;
import java.util.Stack;

public class MyQueueDemo {

    static class MyQueue {
        private Stack<Integer> input;
        private Stack<Integer> output;

        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        // Push element to back
        public void push(int x) {
            input.push(x);
        }

        // Remove from front
        public int pop() {
            peek(); // ensure output has elements
            return output.pop();
        }

        // Get front element
        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        // Check if empty
        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.push(1);
        q.push(2);

        System.out.println("Peek: " + q.peek());   // 1
        System.out.println("Pop: " + q.pop());     // 1
        System.out.println("Is Empty: " + q.empty()); // false
    }
}
