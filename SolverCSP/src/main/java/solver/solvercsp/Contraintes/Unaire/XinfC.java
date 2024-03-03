package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Contraintes.Unaire.Unaire;
import solver.solvercsp.Variable;

public class XinfC extends Unaire {
    public XinfC(Variable X, int C){
        super(X, C);
    }

    @Override
    public void evaluate(){
        //X < C
//        X.changeDomain(min, C-1);
    }
}
