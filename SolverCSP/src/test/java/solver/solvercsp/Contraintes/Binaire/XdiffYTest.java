package solver.solvercsp.Contraintes.Binaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XdiffYTest {

    @Test
    void evaluate1() {
        Variable varX1 = new Variable("x", new IntDomaine(1, 10));
        Variable varY1 = new Variable("y", new IntDomaine(20, 30));

        //X a un domaine absolument différent au domaine de Y
        XdiffY cont1 = new XdiffY(varX1, varY1);

        assertFalse(cont1.evaluate(), "erreur: XdiffY cont1 domaine édité");

        assertEquals(varX1.getDomaine(), new IntDomaine(1, 10), "erreur: XdiffY cont1 Domaine x incorrecte");
        assertEquals(new IntDomaine(20, 30), varY1.getDomaine(), "erreur: XdiffY cont1 Domaine y incorrecte");
    }

    @Test
    void evaluate2() {
        Variable varX2 = new Variable("x", new IntDomaine(1, 10));
        Variable varY2 = new Variable("y", new IntDomaine(-10, 3));

        //X a un domaine qui est sur une partie du domaine de Y en min ou en max
        XdiffY cont2 = new XdiffY(varX2, varY2);

        assertTrue(cont2.evaluate(), "erreur: XdiffY cont2 domaine non édité");

        assertEquals(7, ((IntDomaine) varX2.getDomaine()).getCardDomaine(), "erreur: XdiffY cont2 cardinalité incorrecte");
        assertEquals(11, ((IntDomaine) varY2.getDomaine()).getCardDomaine(), "erreur: XdiffY cont2 cardinalité incorrecte");

        assertEquals(10,((IntDomaine)varX2.getDomaine()).getMaxDomaine(), "erreur: XdiffY cont2 maximum domaine incorrect");
        assertEquals(4,((IntDomaine)varX2.getDomaine()).getMinDomaine(), "erreur: XdiffY cont2 minimum domaine incorrect");
        assertEquals(0,((IntDomaine)varY2.getDomaine()).getMaxDomaine(), "erreur: XdiffY cont2 maximum domaine incorrect");
        assertEquals(-10,((IntDomaine)varY2.getDomaine()).getMinDomaine(), "erreur: XdiffY cont2 minimum domaine incorrect");
    }

    @Test
    void evaluate3() {
        Variable varX3 = new Variable("x", new IntDomaine(1, 10));
        Variable varY3 = new Variable("y", new IntDomaine(1, 10));

        //X et Y ont exactement le même domaine
        XdiffY cont3 = new XdiffY(varX3, varY3);

        assertTrue(cont3.evaluate(), "erreur: XdiffY cont3 domaine non édité");

        assertEquals(0, ((IntDomaine) varX3.getDomaine()).getCardDomaine(), "erreur: XdiffY cont3 cardinalité incorrecte");
        assertEquals(0, ((IntDomaine) varY3.getDomaine()).getCardDomaine(), "erreur: XdiffY cont3 cardinalité incorrecte");

        assertNull(varX3.getDomaine());
        assertNull(varY3.getDomaine());
    }

    @Test
    void evaluate4() {
        Variable varX4 = new Variable("x", new IntDomaine(1, 10));
        Variable varY4 = new Variable("y", new IntDomaine(3, 7));

        //X a son domaine inclus dans Y
        XdiffY cont4 = new XdiffY(varX4, varY4);

        assertTrue(cont4.evaluate(), "erreur: XdiffY cont4 Domaine x ou y incorrecte");

        assertEquals(varX4.getDomaine(), varY4.getDomaine(), "erreur: XdiffY cont4 Domaine x ou y incorrecte");
        assertEquals(varY4.getDomaine(), new IntDomaine(3, 7), "erreur: XdiffY cont4 Domaine x et y incorrecte");

        assertEquals(0, ((IntDomaine) varY4.getDomaine()).getCardDomaine(), "erreur: XdiffY cont4 cardinalité incorrecte");//à vérifier

        //test des bornes du domaines
        assertEquals(1,((IntDomaine)varX4.getDomaine()).getMinSousDomaine(0), "erreur: XdiffC cont4 minimum sous-domaine 0 incorrect");
        assertEquals(3,((IntDomaine)varX4.getDomaine()).getMaxSousDomaine(0), "erreur: XdiffC cont4 maximum sous-domaine 0 incorrect");
        assertEquals(8,((IntDomaine)varX4.getDomaine()).getMinSousDomaine(1), "erreur: XdiffC cont4 minimum sous-domaine 1 incorrect");
        assertEquals(10,((IntDomaine)varX4.getDomaine()).getMaxSousDomaine(1), "erreur: XdiffC cont4 maximum sous-domaine 1 incorrect");

        assertNull(varY4.getDomaine());
    }

    @Test
    void evaluate() {
    }
}