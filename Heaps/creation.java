import java.util.Scanner;

class Heap {
    public static void insert(int[] arr, int n, int data) {
       // n++;
        arr[n] = data;
        int i = n;
        while (i > 1) {
            int parent = i / 2;
            if (arr[parent] < arr[i]) {
                int temp = arr[i];
                arr[i] = arr[parent];
                arr[parent] = temp;
                i = parent;
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int elements = sc.nextInt();
        int[] arr = new int[elements + 1];
        int n = 0;

        for (int i = 0; i < elements; i++) {
            int data = sc.nextInt();
            insert(arr, n, data);
            n++;
        }
        sc.close();
        
        // Print arr
        for (int i = 1; i <= elements; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
