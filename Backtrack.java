import java.util.List;
import java.util.Stack;

public class Backtrack
{
    Stack<Variable> tempTrack = new Stack<>();;

    public void backtrack(Stack<Variable> closedList ){
        Variable firstNode = closedList.pop();
        tempTrack.push(firstNode);
        if (!closedList.isEmpty()) backtracking(closedList);
        if (!tempTrack.isEmpty()) {
            closedList.push(tempTrack.pop());
        }
    }

    private void backtracking(Stack<Variable> closedList){
        if (!closedList.isEmpty()) {
            Variable currentNode = closedList.pop();
            tempTrack.push(currentNode);
            int check = reColoring(currentNode);
            if (check == 2) {
                backtracking(closedList);
            } else if (check == 1) {
                closedList.push(tempTrack.pop());
                backtracking(closedList);
            } else {
                closedList.push(tempTrack.pop());
            }
        } else {
            System.exit(0);
        }
    }

    int reColoring(Variable current){
        constraint(current);
        for (String c : current.domain.baseColors){
            if (!current.domain.constraintColor.contains(c)){
                current.color = c;
            }
        }

        boolean validate = false;
        for (Variable node:current.getAdjacent()) {
            if (node != current && node.color == current.color) {
                validate = true;
                break;
            }
        }

        if ((current.domain.tryColor.contains(current.color) &&
                (current.domain.tryColor.size() == (current.domain.baseColors.size() - current.domain.constraintColor.size()) ||
                        0 == (current.domain.baseColors.size() - current.domain.constraintColor.size())))) {
            current.domain.tryColor.clear();
            current.color = null;
            return 2;
        } else if (current.domain.tryColor.contains(current.color) || validate){
            current.domain.tryColor.remove(current.color);
            return 1;
        } else {
            if (!current.domain.tryColor.contains(current.color)) current.domain.tryColor.add(current.color);
            return 0;
        }
    }

    public void constraint(Variable currentNode){
        currentNode.domain.constraintColor.clear();
        for (Variable adjacent : currentNode.getAdjacent()) {
            if (adjacent.color != null && adjacent!=currentNode && !currentNode.domain.constraintColor.contains(adjacent.color)) currentNode.domain.constraintColor.add(adjacent.color);;
        }
    }
}