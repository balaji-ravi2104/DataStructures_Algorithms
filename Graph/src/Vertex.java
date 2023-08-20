import java.util.ArrayList;
import java.util.List;

public class Vertex {
    String name;
    List<Edge> edges;

    public Vertex(String name){
        this.name = name;
        edges = new ArrayList<>();
    }
}
