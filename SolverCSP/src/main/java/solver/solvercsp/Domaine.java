package solver.solvercsp;

import java.util.HashMap;
import java.util.Map;

public abstract class Domaine<Object> {
    protected Map<String, Object> domaine;
    protected int compteur = 1;

    public Domaine(){
        this.domaine = new HashMap<>();
    }

    public void addDomaine(Object min, Object max){
        this.domaine.put("min" + this.compteur, min);
        this.domaine.put("max" + this.compteur, max);
        this.compteur += 1;
    }
    public void remDomaine(int index){
        this.domaine.remove("min" + index);
        this.domaine.remove("max" + index);
    };

    public int getCompteur(){return this.compteur;}

    public abstract void infDomaine(Object val);
    public abstract void supDomaine(Object val);
    public abstract void diffDomaine(Object val);
    public abstract void egalDomaine(Object val);
}
