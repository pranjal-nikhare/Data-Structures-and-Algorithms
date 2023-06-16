import java.util.*;
public class magnet {

    static ArrayList<Integer> elements = new ArrayList<Integer>();

    public static boolean isEmpty (ArrayList<Integer> elements) {
        return elements.size() == 0;
    }

    public static void push (ArrayList<Integer> elements, int data) {
        elements.add(data);
    }

    public static int pop (ArrayList<Integer> elements) {
        if (isEmpty(elements)) {
            return -1;
        }
        int top = elements.get(elements.size() - 1);
        elements.remove(elements.size()-1);
        return top;
    }

    public static int peek (ArrayList<Integer> elements) {
        return elements.get(elements.size() - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element to add : ");
        int data = sc.nextInt();
        push(elements, data);
        push(elements, 28);
        push(elements, 42);
        push(elements, 73);
        push(elements, 50);
        System.out.println("The popped element is : " + pop(elements));
        System.out.println("The top element is : " + peek(elements));
        

        
    }
}
