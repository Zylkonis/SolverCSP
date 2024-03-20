package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.Domaine;
import solver.solvercsp.ExceptionDomNull;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

public class XinfEqualsY extends Binaire{
    public XinfEqualsY(Variable v1, Variable v2) { super(v1, v2); }

    @Override
    public boolean evaluate() throws ExceptionDomNull {
        //X <= Y
        boolean filtre = false;
        filtre = super.var1.infDomaine(((IntDomaine) super.var2.getDomaine()).getMaxDomaine() + 1) || filtre;
        Domaine d1 = super.var1.getDomaine();
        if(d1.getDomain() == null) {
            throw new ExceptionDomNull("La variable est nulle");
        }
        filtre = super.var2.supDomaine(((IntDomaine) super.var1.getDomaine()).getMinDomaine() - 1) || filtre;
        Domaine d2 = super.var2.getDomaine();
        if(d2.getDomain() == null) {
            throw new ExceptionDomNull("La variable est nulle");
        }
        return filtre;
    }
}
