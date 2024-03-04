package solver.solvercsp.Contraintes;

import solver.solvercsp.Variable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Contrainte {
    protected Map<String, Variable> variableMap = new HashMap<>();

    protected int constante;
    protected int compteur = 1;
    public Contrainte(Variable v1){}
    public Contrainte(Variable v1, int constante){
        this.constante = constante;
        this.variableMap.put("var" + compteur, v1);
        compteur+=1;
    }
    public Contrainte(Variable v1, Variable v2){

    }
    public Contrainte(Map<String, Variable> varMap){

    }

    public void addVariable(String name, Variable value){
        this.variableMap.put(name, value);
    }

    public Variable getVariable(String name){
        return variableMap.get(name);
    }

    public int getConstante() {
        return constante;
    }

    public abstract void evaluate();

}
