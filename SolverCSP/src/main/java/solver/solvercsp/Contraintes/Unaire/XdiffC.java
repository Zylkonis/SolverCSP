package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Contraintes.Unaire.Unaire;
import solver.solvercsp.Variable;

public class XdiffC extends Unaire {
    public XdiffC(Variable var, int cst){
        super(var, cst);
    }

    @Override
    public void evaluate(){
        //X != C
        this.var.diffDomaine(this.cst);
    }
}
