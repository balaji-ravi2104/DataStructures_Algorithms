import java.util.Scanner;

public class DFS extends Graph{

    public static void DFS(int startVertex, boolean[] visited){
        System.out.print(startVertex+" ");
        visited[startVertex] = true;

        for(int neighbor = 0;neighbor<V;neighbor++){
            if(adjMatrix[startVertex][neighbor]==1 && !visited[neighbor]){
                DFS(neighbor,visited);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        System.out.println("Enter the staring vertex");
        int vertex = sc.nextInt();
        boolean[] visited = new boolean[V];
        DFS(vertex,visited);
    }
}
