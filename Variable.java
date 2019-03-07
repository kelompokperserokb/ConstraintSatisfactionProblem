import java.util.ArrayList;
import java.util.List;

public class Variable {

    public String name;
    public String color;
    public List<Variable> adjacent = new ArrayList<>();
    public Domain colors;

    public Variable(String name, Domain colors) {
        this.name = name;
        this.colors = colors;
    }

    public void setAdjacent(Variable adjacent){
        this.adjacent.add(adjacent);
    }

    public List<Variable> getAdjacent() {
        return adjacent;
    }

}