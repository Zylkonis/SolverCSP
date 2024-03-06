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
    private int compteurEval = 0;

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

    public String getMinDomaineName(){
        String varName = "var1";
        IntDomaine d = (IntDomaine) variableMap.get("var1").getDomaine();
        int tailleDomaine = d.getCardDomaine();
        int tmptaille;
        for(int i = 2; i < this.compteurVar; i++){
            System.out.println("LIGNE 39" + i +"\n");
            d = (IntDomaine) variableMap.get("var" + i).getDomaine();
            tmptaille = d.getCardDomaine();
            if(tailleDomaine > tmptaille){
                tailleDomaine = tmptaille;
                varName = "var" + i;
            }
        }
        return varName;
    }

    public Map<String, Variable> copyVars(){
        Map<String, Variable> vars = new HashMap<>();
        for (int i = 1; i < compteurVar; i++){
            vars.put("var" + i, this.variableMap.get("var" + i).Doppelganger());
        }
        return vars;
    }

    public boolean isSolutionFound(){
        for (int i = 1; i < this.compteurVar; i++){
            System.out.println(i);
            IntDomaine d = (IntDomaine) this.variableMap.get("var" + i).getDomaine();
            if (d.getCardDomaine() != 1){
                return false;
            }
        }
        return true;
    }

    public void printSolution(){
        System.out.println("La première solution trouvée est:");
        for (int i = 1; i < this.compteurVar; i++){
            Variable var = this.variableMap.get("var" + i);
            IntDomaine d = (IntDomaine) var.getDomaine();
            System.out.println(var.getNom() + d.getMaxDomaine());
        }
    }

    public void printDomaines(){
        System.out.println("La première solution trouvée est:");
        for (int i = 1; i < this.compteurVar; i++){
            Variable var = this.variableMap.get("var" + i);
            IntDomaine d = (IntDomaine) var.getDomaine();
            d.printDomain();
        }
    }

    public void evaluate(){
        if (compteurEval == 0) {
            backtracking.add(this.variableMap);
        }
        boolean filtre = true;
        while (filtre){
            filtre = false;
            for (int i = 1; i < this.compteurCont; i++){
                Contrainte x = contrainteMap.get("cont" + i);
                try{
                    System.out.println("evaluation de la contrainte" + i + "\n");
                    filtre = x.evaluate() || filtre;
                    this.variableMap.get("var" + i).getDomaine().printDomain();
                } catch (NullPointerException e){
                    System.out.println("erreur, retour en arrière");
                    Map<String, Variable> newVarMap = backtracking.getHead();
                    this.variableMap.clear();
                    this.variableMap = newVarMap;
                    filtre = false;
                    break;
                }
            }
        }
        if (isSolutionFound()){
            printSolution();
        } else if (backtracking.isEmpty()) {
            System.out.println("il n'y a pas de solutions");
        } else {
            forwardChecking();
        }
    }

    public void forwardChecking(){
        String varName = getMinDomaineName();
        Map<String, Variable> copyVariables = copyVars();

        IntDomaine oldDomaine = (IntDomaine) copyVariables.get(varName).getDomaine();
        int tmp = oldDomaine.getMinDomaine();
        System.out.println("valeur selectionnee : " + tmp + "\n nom de la variable : " + varName + "\n");
        oldDomaine.supDomaine(tmp);
        backtracking.add(copyVariables);

        IntDomaine newDomain = new IntDomaine(tmp, tmp);
        this.variableMap.get(varName).getDomaine().printDomain();
        //this.variableMap.get(varName).getDomaine().changeDomain(newDomain);
        this.variableMap.get(varName).getDomaine().egalDomaine(tmp);
        this.variableMap.get(varName).getDomaine().printDomain();

        evaluate();
    }

}