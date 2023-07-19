import java.util.*;
class topoligicalSort {
    public static int[] ans = new int[6];
    public static int[] vis = new int[6];

    public static void topoSort (List<List<Integer>> adj, int size) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < size; i++) { //making all the nodes unvisited
            vis[i] = -1;
        }
        for (int i = 0; i < size; i++) {
            if (vis[i] != 1) {
                dfs(adj, i, st);
            }
        }
        int j = 0;
        while (!st.isEmpty()) {
            ans[j] = st.pop();
            j++;
        }
    }

    public static void dfs (List<List<Integer>> adj, int node, Stack<Integer> st) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(adj, it, st);
            }
        }
        st.push(node);
    }

    public static void main(String[] args) {
        int size = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(1).add(2);
        System.out.println(adj);
        topoSort(adj, size);
        for (int i = 0; i < size; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
