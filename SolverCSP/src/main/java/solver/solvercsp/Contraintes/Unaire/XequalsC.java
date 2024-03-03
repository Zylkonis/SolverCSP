package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Contraintes.Unaire.Unaire;
import solver.solvercsp.Variable;

public class XequalsC extends Unaire {
    public XequalsC(Variable X, int C){
        super(X, C);
    }

    @Override
    public void evaluate(){
        //X == C
//        X.changeDomain(C, true);
    }
}
