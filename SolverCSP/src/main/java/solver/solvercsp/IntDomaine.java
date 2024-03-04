package solver.solvercsp;

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

    public int getSizeDomaine(){
        int size = 0;
        for (int i = 0; i < this.compteur; i++){
            size += this.domaine.get("max" + i) - this.domaine.get("min" + i) + 1;
        }
        return size;
    }
    public int getMinDomaine(){
        int min = this.domaine.get("min0");
        for (int i = 1; i < this.compteur; i++){
            if (this.domaine.get("min" + i) < min){
                min = this.domaine.get("min" + i);
            }
        }
        return min;
    }
    public int getMaxDomaine(){
        int max = this.domaine.get("max0");
        for (int i = 1; i < this.compteur; i++){
            if (this.domaine.get("max" + i) > max){
                max = this.domaine.get("max" + i);
            }
        }
        return max;
    }public int getMinSousDomaine(int i){
        if (i < this.compteur){
            return this.domaine.get("min" + i);
        }
        return -1001;
    }
    public int getMaxSousDomaine(int i){
        if (i < this.compteur){
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
    public void infDomaine(Integer val) {
        for (int i = 0; i < getCompteur(); i++) {
            if (super.domaine.get("min" + i) > val) {
                super.remSousDomaine(i);
            } else if (super.domaine.get("max" + i) > val) {
                super.domaine.replace("max" + i, val - 1);
            }
        }
    }

    @Override
    public void supDomaine(Integer val) {
        for (int i = 0; i < getCompteur(); i++) {
            if (super.domaine.get("max" + i) < val) {
                super.remSousDomaine(i);
            } else if (super.domaine.get("min" + i) < val) {
                super.domaine.replace("min" + i, val + 1);
            }
        }
    }

    @Override
    public void diffDomaine(Integer val) {
        for (int i = 0; i < getCompteur(); i++) {
            if (super.domaine.get("min" + i).equals(val)) {
                super.domaine.replace("min" + i, val + 1);
            }
            if (super.domaine.get("max" + i).equals(val)) {
                super.domaine.replace("max" + i, val - 1);
            }
            if (super.domaine.get("min" + i) < val && val < super.domaine.get("max" + i)) {
                Integer max = super.domaine.get("max" + i);
                super.domaine.replace("max" + i, val - 1);
                super.addSousDomaine(val + 1, max);
            }
        }
    }

    @Override
    public void egalDomaine(Integer val) {
        //A voir si on est dans le cas avec une variable
        for (int i = 0; i < getCompteur(); i++) {
            if (super.domaine.get("min" + i) < val && val < super.domaine.get("max" + i)) {
                super.domaine.replace("min" + i, val);
                super.domaine.replace("max" + i, val);
            } else {
                super.remSousDomaine(i);
            }
        }
    }
}
