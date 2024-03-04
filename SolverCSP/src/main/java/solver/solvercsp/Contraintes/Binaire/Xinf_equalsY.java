package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.Variable;

public class Xinf_equalsY extends Binaire{
    public Xinf_equalsY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public void evaluate(){
//        this.getVariable("var1").infDomaine((Integer.this.getVariable("var2"))+1);
        //X <= Y
//        X.changeDomain(min, Y);
//        Y.changeDomain(X, max);
    }
}
