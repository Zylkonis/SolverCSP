package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Contraintes.Unaire.Unaire;
import solver.solvercsp.Variable;

public class Xinf_equalsC extends Unaire {
    public Xinf_equalsC(Variable var, int cst){
        super(var, cst);
    }

    @Override
    public boolean evaluate(){
        //X <= C
        return super.var.infDomaine(super.cst + 1);
    }
}
