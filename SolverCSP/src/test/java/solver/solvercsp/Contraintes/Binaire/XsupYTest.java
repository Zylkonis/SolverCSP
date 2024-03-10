package solver.solvercsp.Contraintes.Binaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.Contraintes.Unaire.XsupC;
import solver.solvercsp.ExceptionDomNull;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XsupYTest {

    @Test
    void evaluateStructurel() {
        //Dans ces deux cas la méthode doit renvoyer Null
        Variable testNull1 = new Variable("testNull1", new IntDomaine(1,10));
        Variable testNull2 = new Variable("testNull2", new IntDomaine(10,12));
        XsupY testNull1cont = new XsupY(testNull1, testNull2);
        assertThrows(ExceptionDomNull.class, testNull1cont::evaluate, "Expected ExceptionDomNull to be thrown");
        assertNull(testNull1.getDomaine().getDomain(), "erreur: XsupC testNull1cont");

        //Le domaine ne doit pas être modifié, la méthode doit donc renvoyer False
        Variable testFalse1 = new Variable("testFalse", new IntDomaine(1,10));
        Variable testFalse2 = new Variable("testFalse", new IntDomaine(-5,0));
        XsupY testFalseCont = new XsupY(testFalse1, testFalse2);
        try {
            assertFalse(testFalseCont.evaluate());
            assertEquals(new IntDomaine(1, 10).getDomain(), testFalse1.getDomaine().getDomain());
            assertEquals(new IntDomaine(-5, 0).getDomain(), testFalse2.getDomaine().getDomain());
        } catch (ExceptionDomNull e) {
            fail("Unexpected ExceptionDomNull");
        }

        //Le domaine doit être modifié, la méthode doit donc renvoyer True
        Variable testTrue1 = new Variable("testTrue1", new IntDomaine(1,10));
        Variable testTrue2 = new Variable("testTrue1", new IntDomaine(1,10));
        XsupY testTrue1Cont = new XsupY(testTrue1, testTrue2);
        try {
            assertTrue(testTrue1Cont.evaluate());
            assertNotEquals(new IntDomaine(1, 10).getDomain(), testTrue1.getDomaine().getDomain());
            assertNotEquals(new IntDomaine(1, 10).getDomain(), testTrue2.getDomaine().getDomain());
        } catch (ExceptionDomNull e) {
            fail("Unexpected ExceptionDomNull");
        }
    }
//    @Test
//    void evaluate() {
//        Variable varX1 = new Variable("x", new IntDomaine(1,10));
//        Variable varY1 = new Variable("y", new IntDomaine(20,30));
//        Variable varX2 = new Variable("x", new IntDomaine(1,10));
//        Variable varY2 = new Variable("y", new IntDomaine(-10,0));
//        Variable varX3 = new Variable("x", new IntDomaine(1,10));
//        Variable varY3 = new Variable("y", new IntDomaine(1,10));
//        Variable varX4 = new Variable("x", new IntDomaine(1,10));
//        Variable varY4 = new Variable("y", new IntDomaine(-5,5));
//        Variable varX5 = new Variable("x", new IntDomaine(1,10));
//        Variable varY5 = new Variable("y", new IntDomaine(5,15));
//
//
//        //X a un domaine absolument inférieur au domaine de Y
//        XsupY cont1 = new XsupY(varX1, varY1);
//        //assertTrue(cont1.evaluate());
//        assertNull(varX1.getDomaine());
//        assertNull(varY1.getDomaine());
//
//        //X a un domaine absolument supérieur au domaine de Y
//        XsupY cont2 = new XsupY(varX2, varY2);
//        //assertFalse(cont2.evaluate());
//        assertEquals(varX2.getDomaine(), new IntDomaine(1,10));
//        assertEquals(varY2.getDomaine(), new IntDomaine(-10,0));
//
//        //X et Y ont exactement le même domaine
//        XsupY cont3 = new XsupY(varX3, varY3);
//        //assertTrue(cont3.evaluate());
//        assertEquals(varX3.getDomaine(), new IntDomaine(2,10));
//        assertEquals(varY3.getDomaine(), new IntDomaine(1,9));
//
//
//        //X a une partie de son domaine incluse dans Y, le reste est supérieur au domaine Y
//        XsupY cont4 = new XsupY(varX4, varY4);
//        //assertFalse(cont4.evaluate());
//        assertEquals(varX4.getDomaine(), new IntDomaine(1,10));
//        assertEquals(varY4.getDomaine(), new IntDomaine(-5,5));
//
//
//        //X a une partie de son domaine incluse dans Y, le reste est inférieur au domaine Y
//        XsupY cont5 = new XsupY(varX5, varY5);
//        //assertTrue(cont5.evaluate());
//        assertEquals(varX5.getDomaine(), new IntDomaine(6,10));
//        assertEquals(varY5.getDomaine(), new IntDomaine(5,9));
//    }
}