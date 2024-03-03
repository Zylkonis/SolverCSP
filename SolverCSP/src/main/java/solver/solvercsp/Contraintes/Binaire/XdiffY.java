package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.Variable;

public class XdiffY extends Binaire{
    public XdiffY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public void evaluate(){
        //v1 != v2
//        X.changeDomain(Y, false);
//        Y.changeDomain(X, false);
    }
}
