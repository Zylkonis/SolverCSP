package solver.solvercsp.Contraintes.N_aire;

import solver.solvercsp.Contraintes.Binaire.XdiffY;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.SolverCSP;
import solver.solvercsp.Variable;

import java.util.HashMap;
import java.util.Map;

public class AllDifferent extends N_aire{
    public AllDifferent(Variable... vars){
        super(vars);
    }

    public boolean evaluate(){
        //System.out.println("ALL DIFFERENT START \n\n");
        //System.out.println("Valeurs de X2 :");
        //super.variableMap.get("var2").getDomaine().printDomain();
        //System.out.println("\n\n");
        // x != y != z != ...
        boolean filtre = false;
        for (int i = 0; i < super.compteurVar; i++) {
            Variable var1 = super.variableMap.get("var" + i);
            IntDomaine d1 = (IntDomaine) var1.getDomaine();
            if (d1.getCardDomaine() == 1){
                 for (int j = 0; j < super.compteurVar; j++) {
                     Variable var2 = super.variableMap.get("var" + j);
                     if (!var1.equals(var2)) {
                         int value = d1.getMinDomaine();
                         filtre = var2.diffDomaine(value) || filtre;
                     }
                 }
             }
         }
        return filtre;
    }
}