package solver.solvercsp.Contraintes.Binaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class XsupEqualsYTest {

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
        XsupEqualsY cont1 = new XsupEqualsY(varX1, varY1);
        assertTrue(cont1.evaluate());
        assertNull(varX1.getDomaine());
        assertNull(varY1.getDomaine());

        //X a un domaine absolument supérieur au domaine de Y
        XsupEqualsY cont2 = new XsupEqualsY(varX2, varY2);
        assertFalse(cont2.evaluate());
        assertEquals(varX2.getDomaine(), new IntDomaine(1,10));
        assertEquals(varY2.getDomaine(), new IntDomaine(-10,0));

        //X et Y ont exactement le même domaine
        XsupEqualsY cont3 = new XsupEqualsY(varX3, varY3);
        assertFalse(cont3.evaluate());
        assertEquals(varX3.getDomaine(), new IntDomaine(1,10));
        assertEquals(varY3.getDomaine(), new IntDomaine(1,10));


        //X a une partie de son domaine incluse dans Y, le reste est supérieur au domaine Y
        XsupEqualsY cont4 = new XsupEqualsY(varX4, varY4);
        assertFalse(cont4.evaluate());
        assertEquals(varX4.getDomaine(), new IntDomaine(1,10));
        assertEquals(varY4.getDomaine(), new IntDomaine(-5,5));


        //X a une partie de son domaine incluse dans Y, le reste est inférieur au domaine Y
        XsupEqualsY cont5 = new XsupEqualsY(varX5, varY5);
        assertTrue(cont5.evaluate());
        assertEquals(varX5.getDomaine(), new IntDomaine(5,10));
        assertEquals(varY5.getDomaine(), new IntDomaine(5,10));
    }
}