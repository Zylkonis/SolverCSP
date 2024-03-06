package solver.solvercsp.Contraintes.N_aire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class AllDifferentTest {

    @Test
    void evaluate1() {
        //Aucune variable n'est de cardinalité 1, aucun changement attendu
        Variable varX1 = new Variable("x1", new IntDomaine(1, 10));
        Variable varX2 = new Variable("x2", new IntDomaine(20, 30));
        Variable varX3 = new Variable("x3", new IntDomaine(40, 50));

        AllDifferent cont = new AllDifferent(varX1, varX2, varX3);
        assertFalse(cont.evaluate());
        assertEquals(new IntDomaine(1, 10).getDomain(), varX1.getDomaine().getDomain());
        assertEquals(new IntDomaine(20, 30).getDomain(), varX2.getDomaine().getDomain());
        assertEquals(new IntDomaine(40, 50).getDomain(), varX3.getDomaine().getDomain());

    }


    @Test
    void evaluate2() {
        //Une Variable est de cardinalité, réduisant les autres domaines à un de cardinalité par cascade
        Variable varY1 = new Variable("y1", new IntDomaine(1, 1));
        Variable varY2 = new Variable("y2", new IntDomaine(1, 2));
        Variable varY3 = new Variable("y3", new IntDomaine(1, 3));

        AllDifferent cont = new AllDifferent(varY1, varY2, varY3);
        assertTrue(cont.evaluate());
        assertEquals(new IntDomaine(1, 1).getDomain(), varY1.getDomaine().getDomain());
        assertEquals(new IntDomaine(2, 2).getDomain(), varY2.getDomaine().getDomain());
        assertEquals(new IntDomaine(3, 3).getDomain(), varY3.getDomaine().getDomain());

    }

    @Test
    void evaluate3() {
        //2 variables ont 1 de cardinalité, le dernier domaine est trop petit et devrait finir null
        Variable varZ1 = new Variable("z1", new IntDomaine(1, 1));
        Variable varZ2 = new Variable("z2", new IntDomaine(1, 2));
        Variable varZ3 = new Variable("z3", new IntDomaine(2, 2));

        AllDifferent cont = new AllDifferent(varZ1, varZ2, varZ3);
        assertTrue(cont.evaluate());
        assertEquals(new IntDomaine(1, 1).getDomain(), varZ1.getDomaine().getDomain());
        assertEquals(new IntDomaine(2, 2).getDomain(), varZ2.getDomaine().getDomain());
        assertNull(varZ3.getDomaine().getDomain());

    }

    @Test
    void evaluate4() {
        //1 variable à un de cardinalité, l'un des domaines restants devrait être scindé
        Variable varT1 = new Variable("t1", new IntDomaine(1,1));
        Variable varT2 = new Variable("t2", new IntDomaine(1,10));
        Variable varT3 = new Variable("t3", new IntDomaine(0,5));

        AllDifferent cont = new AllDifferent(varT1, varT2, varT3);
        assertTrue(cont.evaluate());
        assertEquals(new IntDomaine(1, 1).getDomain(), varT1.getDomaine().getDomain());
        assertEquals(new IntDomaine(2, 10).getDomain(), varT2.getDomaine().getDomain());
        assertEquals(2, varT3.getDomaine().getCompteur());

    }

}