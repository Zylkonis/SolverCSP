package solver.solvercsp.Contraintes.Unaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class Xsup_equalsCTest {

    @Test
    void evaluate() {
        Variable var1 = new Variable("x", new IntDomaine(1,10));

        // valeurs en dehors du domaine
        Xsup_equalsC cont1 = new Xsup_equalsC(var1, 0);
        cont1.evaluate();
        assertEquals(1, ((IntDomaine) var1.getDomaine()).getMinDomaine());
        assertEquals(10, ((IntDomaine) var1.getDomaine()).getMaxDomaine());


        Xsup_equalsC cont2 = new Xsup_equalsC(var1, 11);
        cont2.evaluate();
        assertNull((var1.getDomaine()));


        Variable var2 = new Variable("x", new IntDomaine(1,10));
        // valeurs en borne du domaine
        Xsup_equalsC cont3 = new Xsup_equalsC(var2, 1);
        cont3.evaluate();
        assertEquals(1, ((IntDomaine) var1.getDomaine()).getMinDomaine());
        assertEquals(10, ((IntDomaine) var1.getDomaine()).getMaxDomaine());



        Xsup_equalsC cont4 = new Xsup_equalsC(var2, 10);
        cont4.evaluate();
        assertEquals(10, ((IntDomaine) var1.getDomaine()).getMinDomaine());
        assertEquals(10, ((IntDomaine) var1.getDomaine()).getMaxDomaine());



        // valeurs dans le domaine
        XsupC cont5 = new XsupC(var3, 5);

        assertEquals();
    }
}