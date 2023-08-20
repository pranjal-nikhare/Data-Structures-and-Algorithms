import java.util.*;
class charge {
    public static int dist[] = new int[9];

    public static void shortestPath (List<List<Integer>> adj, int start) {
        for (int i = 0; i < 9; i++) {
        dist[i] = Integer.MAX_VALUE;
        }
        Queue <Integer> q = new LinkedList<Integer>();
        dist[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int it: adj.get(curr)) {
                if (dist[it] > dist[curr] + 1) {
                    dist[it] = dist[curr] + 1; 
                    q.add(it);
                }
            }
        }
        
    }

    public static void main(String[] args) {
        int nodes = 9;
        int start = 0;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        int rows = edge.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < rows; i++) {
            int p1 = edge[i][0];
            int p2 = edge[i][1];

            adj.get(p1).add(p2);
            adj.get(p2).add(p1);
        }
        shortestPath(adj, start);

        //print the distance of each node from start node
        for (int i = 0; i < nodes; i++) {
            System.out.println("Distance of " + i + " from " + start + " is " + dist[i]);
        }
    }
}
