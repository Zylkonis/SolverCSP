package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

public class Xsup_equalsY extends Binaire{
    public Xsup_equalsY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public void evaluate(){
        //X>= Y
        var1.supDomaine(((IntDomaine) var2.getDomaine()).getMinDomaine());
        var2.infDomaine(((IntDomaine) var1.getDomaine()).getMaxDomaine());
    }
}
