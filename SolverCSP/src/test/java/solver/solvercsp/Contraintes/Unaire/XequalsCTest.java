package solver.solvercsp.Contraintes.Unaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.Domaine;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XequalsCTest {

    @Test
    void evaluate() {
        Variable var = new Variable("x", new IntDomaine(1,10));


        // valeurs en dehors du domaine
        Variable var0 = new Variable("x", new IntDomaine(1,10));
        XequalsC cont0 = new XequalsC(var0, 0);
        assertTrue(cont0.evaluate(), "erreur: XequalsC cont0 édition du domaine");
        //assertEquals(var0.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XequalsC cont0 édition du domaine");
        assertNull(var0.getDomaine());

        Variable var1 = new Variable("x", new IntDomaine(1,10));
        XequalsC cont1 = new XequalsC(var1, -2);
        assertTrue(cont1.evaluate(), "erreur: XequalsC cont1 édition du domaine");
        //assertEquals(var1.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XequalsC cont1 édition du domaine");
        assertNull(var1.getDomaine());


        Variable var2 = new Variable("x", new IntDomaine(1,10));
        XequalsC cont2 = new XequalsC(var2, 11);
        assertTrue(cont2.evaluate(), "erreur: XequalsC cont2 édition du domaine");
        //assertEquals(var2.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XequalsC cont2 édition du domaine");
        assertNull(var2.getDomaine());


        // valeurs en borne du domaine
        Variable var3 = new Variable("x", new IntDomaine(1,10));
        XequalsC cont3 = new XequalsC(var3, 1);
        assertTrue(cont3.evaluate(), "erreur: XequalsC cont3 domaine non édité");
        //assertNotEquals(var3.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XequalsC cont3 domaine non édité");
        assertEquals(1, ((IntDomaine)var3.getDomaine()).getMinSousDomaine(0), "erreur: XequalsC cont3 domaine incorrect");
        assertEquals(1, ((IntDomaine) var3.getDomaine()).getCardDomaine(), "erreur: XequalsC cont3 cardinalité incorrecte");


        Variable var4 = new Variable("x", new IntDomaine(1,10));
        XequalsC cont4 = new XequalsC(var4, 10);
        assertTrue(cont4.evaluate(), "erreur: XequalsC cont4 domaine non édité");
        //assertNotEquals(var4.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XequalsC cont4 domaine non édité");
        assertEquals(10, ((IntDomaine)var4.getDomaine()).getMinSousDomaine(0), "erreur: XequalsC cont4 domaine incorrect");
        assertEquals(1, ((IntDomaine) var4.getDomaine()).getCardDomaine(), "erreur: XequalsC cont4 cardinalité incorrecte");

        // valeurs dans le domaine
        Variable var5 = new Variable("x", new IntDomaine(1,10));
        XequalsC cont5 = new XequalsC(var5, 5);
        assertTrue(cont5.evaluate(), "erreur: XequalsC cont5 domaine non édité");
        //assertNotEquals(var5.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XequalsC cont5 domaine non édité");
        assertEquals(5, ((IntDomaine)var5.getDomaine()).getMinSousDomaine(0), "erreur: XequalsC cont5 domaine incorrect");
        assertEquals(1, ((IntDomaine) var5.getDomaine()).getCardDomaine(), "erreur: XequalsC cont5 cardinalité incorrecte");

    }
}