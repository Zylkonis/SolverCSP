package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

public class XdiffY extends Binaire{
    public XdiffY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public void evaluate(){
        //v1 != v2
        IntDomaine d1 = (IntDomaine) super.var1.getDomaine();
        IntDomaine d2 = (IntDomaine) super.var2.getDomaine();
        if ( d1.getSizeDomaine() == 1 ){
            int value = d1.getMinDomaine();
            super.var2.diffDomaine(value);
        }
        if ( d2.getSizeDomaine() == 1 ){
            int value = d2.getMinDomaine();
            super.var1.diffDomaine(value);
        }
    }
}
