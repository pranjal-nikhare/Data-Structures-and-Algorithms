import java.util.*;

class charge {
    static class Edge {
        int dest;
        int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Pair {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static int[] dist;

    public static void dijkstras(List<List<Edge>> graph, int source) {
        int numVertices = graph.size();
        dist = new int[numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        pq.add(new Pair(source, 0));
        dist[source] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currNode = curr.node;
            int currDist = curr.dist;

            if (currDist > dist[currNode]) {
                continue;
            }

            for (Edge neighbor : graph.get(currNode)) {
                int newDist = currDist + neighbor.weight;
                if (newDist < dist[neighbor.dest]) {
                    dist[neighbor.dest] = newDist;
                    pq.add(new Pair(neighbor.dest, newDist));
                }
            }
        }
    }

    public static void main(String[] args) {
        int numVertices = 6;
        List<List<Edge>> graph = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 3));

        graph.get(1).add(new Edge(0, 4));
        graph.get(1).add(new Edge(2, 2));

        graph.get(2).add(new Edge(0, 3));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 3));
        graph.get(2).add(new Edge(5, 6));
        graph.get(2).add(new Edge(4, 1));

        graph.get(3).add(new Edge(2, 3));
        graph.get(3).add(new Edge(5, 2));

        graph.get(4).add(new Edge(3, 3));
        graph.get(4).add(new Edge(2, 1));

        graph.get(5).add(new Edge(3, 2));
        graph.get(5).add(new Edge(2, 6));
        graph.get(5).add(new Edge(4, 3));

        int source = 0;
        dijkstras(graph, source);
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Source " + source + " -> destination " + i + " = " + dist[i]);
        }
    }
}
