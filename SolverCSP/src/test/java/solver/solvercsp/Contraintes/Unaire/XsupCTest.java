package solver.solvercsp.Contraintes.Unaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XsupCTest {

    @Test
    void evaluate() {
        Variable var1 = new Variable("x1", new IntDomaine(1,10));
        Variable var2 = new Variable("x2", new IntDomaine(1,10));
        Variable var3 = new Variable("x3", new IntDomaine(1,10));
        Variable var4 = new Variable("x4", new IntDomaine(1,10));
        Variable var5 = new Variable("x5", new IntDomaine(1,10));

        // valeurs en dehors du domaine
        XsupC cont0 = new XsupC(var1, 0);
        XsupC cont11 = new XsupC(var2, 11);

        // valeurs en borne du domaine
        XsupC cont1 = new XsupC(var3, 1);
        XsupC cont10 = new XsupC(var4, 10);

        // valeurs dans le domaine
        XsupC cont5 = new XsupC(var5, 5);

        assertFalse(cont0.evaluate());
        assertEquals(new IntDomaine(1, 10).getDomain(), var1.getDomaine().getDomain(), "erreur: XsupC cont0");

        assertThrows(NullPointerException.class, cont11::evaluate, "Expected NullPointerException to be thrown");
        assertNull(var2.getDomaine().getDomain(), "erreur: XsupC cont11");


        assertTrue(cont1.evaluate());
        assertEquals(new IntDomaine(2, 10).getDomain(), var3.getDomaine().getDomain(),"erreur: XsupC cont1");

        assertThrows(NullPointerException.class, cont10::evaluate, "Expected NullPointerException to be thrown");
        assertNull(var4.getDomaine().getDomain(), "erreur: XsupC cont10");

        assertTrue(cont5.evaluate());
        assertEquals(new IntDomaine(6, 10).getDomain(), var5.getDomaine().getDomain(),"erreur: XsupC cont5");
    }
}