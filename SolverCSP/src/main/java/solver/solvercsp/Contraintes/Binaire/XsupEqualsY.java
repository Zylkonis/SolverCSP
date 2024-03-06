package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.Domaine;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

public class XsupEqualsY extends Binaire {
    public XsupEqualsY(Variable v1, Variable v2) {
        super(v1, v2);
    }

    @Override
    public boolean evaluate() {
        //X>= Y
        boolean filtre = false;
        filtre = filtre || super.var1.supDomaine(((IntDomaine) super.var2.getDomaine()).getMinDomaine() - 1);
        filtre = filtre || super.var2.infDomaine(((IntDomaine) super.var1.getDomaine()).getMaxDomaine() + 1);
        Domaine d1 = super.var1.getDomaine();
        Domaine d2 = super.var2.getDomaine();
        if (d1.getDomain() == null || d2.getDomain() == null) {
            throw new NullPointerException("La variable est nulle");
        } else {
            return filtre;
        }
    }
}
