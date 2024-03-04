package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.Variable;

public class XdiffY extends Binaire{
    public XdiffY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public void evaluate(){
        this.getVariable("var1").diffDomaine(this.getVariable("var2"));
        this.getVariable("var2").diffDomaine(this.getVariable("var1"));
        //v1 != v2
//        X.changeDomain(Y, false);
//        Y.changeDomain(X, false);
    }
}
