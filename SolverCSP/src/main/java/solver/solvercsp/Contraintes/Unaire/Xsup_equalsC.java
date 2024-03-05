package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Contraintes.Unaire.Unaire;
import solver.solvercsp.Variable;

public class Xsup_equalsC extends Unaire {
    public Xsup_equalsC(Variable var, int cst){
        super(var, cst);
    }

    @Override
    public boolean evaluate(){
        //X >= C
        return super.var.supDomaine(super.cst - 1);
    }
}
