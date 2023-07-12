import java.util.*;

public class charge {
    public static List<List<Integer>> adjacencyList;
    public static int numVertices;


    public static void createGraph(int numVertices) {
        charge.numVertices = numVertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public static void addEdge(int source, int destination) {
        // Add an edge between source and destination
        adjacencyList.get(source).add(destination);
        // For an undirected graph, uncomment the line below
        adjacencyList.get(destination).add(source);
    }


    public static void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " -> ");
            List<Integer> neighbors = adjacencyList.get(i);
            for (int j = 0; j < neighbors.size(); j++) {
                System.out.print(neighbors.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void bfs (int vertex) {
        Queue <Integer> q1 = new LinkedList<>();
        boolean[] vis1 = new boolean[numVertices];
        q1.add(vertex);
        vis1[vertex] = true;

        while (!q1.isEmpty()) {
            int temp = q1.poll();
            System.out.print(temp + " ");
            for (Integer it : adjacencyList.get(temp)) {
                if (vis1[it] != true) {
                    q1.add(it);
                    vis1[it] = true;
                }
            }
        }
        System.out.println();
    }


    public static void dfs (int vertex, boolean[] vis) {
        // int temp = vertex;
        vis [vertex] = true;
        System.out.print(vertex + " ");

        for (Integer it: adjacencyList.get(vertex)) {
            if (vis[it] != true) {
                dfs(it, vis);
            }
        }
    }



    public static void main(String[] args) {
        int numVertices = 5;
        createGraph(numVertices);
        boolean[] vis = new boolean[numVertices];


        addEdge(0, 1);
        addEdge(0, 4);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(2, 3);
        addEdge(3, 4);

        printGraph();
        bfs(1);
        dfs(1, vis);
    }
}
