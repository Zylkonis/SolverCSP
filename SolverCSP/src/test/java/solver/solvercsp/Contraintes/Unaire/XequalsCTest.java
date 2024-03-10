package solver.solvercsp.Contraintes.Unaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.Domaine;
import solver.solvercsp.ExceptionDomNull;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XequalsCTest {

    @Test
    void evaluateStructurel() {
        //Dans ces deux cas la méthode doit renvoyer Null
        Variable testNull1 = new Variable("testNull1", new IntDomaine(1,10));
        XequalsC testNull1cont = new XequalsC(testNull1, 0);
        assertThrows(ExceptionDomNull.class, testNull1cont::evaluate, "Expected ExceptionDomNull to be thrown");
        assertNull(testNull1.getDomaine().getDomain(), "erreur: XequalsC testNull1cont");

        Variable testNull2 = new Variable("testNull2", new IntDomaine(1,10));
        XequalsC testNull2cont = new XequalsC(testNull2, 11);
        assertThrows(ExceptionDomNull.class, testNull2cont::evaluate, "Expected ExceptionDomNull to be thrown");
        assertNull(testNull2.getDomaine().getDomain(), "erreur: XequalsC testNull2cont");

        //Le domaine ne doit pas être modifié, la méthode doit donc renvoyer False
        Variable testFalse = new Variable("testFalse", new IntDomaine(10,10));
        XequalsC testFalseCont = new XequalsC(testFalse, 10);
        try {
            assertFalse(testFalseCont.evaluate());
            assertEquals(new IntDomaine(10, 10).getDomain(), testFalse.getDomaine().getDomain());
        } catch (ExceptionDomNull e) {
            fail("Unexpected ExceptionDomNull");
        }

        //Le domaine doit être modifié, la méthode doit donc renvoyer True
        Variable testTrue1 = new Variable("testTrue1", new IntDomaine(1,10));
        XequalsC testTrue1Cont = new XequalsC(testTrue1, 1);
        try {
            assertTrue(testTrue1Cont.evaluate());
            assertNotEquals(new IntDomaine(1, 10).getDomain(), testTrue1.getDomaine().getDomain());
        } catch (ExceptionDomNull e) {
            fail("Unexpected ExceptionDomNull");
        }
    }

//    @Test
//    void evaluate() {
//        Variable var = new Variable("x", new IntDomaine(1,10));
//
//
//        // valeurs en dehors du domaine
//        Variable var0 = new Variable("x", new IntDomaine(1,10));
//        XequalsC cont0 = new XequalsC(var0, 0);
//        assertTrue(cont0.evaluate(), "erreur: XequalsC cont0 édition du domaine");
//        //assertEquals(var0.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XequalsC cont0 édition du domaine");
//        assertNull(var0.getDomaine());
//
//        Variable var1 = new Variable("x", new IntDomaine(1,10));
//        XequalsC cont1 = new XequalsC(var1, -2);
//        assertTrue(cont1.evaluate(), "erreur: XequalsC cont1 édition du domaine");
//        //assertEquals(var1.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XequalsC cont1 édition du domaine");
//        assertNull(var1.getDomaine());
//
//
//        Variable var2 = new Variable("x", new IntDomaine(1,10));
//        XequalsC cont2 = new XequalsC(var2, 11);
//        assertTrue(cont2.evaluate(), "erreur: XequalsC cont2 édition du domaine");
//        //assertEquals(var2.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XequalsC cont2 édition du domaine");
//        assertNull(var2.getDomaine());
//
//
//        // valeurs en borne du domaine
//        Variable var3 = new Variable("x", new IntDomaine(1,10));
//        XequalsC cont3 = new XequalsC(var3, 1);
//        assertTrue(cont3.evaluate(), "erreur: XequalsC cont3 domaine non édité");
//        //assertNotEquals(var3.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XequalsC cont3 domaine non édité");
//        assertEquals(1, ((IntDomaine)var3.getDomaine()).getMinSousDomaine(0), "erreur: XequalsC cont3 domaine incorrect");
//        assertEquals(1, ((IntDomaine) var3.getDomaine()).getCardDomaine(), "erreur: XequalsC cont3 cardinalité incorrecte");
//
//
//        Variable var4 = new Variable("x", new IntDomaine(1,10));
//        XequalsC cont4 = new XequalsC(var4, 10);
//        assertTrue(cont4.evaluate(), "erreur: XequalsC cont4 domaine non édité");
//        //assertNotEquals(var4.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XequalsC cont4 domaine non édité");
//        assertEquals(10, ((IntDomaine)var4.getDomaine()).getMinSousDomaine(0), "erreur: XequalsC cont4 domaine incorrect");
//        assertEquals(1, ((IntDomaine) var4.getDomaine()).getCardDomaine(), "erreur: XequalsC cont4 cardinalité incorrecte");
//
//        // valeurs dans le domaine
//        Variable var5 = new Variable("x", new IntDomaine(1,10));
//        XequalsC cont5 = new XequalsC(var5, 5);
//        assertTrue(cont5.evaluate(), "erreur: XequalsC cont5 domaine non édité");
//        //assertNotEquals(var5.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XequalsC cont5 domaine non édité");
//        assertEquals(5, ((IntDomaine)var5.getDomaine()).getMinSousDomaine(0), "erreur: XequalsC cont5 domaine incorrect");
//        assertEquals(1, ((IntDomaine) var5.getDomaine()).getCardDomaine(), "erreur: XequalsC cont5 cardinalité incorrecte");
//
//    }
}