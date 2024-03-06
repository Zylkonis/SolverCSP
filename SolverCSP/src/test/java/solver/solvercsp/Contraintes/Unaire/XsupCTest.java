package solver.solvercsp.Contraintes.Unaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XsupCTest {

    @Test
    void evaluate() {
        IntDomaine dom = new IntDomaine(1,10);
        dom.getDomain().put()
        Variable var1 = new Variable("x", );
        Variable var2 = new Variable("x", new IntDomaine(1,10));
        Variable var3 = new Variable("x", new IntDomaine(1,10));
        Variable var4 = new Variable("x", new IntDomaine(1,10));
        Variable var5 = new Variable("x", new IntDomaine(1,10));

        // valeurs en dehors du domaine
        XsupC cont0 = new XsupC(var1, 0);
        XsupC cont11 = new XsupC(var2, 11);

        // valeurs en borne du domaine
        XsupC cont1 = new XsupC(var3, 1);
        XsupC cont10 = new XsupC(var4, 10);

        // valeurs dans le domaine
        XsupC cont5 = new XsupC(var5, 5);

        assertEquals(var1.getDomaine(), new IntDomaine(1, 10), "erreur: XsupC cont0");
        assertNull(var2.getDomaine(), "erreur: XsupC cont11");

        assertEquals(var3.getDomaine(), new IntDomaine(1, 10), "erreur: XsupC cont1");
        assertNull(var4.getDomaine(), "erreur: XsupC cont10");

        assertEquals(var5.getDomaine(), new IntDomaine(6, 10), "erreur: XsupC cont5");
    }
}