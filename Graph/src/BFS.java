import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BFS extends Graph{


    public static void BFS(int startVertex) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.offer(startVertex);
        visited[startVertex] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            System.out.print(current + " ");

            for (int val : adjList[current]) {
                if (!visited[val]) {
                    visited[val] = true;
                    q.offer(val);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        System.out.println("Enter the vertex to start the BFS:");
        int vertex = sc.nextInt();

        BFS(vertex);
    }
}
