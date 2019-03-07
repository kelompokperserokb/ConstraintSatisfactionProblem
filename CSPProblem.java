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
            for (Variable current : currentNode.getAdjacent()) {
                if (!openList.contains(current) && !closedList.contains(current)) {
                    openList.push(current);
                }
            }

            if (canColoring(currentNode)) {
                coloringMap(currentNode);
            } else {
                backtrack.backtrack(closedList);
            }
        }
    }

    public boolean canColoring(Variable currentNode){
        return !currentNode.colors.colors.isEmpty();
    }

    public void coloringMap(Variable currentNode){
        currentNode.color = currentNode.colors.colors.get(0);
        currentNode.colors.colors.remove(currentNode.color);
        for (Variable adjacent : currentNode.getAdjacent()) {
            adjacent.colors.colors.remove(currentNode.color);
        }
    }


}
