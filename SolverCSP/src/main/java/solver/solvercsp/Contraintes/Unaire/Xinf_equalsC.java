package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Contraintes.Unaire.Unaire;
import solver.solvercsp.Variable;

public class Xinf_equalsC extends Unaire {
    public Xinf_equalsC(Variable var, int cst){
        super(var, cst);
    }

    @Override
    public void evaluate(){
        //X <= C
        this.var.infDomaine(this.cst + 1);
    }
}
