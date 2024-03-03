package solver.solvercsp.Contraintes.N_aire;

import solver.solvercsp.Contraintes.Contrainte;
import solver.solvercsp.Variable;

import java.util.Map;

public abstract class N_aire extends Contrainte {
    public N_aire(Map<String, Variable> varMap){
        super(varMap);
    }
}
