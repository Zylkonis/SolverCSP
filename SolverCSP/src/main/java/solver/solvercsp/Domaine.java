package solver.solvercsp;

import java.util.HashMap;
import java.util.Map;

public abstract class Domaine<Object> {
    protected Map<String, Object> domaine;
    protected int compteur = 1;

    public Domaine(){
        this.domaine = new HashMap<>();
    }

    public void addSousDomaine(Object min, Object max){
        this.domaine.put("min" + this.compteur, min);
        this.domaine.put("max" + this.compteur, max);
        this.compteur += 1;
    }
    public void remSousDomaine(int index){
        for (int i = index; i < (this.compteur - 1); i++){
            this.domaine.replace("min" + i, this.domaine.get("min" + (i + 1)));
            this.domaine.replace("max" + i, this.domaine.get("max" + (i + 1)));
        }
        this.domaine.remove("min" + this.compteur);
        this.domaine.remove("max" + this.compteur);
        this.compteur -= 1;
    };

    public int getCompteur(){return this.compteur;}

    public abstract void infDomaine(Object val);
    public abstract void supDomaine(Object val);
    public abstract void diffDomaine(Object val);
    public abstract void egalDomaine(Object val);

    public void printDomain(){
        for(int i = 0; i < this.compteur; i++){
            System.out.println("min" + i + " : " + this.domaine.get("min" + i));
            System.out.println("max" + i + " : " + this.domaine.get("max" + i));
        }
        System.out.println();
    };
}
