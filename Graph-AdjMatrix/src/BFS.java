import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS extends Graph{
    public static void BFS(int startVertex){
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.offer(startVertex);
        visited[startVertex] = true;

        while (!q.isEmpty()){
            int current = q.poll();
            System.out.print(current+" ");

            for(int neighbor=0;neighbor<V;neighbor++){
                if(adjMatrix[current][neighbor]==1 && !visited[neighbor]){
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
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

        BFS(vertex);

    }
}
