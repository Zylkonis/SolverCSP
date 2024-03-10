package solver.solvercsp.Contraintes.Unaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.ExceptionDomNull;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XinfEqualsCTest {

    @Test
    void evaluateStructurel() {
        //Dans ces deux cas la méthode doit renvoyer Null
        Variable testNull1 = new Variable("testNull1", new IntDomaine(1,10));
        XinfEqualsC testNull1cont = new XinfEqualsC(testNull1, 0);
        assertThrows(ExceptionDomNull.class, testNull1cont::evaluate, "Expected ExceptionDomNull to be thrown");
        assertNull(testNull1.getDomaine().getDomain(), "erreur: XsupC testNull1cont");

        //Le domaine ne doit pas être modifié, la méthode doit donc renvoyer False
        Variable testFalse = new Variable("testFalse", new IntDomaine(1,10));
        XinfEqualsC testFalseCont = new XinfEqualsC(testFalse, -2);
        try {
            assertFalse(testFalseCont.evaluate());
            assertEquals(new IntDomaine(1, 10).getDomain(), testFalse.getDomaine().getDomain());
        } catch (ExceptionDomNull e) {
            fail("Unexpected ExceptionDomNull");
        }

        //Le domaine doit être modifié, la méthode doit donc renvoyer True
        Variable testTrue1 = new Variable("testTrue1", new IntDomaine(1,10));
        XinfEqualsC testTrue1Cont = new XinfEqualsC(testTrue1, 9);
        try {
            assertTrue(testTrue1Cont.evaluate());
            assertNotEquals(new IntDomaine(1, 10).getDomain(), testTrue1.getDomaine().getDomain());
        } catch (ExceptionDomNull e) {
            fail("Unexpected ExceptionDomNull");
        }

        Variable testTrue2 = new Variable("testTrue2", new IntDomaine(1,10));
        XinfEqualsC testTrue2Cont = new XinfEqualsC(testTrue2, 1);
        try {
            assertTrue(testTrue2Cont.evaluate());
            assertNotEquals(new IntDomaine(1, 10).getDomain(), testTrue2.getDomaine().getDomain());
        } catch (ExceptionDomNull e) {
            fail("Unexpected ExceptionDomNull");
        }
    }

//    @Test
//    void evaluate() {
//        Variable var1 = new Variable("x", new IntDomaine(1,10));
//        Variable var2 = new Variable("x", new IntDomaine(1,10));
//        Variable var3 = new Variable("x", new IntDomaine(1,10));
//        Variable var4 = new Variable("x", new IntDomaine(1,10));
//        Variable var5 = new Variable("x", new IntDomaine(1,10));
//
//        // valeurs en dehors du domaine
//        XinfEqualsC cont1 = new XinfEqualsC(var1, 0);
//        assertTrue(cont1.evaluate(), "Erreur : Xinf_equalsCTest cont1 : Renvoie le mauvais Booléen");
//        assertNull(var1.getDomaine().getDomain(), "Erreur : Xinf_equalsCtest cont1 : Renvoie le mauvais Domaine");
//
//
//        XinfEqualsC cont2 = new XinfEqualsC(var2, 11);
//        assertFalse(cont2.evaluate(), "Erreur : Xinf_equalsCTest cont2 : Renvoie le mauvais Booléen");
//        assertEquals(new IntDomaine(1,10).getDomain(), var2.getDomaine().getDomain(), "Erreur : Xinf_equalsCtest cont2");
//
//
//
//        // valeurs en borne du domaine
//        XinfEqualsC cont3 = new XinfEqualsC(var3, 1);
//        assertTrue(cont3.evaluate(), "Erreur : Xinf_equalsCTest cont3 : Renvoie le mauvais Booléen");
//        assertEquals(new IntDomaine(1,1).getDomain(), var3.getDomaine().getDomain(), "Erreur : Xinf_equalsCtest cont3");
//
//
//        XinfEqualsC cont4 = new XinfEqualsC(var4, 10);
//        assertFalse(cont4.evaluate(), "Erreur : Xinf_equalsCTest cont4 : Renvoie le mauvais Booléen");
//        assertEquals(new IntDomaine(1,10).getDomain(), var4.getDomaine().getDomain(), "Erreur : Xinf_equalsCtest cont4");
//
//
//
//        // valeurs dans le domaine
//        XinfEqualsC cont5 = new XinfEqualsC(var5, 5);
//        assertTrue(cont5.evaluate(), "Erreur : Xinf_equalsCTest cont5 : Renvoie le mauvais Booléen");
//        assertEquals(new IntDomaine(1,5).getDomain(), var5.getDomaine().getDomain(), "Erreur : Xinf_equalsCtest cont5");
//    }
}