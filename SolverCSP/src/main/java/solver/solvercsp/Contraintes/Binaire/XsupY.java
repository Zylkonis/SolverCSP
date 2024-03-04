package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

public class XsupY extends Binaire {
    public XsupY(Variable v1, Variable v2) {
        super(v1, v2);
    }

    @Override
    public void evaluate() {
        //X > Y
        var1.getDomaine().supDomaine(((IntDomaine) var2.getDomaine()).getMinDomaine() + 1);
        var2.getDomaine().infDomaine(((IntDomaine) var1.getDomaine()).getMinDomaine() - 1);
    }
}
