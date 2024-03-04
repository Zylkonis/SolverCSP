package solver.solvercsp;

public class IntDomaine extends Domaine<Integer>{

    public IntDomaine(){
        super();
        super.domaine.put("min0", -1000);
        super.domaine.put("max0", 1000);
    }
    public IntDomaine(int min, int max){
        super();
        super.domaine.put("min0", min);
        super.domaine.put("max0", max);
    }
    @Override
    public void infDomaine(Integer val){
        for (int i = 0; i < getCompteur(); i++){
            if (super.domaine.get("min" + i) > val)      { super.remDomaine(i); }
            else if (super.domaine.get("max" + i) > val) { super.domaine.replace("max" + i, val); }
        }
    }
    @Override
    public void supDomaine(Integer val){
        for (int i = 0; i < getCompteur(); i++){
            if (super.domaine.get("max" + i) < val)      { super.remDomaine(i); }
            else if (super.domaine.get("min" + i) < val) { super.domaine.replace("min" + i, val); }
        }
    }
    @Override
    public void diffDomaine(Integer val){
        for (int i = 0; i < getCompteur(); i++){
            if (super.domaine.get("min" + i).equals(val)) { super.domaine.replace("min" + i, val + 1); }
            if (super.domaine.get("max" + i).equals(val)) { super.domaine.replace("max" + i, val - 1); }
            if (super.domaine.get("min" + i) < val && val < super.domaine.get("max" + i)) {
                Integer max = super.domaine.get("max" + i);
                super.domaine.replace("max" + i, val - 1);
                super.addDomaine(val + 1, max);
            }
        }
    }
    @Override
    public void egalDomaine(Integer val){
        //A voir si on est dans le cas avec une variable
        for (int i= 0; i < getCompteur(); i++)
        {
            if (super.domaine.get("min" + i) > val && val < super.domaine.get("max" + i)) {
                super.domaine.replace("min" + i, val);
                super.domaine.replace("max" + i, val);
            }
            else { super.remDomaine(i); }
        }
    }

    @Override
    public void printDomain(){
        for(int i = 0; i< domaine.size(); i++){
            System.out.println("min" + i+ " : " + domaine.get("min"+i));
            System.out.println("max" + i+ " : " + domaine.get("max"+i));
        }
    }
}
