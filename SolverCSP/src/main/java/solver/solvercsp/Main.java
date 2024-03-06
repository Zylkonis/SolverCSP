package solver.solvercsp;

import solver.solvercsp.Contraintes.Binaire.*;
import solver.solvercsp.Contraintes.Contrainte;
import solver.solvercsp.Contraintes.N_aire.AllDifferent;
import solver.solvercsp.Contraintes.Unaire.XsupC;

public class Main {
    public static void main(String[] args){
//        Variable x1 = new Variable("x1", new IntDomaine(1,1));
//        Variable x2 = new Variable("x2", new IntDomaine(1,2));
//        Variable x3 = new Variable("x3", new IntDomaine(1,3));
        Variable x4 = new Variable("x4", new IntDomaine(1,4));
//        Contrainte c1 = new AllDifferent(x3,x4,x2,x1);
        Contrainte c2 = new XsupC(x4, 4);
//        Contrainte c1 = new XequalsY(x3,x4);
//        Contrainte c1 = new Xsup_equalsY(x4, x3);

        SolverCSP csp = new SolverCSP();


        csp.addVariable(x4);
//        csp.addVariable(x3);
//        csp.addVariable(x2);
//        csp.addVariable(x1);
//        csp.addContrainte(c1);
        csp.addContrainte(c2);

        csp.evaluate();
    }
}
