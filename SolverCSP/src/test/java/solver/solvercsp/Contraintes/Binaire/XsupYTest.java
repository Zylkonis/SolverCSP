package solver.solvercsp.Contraintes.Binaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XsupYTest {

    @Test
    void evaluate() {
        Variable varX1 = new Variable("x", new IntDomaine(1,10));
        Variable varY1 = new Variable("y", new IntDomaine(20,30));
        Variable varX2 = new Variable("x", new IntDomaine(1,10));
        Variable varY2 = new Variable("y", new IntDomaine(-10,0));
        Variable varX3 = new Variable("x", new IntDomaine(1,10));
        Variable varY3 = new Variable("y", new IntDomaine(1,10));
        Variable varX4 = new Variable("x", new IntDomaine(1,10));
        Variable varY4 = new Variable("y", new IntDomaine(-5,5));
        Variable varX5 = new Variable("x", new IntDomaine(1,10));
        Variable varY5 = new Variable("y", new IntDomaine(5,15));


        //X a un domaine absolument inférieur au domaine de Y
        XsupY cont1 = new XsupY(varX1, varY1);
        assertTrue(cont1.evaluate());
        assertNull(varX1.getDomaine());
        assertNull(varY1.getDomaine());

        //X a un domaine absolument supérieur au domaine de Y
        XsupY cont2 = new XsupY(varX2, varY2);
        assertFalse(cont2.evaluate());
        assertEquals(varX2.getDomaine(), new IntDomaine(1,10));
        assertEquals(varY2.getDomaine(), new IntDomaine(-10,0));

        //X et Y ont exactement le même domaine
        XsupY cont3 = new XsupY(varX3, varY3);
        assertTrue(cont3.evaluate());
        assertEquals(varX3.getDomaine(), new IntDomaine(2,10));
        assertEquals(varY3.getDomaine(), new IntDomaine(1,9));


        //X a une partie de son domaine incluse dans Y, le reste est supérieur au domaine Y
        XsupY cont4 = new XsupY(varX4, varY4);
        assertFalse(cont4.evaluate());
        assertEquals(varX4.getDomaine(), new IntDomaine(1,10));
        assertEquals(varY4.getDomaine(), new IntDomaine(-5,5));


        //X a une partie de son domaine incluse dans Y, le reste est inférieur au domaine Y
        XsupY cont5 = new XsupY(varX5, varY5);
        assertTrue(cont5.evaluate());
        assertEquals(varX5.getDomaine(), new IntDomaine(6,10));
        assertEquals(varY5.getDomaine(), new IntDomaine(5,9));
    }
}