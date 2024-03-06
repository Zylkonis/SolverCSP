package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Contraintes.Unaire.Unaire;
import solver.solvercsp.Domaine;
import solver.solvercsp.Variable;

public class XinfC extends Unaire {
    public XinfC(Variable var, int cst){
        super(var, cst);
    }

    @Override
    public boolean evaluate(){
        //X < C
        boolean filtre = super.var.infDomaine(super.cst);
        Domaine d = super.var.getDomaine();
        if(d.getDomain() == null){
            throw new NullPointerException("La variable est nulle");
        } else {
            return filtre;
        }
    }
}
