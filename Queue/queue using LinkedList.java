public class magnet {
    static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class que {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null & tail == null;
        }

        public static void push (int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
                return;
            } 
                tail.next = newNode;
                tail = newNode; 
        }

        public static int remove () {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int value = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next; 
            }
            return value;
        }
    }

    public static void main(String[] args) {
    que q = new que();
    q.push(1);
    q.push(2);
    q.push(3);
    System.out.println(q.remove()); // should print 1
    System.out.println(q.remove()); // should print 2
    System.out.println(q.remove()); // should print 3
    System.out.println(q.remove()); // should print "Queue is empty" and -1
}
}
