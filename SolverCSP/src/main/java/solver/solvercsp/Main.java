package solver.solvercsp;

import solver.solvercsp.Contraintes.Contrainte;
import solver.solvercsp.Contraintes.Unaire.XinfC;
import solver.solvercsp.Contraintes.Unaire.XsupC;

public class Main {
    public static void main(String[] args){
        SolverCSP csp = new SolverCSP();

        Variable x = new Variable("x", new IntDomaine(1,9));
        Contrainte c = new XsupC(x, 5);
        Contrainte c1 = new XinfC(x, 7);
        csp.addVariable(x);
        csp.addContrainte(c);
        csp.addContrainte(c1);
        csp.evaluate();
    }

}
