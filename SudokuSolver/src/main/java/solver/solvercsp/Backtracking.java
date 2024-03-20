package solver.solvercsp;

import java.util.HashMap;
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

    public void add(Map<String, Variable> copy, String name, int tmp, int size) {
        copyVars(copy, name, tmp, size);
    }

    public Map<String, Variable> getHead(){
        return pileBactrack.pop();
    }

    public Map<String, Variable> seeHead(){
        return pileBactrack.peek();
    }

    public boolean isEmpty() {
        return this.pileBactrack.empty();
    }

    public void copyVars(Map<String, Variable> copy, String name, int tmp, int size){
        Map<String, Variable> vars = new HashMap<>();
        for (int i = 1; i < size; i++){
            vars.put("var" + i, new Variable(copy.get("var" + i)));
        }
        IntDomaine d = (IntDomaine) vars.get(name).getDomaine();
        d.supDomaine(tmp);
        pileBactrack.add(vars);
    }
}
