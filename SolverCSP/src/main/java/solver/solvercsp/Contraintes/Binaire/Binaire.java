package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.Contraintes.Contrainte;
import solver.solvercsp.Variable;

import java.util.Map;

public abstract class Binaire extends Contrainte{
    Binaire (Variable var1, Variable var2){
        super(var1, var2);
    }
}
