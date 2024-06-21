import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class codd {

    public static void bfs(List<List<Integer>> adj, int vis[], int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (int i : adj.get(curr)) {
                if (vis[i] == 0) {
                    q.add(i);
                    vis[i] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        int size = 6;
        List<List<Integer>> adj = new ArrayList<>();
        int vis[] = new int[size];

        Arrays.fill(vis, 0);

        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(5).add(0);
        adj.get(0).add(5);
        adj.get(1).add(0);
        adj.get(2).add(1);
        adj.get(3).add(2);
        adj.get(4).add(3);
        adj.get(5).add(4);

        bfs(adj, vis, 0);
    }
}
