package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Contraintes.Contrainte;
import solver.solvercsp.Variable;

import java.util.Map;

public abstract class Unaire extends Contrainte {
    protected Variable var;
    protected int cst;

    public Unaire(Variable var, int cst){
        this.var = var;
        this.cst = cst;
    }

}
