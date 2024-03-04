package solver.solvercsp.Contraintes.N_aire;

import solver.solvercsp.Contraintes.Contrainte;
import solver.solvercsp.Variable;

import java.util.HashMap;
import java.util.Map;

public abstract class N_aire extends Contrainte {
    protected Map<String, Variable> variableMap = new HashMap<>();
    protected int compteur = 0;
    public N_aire(Map<String, Variable> varMap) {
        this.variableMap = varMap;
        this.compteur = varMap.size();
    }
}
