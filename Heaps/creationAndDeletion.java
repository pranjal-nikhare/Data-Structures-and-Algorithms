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

    public static void delete (int arr[], int n) {
        arr[0] = arr[n-1];
        arr[n-1] = 0;
        int i = 0;
        while (i < n-1) {
            int left = 2 * i;
            int right = 2 * i + 1;
            if (arr[left] > arr[right]) {
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                i = left;
            } else {
                int temp = arr[i];
                arr[i] = arr[right];
                arr[right] = temp;
                i = right;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int elements = sc.nextInt();
        int[] arr = new int[elements + 1];
        int n = 1;

        for (int i = 1; i <= elements; i++) {
            int data = sc.nextInt();
            insert(arr, n, data);
            n++;
        }
        sc.close();
        
        // Print arr
        for (int i = 1; i <= elements; i++) {
            System.out.print(arr[i] + " ");
        }

        delete(arr, elements);
        System.out.println();
        for (int i = 1; i <= elements; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
