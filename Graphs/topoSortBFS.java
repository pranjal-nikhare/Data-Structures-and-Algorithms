// Kahn's Algorithm

import java.util.*;
class topoligicalSort {
    public static void topoSort (List<List<Integer>> adj, int size) {
        int[] indegree = new int[size];
        for (int i = 0; i < size; i++) {
            for (int it: adj.get(i)) {
                indegree[it]++;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int it: adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        System.out.println(ans);
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

        System.out.println(adj);
        topoSort(adj, size);


    }
}
