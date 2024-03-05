package solver.solvercsp;

import solver.solvercsp.Contraintes.Binaire.XequalsY;
import solver.solvercsp.Contraintes.Binaire.XinfY;
import solver.solvercsp.Contraintes.Contrainte;
import solver.solvercsp.Contraintes.N_aire.AllDifferent;
import solver.solvercsp.Contraintes.Unaire.XinfC;
import solver.solvercsp.Contraintes.Unaire.XsupC;

public class Main {
    public static void main(String[] args){
//        Variable x1 = new Variable("x1", new IntDomaine(1,1));
//        Variable x2 = new Variable("x2", new IntDomaine(1,2));
//        Variable x3 = new Variable("x3", new IntDomaine(1,3));
//        Variable x4 = new Variable("x4", new IntDomaine(1,4));
//        Contrainte c1 = new AllDifferent(x4, x3, x2, x1);
//
//        SolverCSP csp = new SolverCSP();
//
//
//        csp.addVariable(x1);
//        csp.addVariable(x2);
//        csp.addVariable(x3);
//        csp.addVariable(x4);
//        csp.addContrainte(c1);
//
//        csp.evaluate();

        Variable x1 = new Variable("x1", new IntDomaine(0,5));
        IntDomaine d =(IntDomaine) x1.getDomaine();
        d.addSousDomaine(9,10);
        d.addSousDomaine(12,14);
        Variable x2 = new Variable("x2", new IntDomaine(1,6));
        IntDomaine d2 =(IntDomaine) x2.getDomaine();
        d2.addSousDomaine(8,15);
        Contrainte c1 = new XequalsY(x1, x2);
//        Contrainte c2 = new XequalsY(x1, x2);
        SolverCSP csp = new SolverCSP();


        csp.addVariable(x1);
        csp.addVariable(x2);
        csp.addContrainte(c1);
//        csp.addContrainte(c2);

        csp.evaluate();
    }
}
