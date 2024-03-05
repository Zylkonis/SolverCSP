package solver.solvercsp;

import solver.solvercsp.Contraintes.Contrainte;

import java.util.HashMap;
import java.util.Map;

public class SolverCSP {
    private Map<String, Variable> variableMap;
    private Map<String, Contrainte> contrainteMap;

    private Backtracking backtracking;
    private int compteurVar = 1;
    private int compteurCont = 1;

    public SolverCSP(){
        this.variableMap = new HashMap<>();
        this.contrainteMap = new HashMap<>();
        this.backtracking = new Backtracking();
    }

    public void addVariable(Variable var){
        this.variableMap.put("var" + this.compteurVar, var);
        this.compteurVar += 1;
    }

    public void addContrainte(Contrainte c){
        this.contrainteMap.put("cont" + this.compteurCont, c);
        this.compteurCont += 1;
    }

    public void evaluate(){
        boolean filtre = true;
        while (filtre){
            filtre = false;
            for (int i = 1; i < this.compteurCont; i++){
                Contrainte x = contrainteMap.get("cont" + i);
                filtre = x.evaluate() || filtre;
            }
            for (int j = 1 ; j < this.compteurVar; j++){
                Variable x = variableMap.get("var" + j);
                System.out.println(x.getNom());
                IntDomaine d = (IntDomaine) x.getDomaine();
                d.printDomain();
            }
        }
    }

    public void forwardChecking(){
        String varname = "var1";
        IntDomaine d = (IntDomaine) variableMap.get("var1").getDomaine();
        int tailleDomaine = d.getSizeDomaine();
        int tmptaille;
        for(int i = 2; i<=this.compteurVar; i++){
            d = (IntDomaine) variableMap.get("var" + i).getDomaine();
            tmptaille = d.getSizeDomaine();
            if(tailleDomaine > tmptaille){
                tailleDomaine = tmptaille;
                varname = "var" + i;
            }
        }
        Variable copy = variableMap.get(varname).Doppelganger();
        this.backtracking.add(copy);
        IntDomaine oldDomaine = (IntDomaine) variableMap.get(varname).getDomaine();
        int tmp = oldDomaine.getMinDomaine();
        IntDomaine newDomain = new IntDomaine(tmp, tmp);
        oldDomaine.changeDomain(newDomain, 1);
    }
}