package solver.solvercsp;

import solver.solvercsp.Contraintes.Binaire.*;
import solver.solvercsp.Contraintes.Contrainte;
import solver.solvercsp.Contraintes.N_aire.AllDifferent;
import solver.solvercsp.Contraintes.Unaire.XsupC;

public class Main {
    public static void main(String[] args){
//        Variable x1 = new Variable("x1", new IntDomaine(4,4,6,9));
//        Variable x2 = new Variable("x2", new IntDomaine(5,5,7,12));
//        Variable x3 = new Variable("x3", new IntDomaine(5,14));
//        Variable x4 = new Variable("x4", new IntDomaine(4,4,8,8));
//        x1.getDomaine().printDomain();
//        x2.getDomaine().printDomain();
//        x3.getDomaine().printDomain();
//        x4.getDomaine().printDomain();
//
//
//
//
//        Contrainte c1 = new XdiffY(x1,x2);
//        Contrainte c2 = new XinfY(x2,x3);
//        Contrainte c3 = new XsupY(x3,x4);
//        Contrainte c4 = new XdiffY(x1,x4);
//        Contrainte c5 = new XsupY(x1,x3);
//
//
//        SolverCSP csp = new SolverCSP();
//
//
//
//        csp.addVariable(x1);
//        csp.addVariable(x2);
//        csp.addVariable(x3);
//        csp.addVariable(x4);
//
//        csp.addContrainte(c1);
//        csp.addContrainte(c2);
//        csp.addContrainte(c3);
//        csp.addContrainte(c4);
//        csp.addContrainte(c5);

//        Variable x1 = new Variable("x1", new IntDomaine(4,4,7,8));
//        Variable x2 = new Variable("x2", new IntDomaine(5,5,7,12));
//        Variable x3 = new Variable("x3", new IntDomaine(5,5,7,7));
//        x1.getDomaine().printDomain();
//        x2.getDomaine().printDomain();
//        x3.getDomaine().printDomain();
//
//
//
//
//        Contrainte c1 = new XsupY(x1,x2);
//        Contrainte c2 = new XdiffY(x1,x3);
//        Contrainte c3 = new XdiffY(x2,x3);
//
//
//        SolverCSP csp = new SolverCSP();
//
//
//
//        csp.addVariable(x1);
//        csp.addVariable(x2);
//        csp.addVariable(x3);
//
//        csp.addContrainte(c1);
//        csp.addContrainte(c2);
//        csp.addContrainte(c3);

        Variable v1 = new Variable("v1", new IntDomaine(1,1));
        Variable v2 = new Variable("v2", new IntDomaine(1,9));
        v1.getDomaine().printDomain();
        v2.getDomaine().printDomain();

        Contrainte c1 = new XequalsY(v1,v2);
        Variable v3 = new Variable("v3", new IntDomaine(1,9));
        Variable v4 = new Variable("v4", new IntDomaine(1,1));
        v4.getDomaine().printDomain();
        Contrainte c2 = new XequalsY(v3,v4);

        Variable v9 = new Variable("v5", new IntDomaine(1,1,4,8));
        Variable v10 = new Variable("v6", new IntDomaine(1,3));
        Contrainte c3 = new XequalsY(v9,v10);

        Variable v11 = new Variable("v7", new IntDomaine(1,3));
        Variable v12 = new Variable("v8", new IntDomaine(1,1,4,8));
        Contrainte c4 = new XequalsY(v11,v12);

        Variable v13 = new Variable("v9", new IntDomaine(1,1,4,8));
        Variable v14 = new Variable("v10", new IntDomaine(3,6));
        Contrainte c5 = new XequalsY(v13,v14);

        Variable v15 = new Variable("v11", new IntDomaine(3,6));
        Variable v16 = new Variable("v12", new IntDomaine(1,1,4,8));
        Contrainte c6 = new XequalsY(v15,v16);

        Variable v17 = new Variable("v13", new IntDomaine(4,8));
        Variable v18 = new Variable("v14", new IntDomaine(4,8));
        Contrainte c7 = new XequalsY(v17,v18);

        SolverCSP csp = new SolverCSP();

        csp.addVariable(v1);
        csp.addVariable(v2);
        csp.addVariable(v3);
        csp.addVariable(v4);

        csp.addVariable(v9);
        csp.addVariable(v10);
        csp.addVariable(v11);
        csp.addVariable(v12);
        csp.addVariable(v13);
        csp.addVariable(v14);
        csp.addVariable(v15);
        csp.addVariable(v16);
        csp.addVariable(v17);
        csp.addVariable(v18);

        csp.addContrainte(c1);
        csp.addContrainte(c2);
        csp.addContrainte(c3);
        csp.addContrainte(c4);
        csp.addContrainte(c5);
        csp.addContrainte(c6);
        csp.addContrainte(c7);
//        csp.addContrainte(c8);
//        csp.addContrainte(c9);

        //csp.evaluate();



        /////////////////////////////////////////////////////////////

        Variable x11 = new Variable("x11", new IntDomaine(1,9));    Variable x12 = new Variable("x12", new IntDomaine(1,9));    Variable x13 = new Variable("x13", new IntDomaine(1,9));        Variable x14 = new Variable("x14", new IntDomaine(1,9));    Variable x15 = new Variable("x15", new IntDomaine(1,9));    Variable x16 = new Variable("x16", new IntDomaine(1,9));            Variable x17 = new Variable("x17", new IntDomaine(5,5));    Variable x18 = new Variable("x18", new IntDomaine(1,9));    Variable x19 = new Variable("x19", new IntDomaine(1,9));

        Variable x21 = new Variable("x21", new IntDomaine(1,9));    Variable x22 = new Variable("x22", new IntDomaine(2,2));    Variable x23 = new Variable("x23", new IntDomaine(1,9));        Variable x24 = new Variable("x24", new IntDomaine(1,9));    Variable x25 = new Variable("x25", new IntDomaine(1,9));    Variable x26 = new Variable("x26", new IntDomaine(4,4));            Variable x27 = new Variable("x27", new IntDomaine(1,1));    Variable x28 = new Variable("x28", new IntDomaine(1,9));    Variable x29 = new Variable("x29", new IntDomaine(1,9));

        Variable x31 = new Variable("x31", new IntDomaine(1,9));    Variable x32 = new Variable("x32", new IntDomaine(1,1));    Variable x33 = new Variable("x33", new IntDomaine(5,5));        Variable x34 = new Variable("x34", new IntDomaine(1,9));    Variable x35 = new Variable("x35", new IntDomaine(1,9));    Variable x36 = new Variable("x36", new IntDomaine(1,9));            Variable x37 = new Variable("x37", new IntDomaine(1,9));    Variable x38 = new Variable("x38", new IntDomaine(1,9));    Variable x39 = new Variable("x39", new IntDomaine(7,7));


        Variable x41 = new Variable("x41", new IntDomaine(1,9));    Variable x42 = new Variable("x42", new IntDomaine(1,9));    Variable x43 = new Variable("x43", new IntDomaine(7,7));        Variable x44 = new Variable("x44", new IntDomaine(1,9));    Variable x45 = new Variable("x45", new IntDomaine(1,9));    Variable x46 = new Variable("x46", new IntDomaine(8,8));            Variable x47 = new Variable("x47", new IntDomaine(1,9));    Variable x48 = new Variable("x48", new IntDomaine(1,9));    Variable x49 = new Variable("x49", new IntDomaine(1,9));

        Variable x51 = new Variable("x51", new IntDomaine(4,4));    Variable x52 = new Variable("x52", new IntDomaine(1,9));    Variable x53 = new Variable("x53", new IntDomaine(1,9));        Variable x54 = new Variable("x54", new IntDomaine(1,9));    Variable x55 = new Variable("x55", new IntDomaine(2,2));    Variable x56 = new Variable("x56", new IntDomaine(1,9));            Variable x57 = new Variable("x57", new IntDomaine(1,9));    Variable x58 = new Variable("x58", new IntDomaine(1,9));    Variable x59 = new Variable("x59", new IntDomaine(1,9));

        Variable x61 = new Variable("x61", new IntDomaine(9,9));    Variable x62 = new Variable("x62", new IntDomaine(1,9));    Variable x63 = new Variable("x63", new IntDomaine(1,9));        Variable x64 = new Variable("x64", new IntDomaine(1,9));    Variable x65 = new Variable("x65", new IntDomaine(1,9));    Variable x66 = new Variable("x66", new IntDomaine(1,9));            Variable x67 = new Variable("x67", new IntDomaine(1,9));    Variable x68 = new Variable("x68", new IntDomaine(6,6));    Variable x69 = new Variable("x69", new IntDomaine(8,8));


        Variable x71 = new Variable("x71", new IntDomaine(1,9));    Variable x72 = new Variable("x72", new IntDomaine(1,9));    Variable x73 = new Variable("x73", new IntDomaine(1,9));        Variable x74 = new Variable("x74", new IntDomaine(4,4));    Variable x75 = new Variable("x75", new IntDomaine(1,9));    Variable x76 = new Variable("x76", new IntDomaine(1,9));            Variable x77 = new Variable("x77", new IntDomaine(9,9));    Variable x78 = new Variable("x78", new IntDomaine(7,7));    Variable x79 = new Variable("x79", new IntDomaine(1,9));

        Variable x81 = new Variable("x81", new IntDomaine(1,9));    Variable x82 = new Variable("x82", new IntDomaine(1,9));    Variable x83 = new Variable("x83", new IntDomaine(1,9));        Variable x84 = new Variable("x84", new IntDomaine(7,7));    Variable x85 = new Variable("x85", new IntDomaine(1,9));    Variable x86 = new Variable("x86", new IntDomaine(1,9));            Variable x87 = new Variable("x87", new IntDomaine(1,9));    Variable x88 = new Variable("x88", new IntDomaine(3,3));    Variable x89 = new Variable("x89", new IntDomaine(1,9));

        Variable x91 = new Variable("x91", new IntDomaine(1,9));    Variable x92 = new Variable("x92", new IntDomaine(1,9));    Variable x93 = new Variable("x93", new IntDomaine(1,9));        Variable x94 = new Variable("x94", new IntDomaine(1,1));    Variable x95 = new Variable("x95", new IntDomaine(5,5));    Variable x96 = new Variable("x96", new IntDomaine(2,2));            Variable x97 = new Variable("x97", new IntDomaine(1,9));    Variable x98 = new Variable("x98", new IntDomaine(1,9));    Variable x99 = new Variable("x99", new IntDomaine(1,9));


        Contrainte ligne1 = new AllDifferent(x11, x12, x13, x14, x15, x16, x17, x18, x19);
        Contrainte ligne2 = new AllDifferent(x21, x22, x23, x24, x25, x26, x27, x28, x29);
        Contrainte ligne3 = new AllDifferent(x31, x32, x33, x34, x35, x36, x37, x38, x39);
        Contrainte ligne4 = new AllDifferent(x41, x42, x43, x44, x45, x46, x47, x48, x49);
        Contrainte ligne5 = new AllDifferent(x51, x52, x53, x54, x55, x56, x57, x58, x59);
        Contrainte ligne6 = new AllDifferent(x61, x62, x63, x64, x65, x66, x67, x68, x69);
        Contrainte ligne7 = new AllDifferent(x71, x72, x73, x74, x75, x76, x77, x78, x79);
        Contrainte ligne8 = new AllDifferent(x81, x82, x83, x84, x85, x86, x87, x88, x89);
        Contrainte ligne9 = new AllDifferent(x91, x92, x93, x94, x95, x96, x97, x98, x99);

        Contrainte colonne1 = new AllDifferent(x11, x21, x31, x41, x51, x61, x71, x81, x91);
        Contrainte colonne2 = new AllDifferent(x12, x22, x32, x42, x52, x62, x72, x82, x92);
        Contrainte colonne3 = new AllDifferent(x13, x23, x33, x43, x53, x63, x73, x83, x93);
        Contrainte colonne4 = new AllDifferent(x14, x24, x34, x44, x54, x64, x74, x84, x94);
        Contrainte colonne5 = new AllDifferent(x15, x25, x35, x45, x55, x65, x75, x85, x95);
        Contrainte colonne6 = new AllDifferent(x16, x26, x36, x46, x56, x66, x76, x86, x96);
        Contrainte colonne7 = new AllDifferent(x17, x27, x37, x47, x57, x67, x77, x87, x97);
        Contrainte colonne8 = new AllDifferent(x18, x28, x38, x48, x58, x68, x78, x88, x98);
        Contrainte colonne9 = new AllDifferent(x19, x29, x39, x49, x59, x69, x79, x89, x99);

        Contrainte carre1 = new AllDifferent(   x11, x12, x13,
                                                x21, x22, x23,
                                                x31, x32, x33);

        Contrainte carre2 = new AllDifferent(   x14, x15, x16,
                                                x24, x25, x26,
                                                x34, x35, x36);

        Contrainte carre3 = new AllDifferent(   x17, x18, x19,
                                                x27, x28, x29,
                                                x37, x38, x39);

        Contrainte carre4 = new AllDifferent(   x41, x42, x43,
                                                x51, x52, x53,
                                                x61, x62, x63);

        Contrainte carre5 = new AllDifferent(   x44, x45, x46,
                                                x54, x55, x56,
                                                x64, x65, x66);

        Contrainte carre6 = new AllDifferent(   x47, x48, x49,
                                                x57, x58, x59,
                                                x67, x68, x69);

        Contrainte carre7 = new AllDifferent(   x71, x72, x73,
                                                x81, x82, x83,
                                                x91, x92, x93);

        Contrainte carre8 = new AllDifferent(   x74, x75, x76,
                                                x84, x85, x86,
                                                x94, x95, x96);

        Contrainte carre9 = new AllDifferent(   x77, x78, x79,
                                                x87, x88, x89,
                                                x97, x98, x99);



        SolverCSP cspSudoku = new SolverCSP();

        cspSudoku.addVariables( x11, x12, x13,    x14, x15, x16,    x17, x18, x19,
                                x21, x22, x23,    x24, x25, x26,    x27, x28, x29,
                                x31, x32, x33,    x34, x35, x36,    x37, x38, x39,

                                x41, x42, x43,    x44, x45, x46,    x47, x48, x49,
                                x51, x52, x53,    x54, x55, x56,    x57, x58, x59,
                                x61, x62, x63,    x64, x65, x66,    x67, x68, x69,

                                x71, x72, x73,    x74, x75, x76,    x77, x78, x79,
                                x81, x82, x83,    x84, x85, x86,    x87, x88, x89,
                                x91, x92, x93,    x94, x95, x96,    x97, x98, x99);

        cspSudoku.addContraintes(   ligne1, ligne2, ligne3, ligne4, ligne5, ligne6, ligne7, ligne8, ligne9,
                                    colonne1, colonne2, colonne3, colonne4, colonne5, colonne6, colonne7, colonne8, colonne9,
                                    carre1, carre2, carre3, carre4, carre5, carre6, carre7, carre8, carre9);

        cspSudoku.evaluate();
    }
}
