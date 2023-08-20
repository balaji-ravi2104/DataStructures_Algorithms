public class Graph {
    public static int V;
    public static int[][] adjMatrix;

    public Graph(){

    }
    public Graph(int V){
        this.V = V;
        adjMatrix = new int[V][V];
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // For an undirected graph
    }
}
