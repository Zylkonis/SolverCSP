package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.Contraintes.Contrainte;
import solver.solvercsp.Variable;

import java.util.Map;

public abstract class Binaire extends Contrainte{
    protected Variable var1;
    protected Variable var2;

    Binaire (Variable var1, Variable var2){
        this.var1 = var1;
        this.var2 = var2;
    }

}
