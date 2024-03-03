package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Contraintes.Contrainte;
import solver.solvercsp.Variable;

import java.util.Map;

public abstract class Unaire extends Contrainte {
    protected int constante;
    public Unaire(Variable var, int constante){
        super(var, constante);
    }


}
