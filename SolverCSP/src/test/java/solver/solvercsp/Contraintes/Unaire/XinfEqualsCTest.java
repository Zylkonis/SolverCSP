package solver.solvercsp.Contraintes.Unaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XinfEqualsCTest {

    @Test
    void evaluate() {
        Variable var1 = new Variable("x", new IntDomaine(1,10));
        Variable var2 = new Variable("x", new IntDomaine(1,10));
        Variable var3 = new Variable("x", new IntDomaine(1,10));
        Variable var4 = new Variable("x", new IntDomaine(1,10));
        Variable var5 = new Variable("x", new IntDomaine(1,10));

        // valeurs en dehors du domaine
        XinfEqualsC cont1 = new XinfEqualsC(var1, 0);
        assertTrue(cont1.evaluate(), "Erreur : Xinf_equalsCTest cont1 : Renvoie le mauvais Booléen");
        assertNull(var1.getDomaine().getDomain(), "Erreur : Xinf_equalsCtest cont1 : Renvoie le mauvais Domaine");


        XinfEqualsC cont2 = new XinfEqualsC(var2, 11);
        assertFalse(cont2.evaluate(), "Erreur : Xinf_equalsCTest cont2 : Renvoie le mauvais Booléen");
        assertEquals(new IntDomaine(1,10).getDomain(), var2.getDomaine().getDomain(), "Erreur : Xinf_equalsCtest cont2");



        // valeurs en borne du domaine
        XinfEqualsC cont3 = new XinfEqualsC(var3, 1);
        assertTrue(cont3.evaluate(), "Erreur : Xinf_equalsCTest cont3 : Renvoie le mauvais Booléen");
        assertEquals(new IntDomaine(1,1).getDomain(), var3.getDomaine().getDomain(), "Erreur : Xinf_equalsCtest cont3");


        XinfEqualsC cont4 = new XinfEqualsC(var4, 10);
        assertFalse(cont4.evaluate(), "Erreur : Xinf_equalsCTest cont4 : Renvoie le mauvais Booléen");
        assertEquals(new IntDomaine(1,10).getDomain(), var4.getDomaine().getDomain(), "Erreur : Xinf_equalsCtest cont4");



        // valeurs dans le domaine
        XinfEqualsC cont5 = new XinfEqualsC(var5, 5);
        assertTrue(cont5.evaluate(), "Erreur : Xinf_equalsCTest cont5 : Renvoie le mauvais Booléen");
        assertEquals(new IntDomaine(1,5).getDomain(), var5.getDomaine().getDomain(), "Erreur : Xinf_equalsCtest cont5");
    }
}