package solver.solvercsp.Contraintes.Unaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XdiffCTest {

    @Test
    void evaluate() {
        Variable var0 = new Variable("x0", new IntDomaine(1,10));
        Variable var = new Variable("x", new IntDomaine(1,10));

        // valeurs en dehors du domaine
        XdiffC cont0 = new XdiffC(var, 0);
        assertEquals(1, cont0.evaluate(), "r");

        XdiffC cont1 = new XdiffC(var, -2);
        XdiffC cont2 = new XdiffC(var, 11);

        // valeurs en borne du domaine
        XdiffC cont3 = new XdiffC(var, 1);
        XdiffC cont4 = new XdiffC(var, 10);

        // valeurs dans le domaine
        XdiffC cont5 = new XdiffC(var, 5);


    }
}