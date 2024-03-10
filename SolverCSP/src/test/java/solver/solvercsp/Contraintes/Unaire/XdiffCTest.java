package solver.solvercsp.Contraintes.Unaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.ExceptionDomNull;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XdiffCTest {

    @Test
    void evaluateStructurel() {
        //Dans ces deux cas la méthode doit renvoyer Null
        Variable testNull1 = new Variable("testNull1", new IntDomaine(10,10));
        XdiffC testNull1cont = new XdiffC(testNull1, 10);
        assertThrows(ExceptionDomNull.class, testNull1cont::evaluate, "Expected ExceptionDomNull to be thrown");
        assertNull(testNull1.getDomaine().getDomain(), "erreur: XdiffC testNull1cont");

        //Le domaine ne doit pas être modifié, la méthode doit donc renvoyer False
        Variable testFalse = new Variable("testFalse", new IntDomaine(1,10));
        XdiffC testFalseCont = new XdiffC(testFalse, 0);
        try {
            assertFalse(testFalseCont.evaluate());
            assertEquals(new IntDomaine(1, 10).getDomain(), testFalse.getDomaine().getDomain());
        } catch (ExceptionDomNull e) {
            fail("Unexpected ExceptionDomNull");
        }

        //Le domaine doit être modifié, la méthode doit donc renvoyer True
        Variable testTrue1 = new Variable("testTrue1", new IntDomaine(1,10));
        XdiffC testTrue1Cont = new XdiffC(testTrue1, 1);
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
//        XdiffC cont0 = new XdiffC(var0, 0);
//        //assertFalse(cont0.evaluate(), "erreur: XdiffC cont0 édition du domaine");
//        assertEquals(var0.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XdiffC cont0 édition du domaine");
//
//        Variable var1 = new Variable("x", new IntDomaine(1,10));
//        XdiffC cont1 = new XdiffC(var, -2);
//        //assertFalse(cont1.evaluate(), "erreur: XdiffC cont1 édition du domaine");
//        assertEquals(var1.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XdiffC cont1 édition du domaine");
//
//        Variable var2 = new Variable("x", new IntDomaine(1,10));
//        XdiffC cont2 = new XdiffC(var, 11);
//        //assertFalse(cont2.evaluate(), "erreur: XdiffC cont2 édition du domaine");
//        assertEquals(var2.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XdiffC cont2 édition du domaine");
//
//
//        // valeurs en borne du domaine
//        Variable var3 = new Variable("x", new IntDomaine(1,10));
//        XdiffC cont3 = new XdiffC(var, 1);
//        //assertTrue(cont3.evaluate(), "erreur: XdiffC cont3 domaine non édité");
//        assertNotEquals(var3.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XdiffC cont3 domaine non édité");
//        //test des bornes du domaines
//        //assertEquals(2,((IntDomaine)var3.getDomaine()).getMinDomaine(), "erreur: XdiffC cont3 minimum domaine incorrect");
//
//        Variable var4 = new Variable("x", new IntDomaine(1,10));
//        XdiffC cont4 = new XdiffC(var, 10);
//        //assertTrue(cont4.evaluate(), "erreur: XdiffC cont4 domaine non édité");
//        assertNotEquals(var4.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XdiffC cont4 domaine non édité");
//        //test des bornes du domaines
//        assertEquals(9,((IntDomaine)var4.getDomaine()).getMaxDomaine(), "erreur: XdiffC cont4 maximum domaine incorrect");
//
//        // valeurs dans le domaine
//        Variable var5 = new Variable("x", new IntDomaine(1,10));
//        XdiffC cont5 = new XdiffC(var, 5);
//        //assertTrue(cont5.evaluate(), "erreur: XdiffC cont5 domaine non édité");
//        assertNotEquals(var5.getDomaine().getDomain(), var.getDomaine().getDomain(), "erreur: XdiffC cont5 domaine non édité");
//        //test des bornes du domaines
//        assertEquals(1,((IntDomaine)var5.getDomaine()).getMinSousDomaine(0), "erreur: XdiffC cont5 minimum sous-domaine 0 incorrect");
//        assertEquals(4,((IntDomaine)var5.getDomaine()).getMaxSousDomaine(0), "erreur: XdiffC cont5 maximum sous-domaine 0 incorrect");
//        assertEquals(6,((IntDomaine)var5.getDomaine()).getMinSousDomaine(1), "erreur: XdiffC cont5 minimum sous-domaine 1 incorrect");
//        assertEquals(10,((IntDomaine)var5.getDomaine()).getMaxSousDomaine(1), "erreur: XdiffC cont5 maximum sous-domaine 1 incorrect");
//
//    }
}