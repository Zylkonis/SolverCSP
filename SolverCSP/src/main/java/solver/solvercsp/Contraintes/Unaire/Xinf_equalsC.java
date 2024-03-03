package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Contraintes.Unaire.Unaire;
import solver.solvercsp.Variable;

public class Xinf_equalsC extends Unaire {
    public Xinf_equalsC(Variable X, int C){
        super(X, C);
    }

    @Override
    public void evaluate(){
        //X <= C
//        X.changeDomain(min, C);
    }
}
