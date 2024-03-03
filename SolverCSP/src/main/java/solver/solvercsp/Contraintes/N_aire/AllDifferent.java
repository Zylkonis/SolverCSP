package solver.solvercsp.Contraintes.N_aire;

import solver.solvercsp.Variable;

import java.util.Map;

public class AllDifferent extends N_aire{
    public AllDifferent(Map<String, Variable> varMap){
        super(varMap);
    }

    public void evaluate(){
        // x != y != z != ...
//        X.changeDomain(constante, max);
    }
}
