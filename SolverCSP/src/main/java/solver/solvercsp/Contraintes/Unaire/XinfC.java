package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Contraintes.Unaire.Unaire;
import solver.solvercsp.Variable;

public class XinfC extends Unaire {
    public XinfC(Variable var, int cst){
        super(var, cst);
    }

    @Override
    public boolean evaluate(){
        //X < C
        return super.var.infDomaine(super.cst);
    }
}
