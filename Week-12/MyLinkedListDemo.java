package tasks;
import java.util.*;

public class MyLinkedListDemo {

    // Node class
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Linked List class
    static class MyLinkedList {
        private Node head;
        private int size;

        public MyLinkedList() {
            head = null;
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) return -1;

            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr.val;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            node.next = head;
            head = node;
            size++;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);

            if (head == null) {
                head = node;
            } else {
                Node curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = node;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) return;

            if (index == 0) {
                addAtHead(val);
                return;
            }

            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            Node node = new Node(val);
            node.next = curr.next;
            curr.next = node;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;

            if (index == 0) {
                head = head.next;
            } else {
                Node curr = head;
                for (int i = 0; i < index - 1; i++) {
                    curr = curr.next;
                }
                curr.next = curr.next.next;
            }
            size--;
        }

        // Helper to print list
        public void printList() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }
    }

    // Main method
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);  // 1 -> 2 -> 3

        System.out.println("Value at index 1: " + list.get(1)); // 2

        list.deleteAtIndex(1);  // 1 -> 3

        System.out.println("Value at index 1: " + list.get(1)); // 3

        System.out.print("Final List: ");
        list.printList();
    }
}

