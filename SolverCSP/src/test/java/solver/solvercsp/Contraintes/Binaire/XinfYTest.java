package solver.solvercsp.Contraintes.Binaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XinfYTest {

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
        XinfY cont1 = new XinfY(varX1, varY1);
        assertFalse(cont1.evaluate());
        assertEquals(varX1.getDomaine(), new IntDomaine(1,10));
        assertEquals(varY1.getDomaine(), new IntDomaine(20,30));

        //X a un domaine absolument supérieur au domaine de Y
        XinfY cont2 = new XinfY(varX2, varY2);
        assertTrue(cont2.evaluate());
        assertNull(varX2.getDomaine());
        assertNull(varY2.getDomaine());

        //X et Y ont exactement le même domaine
        XinfY cont3 = new XinfY(varX3, varY3);
        assertTrue(cont3.evaluate());
        assertEquals(varX3.getDomaine(), new IntDomaine(1,9));
        assertEquals(varY3.getDomaine(), new IntDomaine(2,10));


        //X a une partie de son domaine incluse dans Y, le reste est supérieur au domaine Y
        XinfY cont4 = new XinfY(varX4, varY4);
        assertTrue(cont4.evaluate());
        assertEquals(varX4.getDomaine(), new IntDomaine(1,4));
        assertEquals(varY4.getDomaine(), new IntDomaine(2,5));


        //X a une partie de son domaine incluse dans Y, le reste est inférieur au domaine Y
        XinfY cont5 = new XinfY(varX5, varY5);
        assertFalse(cont5.evaluate());
        assertEquals(varX5.getDomaine(), new IntDomaine(1,10));
        assertEquals(varY5.getDomaine(), new IntDomaine(5,15));
    }
}