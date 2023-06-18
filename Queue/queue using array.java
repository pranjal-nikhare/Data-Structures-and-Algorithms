public class magnet {
    private static int[] arr;
    private static int rear;
    private static int size;

    public static void push(int value) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        arr[rear] = value;
    }

    public static int remove() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        int front = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return front;
    }

    // ** IMPORTANT **
    // Function to create a circular queue is missing;

    public static int peek() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        int front = arr[0];
        return front;
    }

    public static void main(String[] args) {
        size = 5;
        arr = new int[size];
        rear = -1;
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);

        remove(); 
        
        while (rear != -1) {
            System.out.println(peek());
            remove();
        }
    }
}
