package solver.solvercsp.Contraintes.Unaire;

import solver.solvercsp.Contraintes.Unaire.Unaire;
import solver.solvercsp.Domaine;
import solver.solvercsp.Variable;

public class XsupC extends Unaire {
    public XsupC(Variable X, int C){
        super(X, C);
    }

    @Override
    public void evaluate(){
        //X > C
        Variable x = super.getVariable("var1");
        int constante = super.getConstante();

        x.supDomaine(constante);

    }
}
