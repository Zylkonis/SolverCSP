package solver.solvercsp;

import java.util.Stack;

public class Backtracking {
    /**
     * maPile.push(10);--> met dans la pile
     * elementSupprime = maPile.pop(); --> retire et récupère
     * elementHaut = maPile.peek(); --> accède
     */
    Stack<Variable> pileBactrack = new Stack<>();
    public Backtracking(){}

    public void add(Variable var){
        this.pileBactrack.push(var);
    }

    public Variable getHead(){
        return pileBactrack.peek();
    }

    public void removeHead(){
        pileBactrack.pop();
    }
}
