import java.util.*;
class TopologicalSort {

    public static List<Integer> ans = new ArrayList<>();
    public static int[] vis = new int[6];

    public static void topo(List<List<Integer>> adj, int size) {

        for (int i = 0; i < size; i++) {
            vis[i] = 0;
        }
        for (int i = 0; i < size; i++) {
            if (vis[i] == 0) {
                dfs(i, adj);
            }
        }
    }

    public static void dfs(int curr, List<List<Integer>> adj) {
        vis[curr] = 1;
        for (int it : adj.get(curr)) {
            if (vis[it] == 0) {
                dfs(it, adj);
            }
        }
        ans.add(curr);
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

        topo(adj, size);
        System.out.println(ans);
    }
}
