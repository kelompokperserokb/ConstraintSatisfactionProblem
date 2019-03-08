import java.util.ArrayList;
import java.util.List;

public class Variable {

    public String name;
    public String color;
    public List<Variable> adjacent = new ArrayList<>();
    public Domain domain;

    public Variable(String name, Domain domain) {
        this.name = name;
        this.domain = domain;
    }

    public void setAdjacent(Variable adjacent){
        this.adjacent.add(adjacent);
    }

    public List<Variable> getAdjacent() {
        return adjacent;
    }

}