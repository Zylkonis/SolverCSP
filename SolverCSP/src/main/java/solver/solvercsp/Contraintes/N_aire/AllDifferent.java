package solver.solvercsp.Contraintes.N_aire;

import solver.solvercsp.Variable;

import java.util.Map;

public class AllDifferent extends N_aire{
    public AllDifferent(Map<String, Variable> varMap){
        super(varMap);
    }

    public void evaluate(){
        // x != y != z != ...
        for (int i = 0; i < super.compteur - 1; i++){
            for (int j = i; j < super.compteur; j++){
                super.variableMap.get("var" + i)
            }
        }
    }
}
