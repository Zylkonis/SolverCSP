package solver.solvercsp.Contraintes.Unaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XinfCTest {

    @Test
    void evaluate() {
        //IntDomaine dom = new IntDomaine(1,10);
        //dom.getDomain().put()
        Variable var1 = new Variable("x", new IntDomaine(1,10));
        Variable var2 = new Variable("x", new IntDomaine(1,10));
        Variable var3 = new Variable("x", new IntDomaine(1,10));
        Variable var4 = new Variable("x", new IntDomaine(1,10));
        Variable var5 = new Variable("x", new IntDomaine(1,10));

        // valeurs en dehors du domaine
        XinfC cont0 = new XinfC(var1, 0);
        XinfC cont11 = new XinfC(var2, 11);

        // valeurs en borne du domaine
        XinfC cont1 = new XinfC(var3, 1);
        XinfC cont10 = new XinfC(var4, 10);

        // valeurs dans le domaine
        XinfC cont5 = new XinfC(var5, 5);

        assertTrue(cont0.evaluate());
        assertNull(var1.getDomaine().getDomain(), "erreur: XinfC cont0");

        assertFalse(cont11.evaluate());
        assertEquals(new IntDomaine(1, 10).getDomain(), var2.getDomaine().getDomain(),"erreur: XinfC cont11");

        assertTrue(cont1.evaluate());
        assertNull(var3.getDomaine().getDomain(), "erreur: XinfC cont1");

        assertTrue(cont10.evaluate());
        assertEquals(new IntDomaine(1, 9).getDomain(), var4.getDomaine().getDomain(), "erreur: XinfC cont10");

        assertTrue(cont5.evaluate());
        assertEquals(new IntDomaine(1, 4).getDomain(), var5.getDomaine().getDomain(), "erreur: XinfC cont5");
    }
}