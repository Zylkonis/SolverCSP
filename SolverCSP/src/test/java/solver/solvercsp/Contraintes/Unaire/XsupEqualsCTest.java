package solver.solvercsp.Contraintes.Unaire;

import org.junit.jupiter.api.Test;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import static org.junit.jupiter.api.Assertions.*;

class XsupEqualsCTest {

    @Test
    void evaluate() {
        Variable var1 = new Variable("x", new IntDomaine(1,10));
        Variable var2 = new Variable("x", new IntDomaine(1,10));
        Variable var3 = new Variable("x", new IntDomaine(1,10));
        Variable var4 = new Variable("x", new IntDomaine(1,10));
        Variable var5 = new Variable("x", new IntDomaine(1,10));


        // valeurs en dehors du domaine
        XsupEqualsC cont1 = new XsupEqualsC(var1, 0);
        assertFalse(cont1.evaluate(), "Erreur : Xsup_equalsCTest cont1 : Renvoie le mauvais Booléen");
        assertEquals(new IntDomaine(1,10).getDomain(), var1.getDomaine().getDomain(),"Erreur : Xsup_equalsCtest cont1 : Renvoie le mauvais Domaine");


        XsupEqualsC cont2 = new XsupEqualsC(var2, 11);
        assertTrue(cont2.evaluate(), "Erreur : Xsup_equalsCTest cont2 : Renvoie le mauvais Booléen");
        assertNull((var2.getDomaine().getDomain()), "Erreur : Xsup_equalsCtest cont2");



        // valeurs en borne du domaine
        XsupEqualsC cont3 = new XsupEqualsC(var3, 1);
        assertFalse(cont3.evaluate(), "Erreur : Xsup_equalsCTest cont3 : Renvoie le mauvais Booléen");
        assertEquals(new IntDomaine(1,10).getDomain(), var3.getDomaine().getDomain(), "Erreur : Xsup_equalsCtest cont3");



        XsupEqualsC cont4 = new XsupEqualsC(var4, 10);
        assertTrue(cont4.evaluate(), "Erreur : Xsup_equalsCTest cont4 : Renvoie le mauvais Booléen");
        assertEquals(new IntDomaine(10,10).getDomain(), var4.getDomaine().getDomain(), "Erreur : Xsup_equalsCtest cont4");




        // valeurs dans le domaine
        XsupEqualsC cont5 = new XsupEqualsC(var5, 5);
        assertTrue(cont5.evaluate(), "Erreur : Xsup_equalsCTest cont5 : Renvoie le mauvais Booléen");
        assertEquals(new IntDomaine(5,10).getDomain(), var5.getDomaine().getDomain(), "Erreur : Xsup_equalsCtest cont5");


    }
}