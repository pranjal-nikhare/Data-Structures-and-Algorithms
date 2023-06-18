import java.util.*;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        Stack <Integer> s = new Stack<>();
        for (int i = nums2.length-1; i >= 0; i--) {
            int currNum = nums2[i];
            while (!s.isEmpty() && s.peek() <= currNum) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = s.peek();
            }
            s.push(nums2[i]);
        }
        public static void main(String[] args) {
            
        }
        
    }
}
