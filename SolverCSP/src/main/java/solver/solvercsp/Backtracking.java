package solver.solvercsp;

import java.util.Map;
import java.util.Stack;

public class Backtracking {
    /**
     * maPile.push(10);--> met dans la pile
     * elementSupprime = maPile.pop(); --> retire et récupère
     * elementHaut = maPile.peek(); --> accède
     */
    Stack<Map<String, Variable>> pileBactrack = new Stack<>();
    public Backtracking(){}

    public void add(Map<String, Variable> etat) {
        this.pileBactrack.add(etat);
    }

    public Map<String, Variable> getHead(){
        return pileBactrack.pop();
    }

    public boolean isEmpty() {
        return this.pileBactrack.empty();
    }
}
