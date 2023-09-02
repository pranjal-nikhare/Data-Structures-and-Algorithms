import java.util.*;

class Pair {
    int wt;
    int node;

    public Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

class Charge {
    public static void prims(List<List<List<Integer>>> adj, int src) {
        int sum = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        List<List<Integer>> mst = new ArrayList<>();
        pq.add(new Pair(src, 0));
        int[] dis = new int[adj.size()];
        Arrays.fill(dis, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;

            for (List<Integer> it : adj.get(node)) {
                int dest = it.get(0);
                int wt = it.get(1);

                if (wt < dis[dest]) {
                    dis[dest] = wt;
                    pq.add(new Pair(dest, wt));
                    sum += wt;
                    mst.add(new ArrayList<>(Arrays.asList(node, dest, wt)));
                }
            }
        }

        System.out.println("MST: " + mst);
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        int numVertices = 5;
        for (int i = 0; i < numVertices; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 2)));

        adj.get(0).add(new ArrayList<>(Arrays.asList(3, 6)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(0, 6)));

        adj.get(3).add(new ArrayList<>(Arrays.asList(1, 8)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 8)));

        adj.get(1).add(new ArrayList<>(Arrays.asList(4, 3)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(1, 3)));

        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 3)));

        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 7)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(2, 7)));

        prims(adj, 0);
    }
}
