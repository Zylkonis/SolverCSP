package solver.solvercsp;

import solver.solvercsp.Contraintes.Contrainte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolverCSP {
    private Map<String, Variable> variableMap;
    private Map<String, Contrainte> contrainteMap;
    private ArrayList<Integer> results = new ArrayList<>();

    private Backtracking backtracking;
    private int compteurVar = 1;
    private int compteurCont = 1;

    public SolverCSP(){
        this.variableMap = new HashMap<>();
        this.contrainteMap = new HashMap<>();
        this.backtracking = new Backtracking();
    }

    public int getCompteurVar(){
        return this.compteurVar;
    }

    public Variable getVar(int i){
        return this.variableMap.get("var" + i);
    }

    public void addVariable(Variable var){
        this.variableMap.put("var" + this.compteurVar, var);
        this.compteurVar += 1;
    }

    public void addVariables(Variable... vars){
        for (Variable var: vars){
            addVariable(var);
        }
    }

    public void addContrainte(Contrainte c){
        this.contrainteMap.put("cont" + this.compteurCont, c);
        this.compteurCont += 1;
    }

    public void addContraintes(Contrainte... conts){
        for (Contrainte c: conts){
            addContrainte(c);
        }
    }

    public String getSmallDomaineName(){
        String varName = null;
        IntDomaine d;
        int tailleDomaine = 0;
        int tmptaille = 0;
        int index = 1;
        while (varName == null && index < this.compteurVar){
//            System.out.println("valeur index : " + index);
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
        if (this.variableMap.isEmpty()){
            return false;
        }
        for (int i = 1; i < this.compteurVar; i++){
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
            this.results.add(d.getMaxDomaine());
        }
    }

    public void printDomaines(){
        for (int i = 1; i < this.compteurVar; i++){
            if (!this.variableMap.isEmpty()){
                Variable var = this.variableMap.get("var" + i);
                IntDomaine d = (IntDomaine) var.getDomaine();
                System.out.println("Var" + i);
                d.printDomain();
            }
        }
    }


    public ArrayList<Integer> evaluate(){
        boolean filtre = true;
        while (filtre){
            filtre = false;
            for (int i = 1; i < this.compteurCont; i++){
                Contrainte c = contrainteMap.get("cont" + i);
                try{
                    System.out.println("evaluation de la contrainte " + i + "\n");
                    filtre = c.evaluate() || filtre;
                } catch (ExceptionDomNull e){
                    if(backtracking.isEmpty()){
                        System.out.println("il n'y a pas de solutions");
                        return this.results;
                    }else {
                        System.out.println("erreur, retour en arrière");
                        Map<String, Variable> oldMap = backtracking.getHead();

                        System.out.println("Valeurs du domaine recupéré avec le backtracking :");
                        for(int t = 1 ; t < compteurVar; t++){
                            System.out.println(oldMap.get("var"+t).getNom() + " : ");
                            oldMap.get("var"+t).getDomaine().printDomain();
                        }
//                        this.variableMap = oldMap;
                        this.updateDomaines(oldMap);
                        System.out.println("newVapMap =");
                        printDomaines();
                        filtre = true;
                        break;
                    }
                }
            }
        }
        if (!isSolutionFound()){
            forwardChecking();
        }
        else {
            printSolution();
        }
        return this.results;
    }

    public void forwardChecking(){
        String varName = getSmallDomaineName();
        IntDomaine oldDomaine = (IntDomaine) variableMap.get(varName).getDomaine();
        int tmp = oldDomaine.getMinDomaine();
        System.out.println("variable par copie :" + this.variableMap.get(varName).getNom());
        backtracking.add(variableMap, varName, tmp, compteurVar);

        System.out.println(this.variableMap.get(varName).getNom());
        this.variableMap.get(varName).getDomaine().printDomain();
        this.variableMap.get(varName).getDomaine().egalDomaine(tmp);
        System.out.println(this.variableMap.get(varName).getNom());
        this.variableMap.get(varName).getDomaine().printDomain();

        evaluate();
    }

    public void updateDomaines(Map<String, Variable> copyone)
    {
        for (int i = 1; i < this.compteurVar; i++)
        {
            System.out.println("Changement number " + i + "\n");
            this.variableMap.get("var" + i).changeDom(copyone.get("var" + i).getDomaine());
        }
    }
}