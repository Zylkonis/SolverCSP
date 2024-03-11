package solver.solvercsp.Contraintes.Binaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.ExceptionDomNull;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class XinfEqualsYTest {

    @Test
    void evaluateStructurel() {
        //Dans ces deux cas la méthode doit renvoyer Null
        Variable testNull1 = new Variable("testNull1", new IntDomaine(1,10));
        Variable testNull2 = new Variable("testNull2", new IntDomaine(-2,0));
        XinfY testNull1cont = new XinfY(testNull1, testNull2);
        assertThrows(ExceptionDomNull.class, testNull1cont::evaluate, "Expected ExceptionDomNull to be thrown");
        assertNull(testNull1.getDomaine().getDomain(), "erreur: XinfY testNull1cont");

        //Le domaine ne doit pas être modifié, la méthode doit donc renvoyer False
        Variable testFalse1 = new Variable("testFalse", new IntDomaine(1,10));
        Variable testFalse2 = new Variable("testFalse", new IntDomaine(11,13));
        XinfY testFalseCont = new XinfY(testFalse1, testFalse2);
        try {
            assertFalse(testFalseCont.evaluate());
            assertEquals(new IntDomaine(1, 10).getDomain(), testFalse1.getDomaine().getDomain());
            assertEquals(new IntDomaine(11, 13).getDomain(), testFalse2.getDomaine().getDomain());
        } catch (ExceptionDomNull e) {
            fail("Unexpected ExceptionDomNull");
        }

        //Le domaine doit être modifié, la méthode doit donc renvoyer True
        Variable testTrue1 = new Variable("testTrue1", new IntDomaine(1,10));
        Variable testTrue2 = new Variable("testTrue1", new IntDomaine(1,10));
        XinfY testTrue1Cont = new XinfY(testTrue1, testTrue2);
        try {
            assertTrue(testTrue1Cont.evaluate());
            assertNotEquals(new IntDomaine(1, 10).getDomain(), testTrue1.getDomaine().getDomain());
            assertNotEquals(new IntDomaine(1, 10).getDomain(), testTrue2.getDomaine().getDomain());
        } catch (ExceptionDomNull e) {
            fail("Unexpected ExceptionDomNull");
        }
    }
//    @Test
//    void evaluate1() {
//        Variable varX1 = new Variable("x", new IntDomaine(1, 10));
//        Variable varY1 = new Variable("y", new IntDomaine(20, 30));
//
//        //X a un domaine absolument différent au domaine de Y
//        XinfEqualsY cont1 = new XinfEqualsY(varX1, varY1);
//        //assertFalse(cont1.evaluate());
//        assertEquals(varX1.getDomaine(), new IntDomaine(1, 10));
//        assertEquals(varY1.getDomaine(), new IntDomaine(20, 30));
//    }
//
//    @Test
//    void evaluate2() {
//        Variable varX2 = new Variable("x", new IntDomaine(1, 10));
//        Variable varY2 = new Variable("y", new IntDomaine(-10, 0));
//
//        //X a un domaine qui est sur une partie du domaine de Y en min ou en max
//        XinfEqualsY cont2 = new XinfEqualsY(varX2, varY2);
//        //assertTrue(cont2.evaluate());
//        assertNull(varX2.getDomaine());
//        assertNull(varY2.getDomaine());
//    }
//
//    @Test
//    void evaluate3() {
//        Variable varX3 = new Variable("x", new IntDomaine(1, 10));
//        Variable varY3 = new Variable("y", new IntDomaine(1, 10));
//
//        //X et Y ont exactement le même domaine
//        XinfEqualsY cont3 = new XinfEqualsY(varX3, varY3);
//        //assertFalse(cont3.evaluate());
//        assertEquals(varX3.getDomaine(), new IntDomaine(1, 10));
//        assertEquals(varY3.getDomaine(), new IntDomaine(1, 10));
//    }
//
//    @Test
//    void evaluate4() {
//        Variable varX4 = new Variable("x", new IntDomaine(1, 10));
//        Variable varY4 = new Variable("y", new IntDomaine(-5, 5));
//
//        //X a une partie de son domaine incluse dans Y, le reste est supérieur au domaine Y
//        XinfEqualsY cont4 = new XinfEqualsY(varX4, varY4);
//        //assertTrue(cont4.evaluate());
//        assertEquals(varX4.getDomaine(), new IntDomaine(1, 5));
//        assertEquals(varY4.getDomaine(), new IntDomaine(1, 5));
//    }
//
//    @Test
//    void evaluate5() {
//        Variable varX5 = new Variable("x", new IntDomaine(1, 10));
//        Variable varY5 = new Variable("y", new IntDomaine(5, 15));
//
//        //X a une partie de son domaine incluse dans Y, le reste est inférieur au domaine Y
//        XinfEqualsY cont5 = new XinfEqualsY(varX5, varY5);
//        //assertFalse(cont5.evaluate());
//        assertEquals(varX5.getDomaine(), new IntDomaine(1, 10));
//        assertEquals(varY5.getDomaine(), new IntDomaine(5, 15));
//    }
}