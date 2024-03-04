package solver.solvercsp;

import solver.solvercsp.Contraintes.Binaire.XinfY;
import solver.solvercsp.Contraintes.Contrainte;
import solver.solvercsp.Contraintes.Unaire.XinfC;
import solver.solvercsp.Contraintes.Unaire.XsupC;

public class Main {
    public static void main(String[] args){
        Variable x = new Variable("x", new IntDomaine(-10,100));
        Variable y = new Variable("y", new IntDomaine(5,5));
        Contrainte c = new XinfY(x, y);
//        Contrainte c1 = new XinfC(x, 10);
        SolverCSP csp = new SolverCSP();


        csp.addVariable(x);
        csp.addVariable(y);
        csp.addContrainte(c);

        csp.evaluate();
    }
}
