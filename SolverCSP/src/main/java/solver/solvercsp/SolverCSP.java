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

    public String getSmallDomaineName(){
        String varName = null;
        IntDomaine d;
        int tailleDomaine = 0;
        int tmptaille = 0;
        int index = 1;
        while (varName == null && index < this.compteurVar){
            System.out.println("valeur index : " + index);
            IntDomaine dom = (IntDomaine) this.variableMap.get("var" + index).getDomaine();
            if (dom.getCardDomaine() > 1){
                varName = "var" + index;
                d = (IntDomaine) variableMap.get(varName).getDomaine();
                tmptaille = d.getCardDomaine();
                tailleDomaine = tmptaille;
            }
            index += 1;
        }
        if (varName != null){
            for(int i = 1; i < this.compteurVar; i++){
                d = (IntDomaine) variableMap.get("var" + i).getDomaine();
                tmptaille = d.getCardDomaine();
                if(tailleDomaine > tmptaille && tmptaille > 1){
                    tailleDomaine = tmptaille;
                    varName = "var" + i;
                }
            }
        } else {
            d = (IntDomaine)  variableMap.get("var" + 1).getDomaine();
            tmptaille = d.getCardDomaine();
            tailleDomaine = tmptaille;
            for(int i = 2; i < this.compteurVar; i++){
                d = (IntDomaine) variableMap.get("var" + i).getDomaine();
                tmptaille = d.getCardDomaine();
                if(tailleDomaine > tmptaille && tmptaille > 1){
                    tailleDomaine = tmptaille;
                    varName = "var" + i;
                }
            }
        }
        return varName;
    }

    public Map<String, Variable> copyVars(){
        Map<String, Variable> vars = new HashMap<>();
        for (int i = 1; i < compteurVar; i++){
            vars.put("var" + i, new Variable(this.variableMap.get("var" + i)));
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
            System.out.println(var.getNom() + " -> " + d.getMaxDomaine());
        }
    }

    public void printDomaines(){
        for (int i = 1; i < this.compteurVar; i++){
            Variable var = this.variableMap.get("var" + i);
            IntDomaine d = (IntDomaine) var.getDomaine();
            System.out.println("Var" + i);
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
//                    System.out.println("evaluation de la contrainte" + i + "\n");
                    filtre = x.evaluate() || filtre;
                    //this.variableMap.get("var" + i).getDomaine().printDomain();
                } catch (ExceptionDomNull e){
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
            printDomaines();
            forwardChecking();
        }
    }

    public void forwardChecking(){
        String varName = getSmallDomaineName();
        Map<String, Variable> copyVariables = copyVars();
        System.out.println(varName);
        IntDomaine oldDomaine = (IntDomaine) copyVariables.get(varName).getDomaine();
        int tmp = oldDomaine.getMinDomaine();
        System.out.println("valeur selectionnee : " + tmp + "\n nom de la variable : " + varName + "\n");
        oldDomaine.supDomaine(tmp);
        backtracking.add(copyVariables);
        System.out.println("variable par copie :" + this.variableMap.get(varName).getNom());
        copyVariables.get(varName).getDomaine().printDomain();

        IntDomaine newDomain = new IntDomaine(tmp, tmp);
        System.out.println(this.variableMap.get(varName).getNom());
        this.variableMap.get(varName).getDomaine().printDomain();
        this.variableMap.get(varName).getDomaine().egalDomaine(tmp);
        System.out.println(this.variableMap.get(varName).getNom());
        this.variableMap.get(varName).getDomaine().printDomain();

        evaluate();
    }

}