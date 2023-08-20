import java.util.Scanner;
import java.util.Stack;

public class DFS extends Graph{

    public static void DFS(int startVertex) {

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited[current]) {
                System.out.print(current + " ");
                visited[current] = true;

                for (int val : adjList[current]) {
                    if (!visited[val]) {
                        stack.push(val);
                    }
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

        DFS(vertex);
    }
}
