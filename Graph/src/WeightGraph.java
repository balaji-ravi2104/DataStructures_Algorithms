import java.util.*;
public class WeightGraph {
    private final Map<String,Vertex> vertices;

    public WeightGraph(){
        vertices = new HashMap<>();
    }

    public void addVertex(String name){
        if(!vertices.containsKey(name)){
            vertices.put(name,new Vertex(name));
        }
    }

    public void addEdge(String source,String destination,int weight){
        if(vertices.containsKey(source) && vertices.containsKey(destination)){
            Vertex srcVertex = vertices.get(source);
            Vertex decVertex = vertices.get(destination);

            srcVertex.edges.add(new Edge(decVertex,weight));
            decVertex.edges.add(new Edge(srcVertex,weight)); // Undirected graph
        }
    }
    public void bfs(String startVertexName) {
        if (!vertices.containsKey(startVertexName)) {
            System.out.println("Vertex not found in the graph.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        Vertex startVertex = vertices.get(startVertexName);
        queue.offer(startVertex);
        visited.add(startVertexName);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            System.out.print(currentVertex.name + "-> ");

            for (Edge edge : currentVertex.edges) {
                Vertex neighbor = edge.destination;

                if (!visited.contains(neighbor.name)) {
                    System.out.print(" Neighbor "+neighbor.name +" Weight "+edge.weight+":");
                    queue.offer(neighbor);
                    visited.add(neighbor.name);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        WeightGraph graph = new WeightGraph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "C", 5);
        graph.addEdge("A", "C", 7);


        graph.bfs("B");

    }
}
