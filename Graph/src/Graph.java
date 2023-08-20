import java.util.LinkedList;
import java.util.Stack;

class Graph {
    public static int V;
    public static LinkedList<Integer>[] adjList;

    public Graph(){

    }

    public Graph(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int desc) {
        adjList[src].add(desc);
//      If the graph is directed the below line we should not use
        adjList[desc].add(src); // For an undirected graph
    }
}
