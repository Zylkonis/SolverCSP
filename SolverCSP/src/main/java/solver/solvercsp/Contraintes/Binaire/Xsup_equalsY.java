package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.Variable;

public class Xsup_equalsY extends Binaire{
    public Xsup_equalsY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public void evaluate(){
        //X >= Y
//        X.changeDomain(Y, max);
//        Y.changeDomain(min, X);
    }
}
