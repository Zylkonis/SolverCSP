package solver.solvercsp;

import solver.solvercsp.Contraintes.Binaire.*;
import solver.solvercsp.Contraintes.Contrainte;
import solver.solvercsp.Contraintes.N_aire.AllDifferent;
import solver.solvercsp.Contraintes.Unaire.XsupC;

public class Main {
    public static void main(String[] args){
        Variable x1 = new Variable("x1", new IntDomaine(4,4));
        x1.getDomaine().addSousDomaine(1,7,9);
        Variable x2 = new Variable("x2", new IntDomaine(5,5));
        x2.getDomaine().addSousDomaine(1, 7, 12);
        Variable x3 = new Variable("x3", new IntDomaine(5,6));
        x3.getDomaine().addSousDomaine(1, 10, 15);
        Variable x4 = new Variable("x4", new IntDomaine(4,8));
        x4.getDomaine().addSousDomaine(1, 12, 17);
        x1.getDomaine().printDomain();
        x2.getDomaine().printDomain();
        x3.getDomaine().printDomain();
        x4.getDomaine().printDomain();



        Contrainte c1 = new XdiffY(x1,x2);
        Contrainte c2 = new XinfY(x2, x3);
        Contrainte c3 = new XsupY(x3,x4);
        Contrainte c4 = new XdiffY(x1, x4);

        SolverCSP csp = new SolverCSP();



        csp.addVariable(x1);
        csp.addVariable(x2);
        csp.addVariable(x3);
        csp.addVariable(x4);

        csp.addContrainte(c1);
        csp.addContrainte(c2);
        csp.addContrainte(c3);
        csp.addContrainte(c4);

        csp.evaluate();
    }
}
