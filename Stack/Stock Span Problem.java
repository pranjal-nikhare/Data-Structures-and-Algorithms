import java.util.*;

public class magnet {
    
    
    public static void stockSpan (int span[], int[] stocks) {

        Stack <Integer> stack = new Stack <Integer> ();
        span[0] = 1;
        stack.push(0);
        for (int i=1; i<= stocks.length-1; i++) {
            int currStock = stocks[i];

            while (currStock >= stocks[stack.peek()] && !stack.isEmpty()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i+1;
            } else {
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int[] stocks = {100, 80, 60, 70, 60, 75, 85};
        int[] span = new int[stocks.length];
        stockSpan(span, stocks);
        System.out.println(Arrays.toString(span));
    }
}
