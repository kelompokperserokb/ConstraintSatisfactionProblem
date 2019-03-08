import java.util.ArrayList;
import java.util.List;

public class Graph {
    public int sizeNode = 0;
    public List<Variable> node = new ArrayList<>();

    public Variable setVariable(String name, Domain colors){
        Variable variable = new Variable(name, colors);
        node.add(variable);
        sizeNode++;
        return variable;
    }

    public void setAdjacent(boolean[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j]) (node.get(i)).setAdjacent(node.get(j));
            }
        }
    }
}