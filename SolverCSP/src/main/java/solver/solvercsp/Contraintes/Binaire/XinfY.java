package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

public class XinfY extends Binaire{
    public XinfY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public void evaluate(){
        //X < Y
        IntDomaine d = (IntDomaine) super.var2.getDomaine();
        super.var1.infDomaine(d.getMaxDomaine());
    }
}
