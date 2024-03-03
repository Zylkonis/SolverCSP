package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.Variable;

public class XinfY extends Binaire{
    public XinfY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public void evaluate(){
        //X < Y
//        X.changeDomain(min, Y-1);
//        Y.changeDomain(X+1, max);
    }
}
