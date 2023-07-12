import java.util.*;

public class charge {
    static List<List<Integer>> adjacencyList;
    static int numVertices;

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

    public static void main(String[] args) {
        int numVertices = 5;
        createGraph(numVertices);

        addEdge(0, 1);
        addEdge(0, 4);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(2, 3);
        addEdge(3, 4);

        printGraph();
    }
}
