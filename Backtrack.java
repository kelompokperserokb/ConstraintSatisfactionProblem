import java.util.List;
import java.util.Stack;

public class Backtrack
{
    Stack<Variable> tempTrack = new Stack<>();;

    public void backtrack(List<Variable> closedList ){
        copyList(closedList);
        backtracking();
    }

    private void backtracking(){
        Variable currentNode = tempTrack.pop();
        if (reColoring(currentNode)) {
            backtracking();
        }
    }

    void copyList(List<Variable> closedList){
        for (Variable node:closedList) {
            tempTrack.push(node);
        }
        tempTrack.pop();
    }

    boolean reColoring(Variable current){
        String tempColor = current.color;
        if (!current.colors.colors.contains(current.color)) current.colors.colors.add(current.color);
        for (Variable node:current.getAdjacent()) {
            if (!node.colors.colors.contains(current.color)) node.colors.colors.add(current.color);
        }
        current.color = current.colors.colors.get(0);
        return current.color.equals(tempColor);
    }
}