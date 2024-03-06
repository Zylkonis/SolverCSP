package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

public class XsupY extends Binaire {
    public XsupY(Variable v1, Variable v2) {
        super(v1, v2);
    }

    @Override
    public boolean evaluate() {
        //X > Y
        boolean filtre = false;
        filtre = filtre || super.var1.supDomaine(((IntDomaine) super.var2.getDomaine()).getMinDomaine());
        filtre = filtre || super.var2.infDomaine(((IntDomaine) super.var1.getDomaine()).getMaxDomaine());
        return filtre;
    }
}
