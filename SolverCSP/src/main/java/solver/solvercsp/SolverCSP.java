package solver.solvercsp;

import solver.solvercsp.Contraintes.Contrainte;

import java.util.HashMap;
import java.util.Map;

public class SolverCSP {
    private Map<String, Variable> variableMap;
    private Map<String, Contrainte> contrainteMap;
    private int compteurVar = 1;
    private int compteurCont = 1;

    public SolverCSP(){
        this.variableMap = new HashMap<>();
        this.contrainteMap = new HashMap<>();
    }

    public void addVariable(Variable var){
        this.variableMap.put("var" + compteurVar, var);
        compteurVar += 1;
    }

    public void addContrainte(Contrainte c){
        this.contrainteMap.put("cont" + compteurCont, c);
        compteurCont += 1;
    }

    public void evaluate(){
        for (int i = 1; i < compteurCont; i++){
            Contrainte x = contrainteMap.get("cont" + i);
            x.evaluate();
        }
        for (int j = 1 ; j < compteurVar; j++){
            Variable x = variableMap.get("var" + j);
            System.out.println(x.getName());
            IntDomaine d = (IntDomaine) x.getDomaine();
            d.printDomain();
        }
    }
}