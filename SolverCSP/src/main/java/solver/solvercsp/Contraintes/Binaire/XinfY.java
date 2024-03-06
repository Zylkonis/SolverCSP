package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

public class XinfY extends Binaire{
    public XinfY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public boolean evaluate(){
        //X < Y
        boolean filtre = false;
        filtre = filtre || super.var2.supDomaine(((IntDomaine) super.var1.getDomaine()).getMinDomaine());
        filtre = filtre || super.var1.infDomaine(((IntDomaine) super.var2.getDomaine()).getMaxDomaine());
        return filtre;
    }
}
