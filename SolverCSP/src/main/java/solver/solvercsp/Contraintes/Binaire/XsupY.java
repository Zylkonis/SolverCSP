package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.Variable;

public class XsupY extends Binaire{
    public XsupY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public void evaluate(){
        //X > Y
//        X.changeDomain(Y+1, max);
//        Y.changeDomain(min, X-1);
    }
}
