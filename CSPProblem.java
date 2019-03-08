import java.util.Stack;

public class CSPProblem
{
    Stack<Variable> openList = new Stack<>();
    Stack<Variable> closedList = new Stack<>();
    Backtrack backtrack = new Backtrack();

    public void startCSP(Variable root){
        openList.add(root);
        Variable currentNode = root;
        while(!openList.isEmpty()){
            currentNode = openList.pop();
            closedList.push(currentNode);
            constraint(currentNode);

            if (canColoring(currentNode)) {
                getAdjacent(currentNode);
                coloringMap(currentNode);
            } else {
                backtrack.backtrack(closedList);
                if (!openList.contains(currentNode) && !closedList.contains(currentNode)) openList.push(currentNode);
                openList.push(closedList.pop());
            }
        }
    }

    public void getAdjacent(Variable currentNode){
        for (Variable current : currentNode.getAdjacent()) {
            if (!openList.contains(current) && !closedList.contains(current)) {
                openList.push(current);
            }
        }
    }


    public boolean canColoring(Variable currentNode){
        for(String color : currentNode.domain.baseColors) {
            if (!currentNode.domain.constraintColor.contains(color)){
                return true;
            }
        }
        return false;
    }

    public void coloringMap(Variable currentNode){
        for (String c : currentNode.domain.baseColors){
            if (!currentNode.domain.constraintColor.contains(c)){
                currentNode.color = c;
                currentNode.domain.tryColor.add(currentNode.color);
                break;
            }
        }

    }

    public void constraint(Variable currentNode){
        currentNode.domain.constraintColor.clear();
        for (Variable adjacent : currentNode.getAdjacent()) {
            if (adjacent.color != null && adjacent!=currentNode && !currentNode.domain.constraintColor.contains(adjacent.color)) currentNode.domain.constraintColor.add(adjacent.color);
        }
    }


}
