package solver.solvercsp;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class IntDomaine extends Domaine<Integer> {

    public IntDomaine() {
        super();
        super.domaine.put("min0", -1000);
        super.domaine.put("max0", 1000);
    }

    public IntDomaine(int min, int max) {
        super();
        super.domaine.put("min0", min);
        super.domaine.put("max0", max);
    }

    public IntDomaine(IntDomaine other){
        super.domaine = new HashMap<>(other.domaine);
        super.compteur = other.compteur;
    }

    public IntDomaine(int... vals) {
        super();
        if (vals.length % 2 == 0){
            for (int i = 0; i < vals.length; i++){
                if (i % 2 == 0){
                    super.domaine.put("min" + (i/2), vals[i]);
                }
                else{
                    super.domaine.put("max" + (i/2), vals[i]);
                }
            }
        }
        else {
            throw new IllegalArgumentException("Nombre de valeurs incorrect");
        }
        super.compteur = vals.length / 2;
    }

    public int getCardDomaine(){
        int size = 0;
        for (int i = 0; i < super.compteur; i++){
            size += (this.domaine.get("max" + i) - this.domaine.get("min" + i)) + 1;
        }
        return size;
    }
    public int getMinDomaine(){
        return this.domaine.get("min0");
    }
    public int getMaxDomaine() {
        return this.domaine.get("max" + (super.compteur - 1));
    }
    public int getMinSousDomaine(int i){
        if (i < super.compteur){
            return this.domaine.get("min" + i);
        }
        return -1001;
    }
    public int getMaxSousDomaine(int i){
        if (i < super.compteur){
            return this.domaine.get("max" + i);
        }
        return -1001;
    }

    public void setMinSousDomain(int i, Integer val){
        super.domaine.replace("min"+i, val);
    }

    public void setMaxSousDomain(int i, Integer val){
        super.domaine.replace("max"+i, val);
    }

    @Override
    public boolean infDomaine(Integer val) {
        boolean filtre = false;
        for (int i = 0; i < super.compteur; i++) {
            if (super.domaine.get("min" + i) >= val) {
                super.remSousDomaine(i);
                filtre = true;
            } else if (super.domaine.get("max" + i) >= val) {
                super.domaine.replace("max" + i, val - 1);
                filtre = true;
            }
        }
        return filtre;
    }

    @Override
    public boolean supDomaine(Integer val) {
        boolean filtre = false;
        for (int i = 0; i < super.compteur; i++) {
            if (super.domaine.get("max" + i) <= val) {
                super.remSousDomaine(i);
                filtre = true;
            } else if (super.domaine.get("min" + i) <= val) {
                super.domaine.replace("min" + i, val + 1);
                filtre = true;
            }
        }
        return filtre;
    }

    @Override
    public boolean diffDomaine(Integer val) {
        boolean filtre = false;
        for (int i = 0; i < super.compteur; i++) {
            if (super.domaine.get("min" + i).equals(val) && super.domaine.get("max" + i).equals(val)) {
                super.remSousDomaine(i);
                filtre = true;
                if (super.compteur == 0)
                {
                    return filtre;
                }
            }
            if (super.domaine.get("min" + i).equals(val)) {
                super.domaine.replace("min" + i, val + 1);
                filtre =  true;
            }
            if (super.domaine.get("max" + i).equals(val)) {
                super.domaine.replace("max" + i, val - 1);
                filtre =  true;
            }
            if (super.domaine.get("min" + i) < val && val < super.domaine.get("max" + i)) {
                Integer max = super.domaine.get("max" + i);
                super.domaine.replace("max" + i, val - 1);
                super.addSousDomaine(i+1, val + 1, max);
                filtre =  true;
            }
        }
        return filtre;
    }

    @Override
    public boolean egalDomaine(Integer val) {
        //A voir si on est dans le cas avec une variable
        boolean filtre = false;
        ArrayList<Integer> domIndex = new ArrayList<Integer>();
        for (int i = 0; i < super.compteur; i++) {
            if ((!(super.domaine.get("min" + i).equals(val))) || (!(super.domaine.get("max" + i).equals(val)))){  //tant que la valeur est différente d'au moins une des bornes
                if (super.domaine.get("min" + i) <= val && val <= super.domaine.get("max" + i)) {
                    super.domaine.replace("min" + i, val);
                    super.domaine.replace("max" + i, val);
                } else {
                    domIndex.add(i);
                }
                filtre = true;
            }
        }
        for (int i = domIndex.size() - 1; i >= 0; i--){
            this.remSousDomaine(domIndex.get(i));
        }
        return filtre;
    }
}
