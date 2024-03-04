package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Contraintes.Unaire.Unaire;
import solver.solvercsp.Variable;

public class Xsup_equalsC extends Unaire {
    public Xsup_equalsC(Variable var, int cst){
        super(var, cst);
    }

    @Override
    public void evaluate(){
        //X >= C
        this.var.supDomaine(this.cst - 1);
    }
}
