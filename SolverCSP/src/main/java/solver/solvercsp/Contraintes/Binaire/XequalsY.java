package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.Variable;

public class XequalsY extends Binaire{
    public XequalsY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public void evaluate(){
        //X == v2
        //X.changeDomain(Y, true);
        //Y.changeDomain(X, true);
    }
}
