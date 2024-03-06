package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Domaine;
import solver.solvercsp.Variable;

public class XsupEqualsC extends Unaire {
    public XsupEqualsC(Variable var, int cst){
        super(var, cst);
    }

    @Override
    public boolean evaluate(){
        //X >= C
        boolean filtre = super.var.supDomaine(super.cst -1);
        Domaine d = super.var.getDomaine();
        if(d.getDomain() == null){
            throw new NullPointerException("La variable est nulle");
        } else {
            return filtre;
        }
    }
}
