import java.util.*;

public class magnet {

    static class Node {
       int data;
       Node next;
       Node(int data) {
        this.data = data;
        this.next = null;
       } 
    }

    static class Stack {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push (Node head, int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode; 
                return;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            else {
                int data = head.data;
                head = head.next;
                return data;
            }
        }

        public static int peek() {
            int data = head.data;
            return data;
        }
        
        public static void main(String[] args) {
            
        }
    }
}
