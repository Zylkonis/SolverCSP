package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Contraintes.Unaire.Unaire;
import solver.solvercsp.Variable;

public class XequalsC extends Unaire {
    public XequalsC(Variable var, int cst){
        super(var, cst);
    }

    @Override
    public void evaluate(){
        //X == C
        this.var.egalDomaine(this.cst);
    }
}
