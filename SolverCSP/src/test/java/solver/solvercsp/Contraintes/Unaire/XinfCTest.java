package solver.solvercsp.Contraintes.Unaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.ExceptionDomNull;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XinfCTest {

    @Test
    void evaluateStructurel() {
        //Dans ces deux cas la méthode doit renvoyer Null
        Variable testNull1 = new Variable("testNull1", new IntDomaine(1,10));
        XinfC testNull1cont = new XinfC(testNull1, 1);
        assertThrows(ExceptionDomNull.class, testNull1cont::evaluate, "Expected ExceptionDomNull to be thrown");
        assertNull(testNull1.getDomaine().getDomain(), "erreur: XinfC testNull1cont");

        //Le domaine ne doit pas être modifié, la méthode doit donc renvoyer False
        Variable testFalse = new Variable("testFalse", new IntDomaine(1,10));
        XinfC testFalseCont = new XinfC(testFalse, 11);
        try {
            assertFalse(testFalseCont.evaluate());
            assertEquals(new IntDomaine(1, 10).getDomain(), testFalse.getDomaine().getDomain());
        } catch (ExceptionDomNull e) {
            fail("Unexpected ExceptionDomNull");
        }

        //Le domaine doit être modifié, la méthode doit donc renvoyer True
        Variable testTrue1 = new Variable("testTrue1", new IntDomaine(1,10));
        XinfC testTrue1Cont = new XinfC(testTrue1, 10);
        try {
            assertTrue(testTrue1Cont.evaluate());
            assertNotEquals(new IntDomaine(1, 10).getDomain(), testTrue1.getDomaine().getDomain());
        } catch (ExceptionDomNull e) {
            fail("Unexpected ExceptionDomNull");
        }
    }

//    @Test
//    void evaluate() {
//        //IntDomaine dom = new IntDomaine(1,10);
//        //dom.getDomain().put()
//        Variable var1 = new Variable("x", new IntDomaine(1,10));
//        Variable var2 = new Variable("x", new IntDomaine(1,10));
//        Variable var3 = new Variable("x", new IntDomaine(1,10));
//        Variable var4 = new Variable("x", new IntDomaine(1,10));
//        Variable var5 = new Variable("x", new IntDomaine(1,10));
//
//        // valeurs en dehors du domaine
//        XinfC cont0 = new XinfC(var1, 0);
//        XinfC cont11 = new XinfC(var2, 11);
//
//        // valeurs en borne du domaine
//        XinfC cont1 = new XinfC(var3, 1);
//        XinfC cont10 = new XinfC(var4, 10);
//
//        // valeurs dans le domaine
//        XinfC cont5 = new XinfC(var5, 5);
//
//        assertTrue(cont0.evaluate());
//        assertNull(var1.getDomaine().getDomain(), "erreur: XinfC cont0");
//
//        assertFalse(cont11.evaluate());
//        assertEquals(new IntDomaine(1, 10).getDomain(), var2.getDomaine().getDomain(),"erreur: XinfC cont11");
//
//        assertTrue(cont1.evaluate());
//        assertNull(var3.getDomaine().getDomain(), "erreur: XinfC cont1");
//
//        assertTrue(cont10.evaluate());
//        assertEquals(new IntDomaine(1, 9).getDomain(), var4.getDomaine().getDomain(), "erreur: XinfC cont10");
//
//        assertTrue(cont5.evaluate());
//        assertEquals(new IntDomaine(1, 4).getDomain(), var5.getDomaine().getDomain(), "erreur: XinfC cont5");
//    }
}