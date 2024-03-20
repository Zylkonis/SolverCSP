package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Domaine;
import solver.solvercsp.ExceptionDomNull;
import solver.solvercsp.Variable;

public class XsupEqualsC extends Unaire {
    public XsupEqualsC(Variable var, int cst){
        super(var, cst);
    }

    @Override
    public boolean evaluate() throws ExceptionDomNull {
        //X >= C
        boolean filtre = super.var.supDomaine(super.cst -1);
        Domaine d = super.var.getDomaine();
        if(d.getDomain() == null){
            throw new ExceptionDomNull("La variable est nulle");
        } else {
            return filtre;
        }
    }
}
