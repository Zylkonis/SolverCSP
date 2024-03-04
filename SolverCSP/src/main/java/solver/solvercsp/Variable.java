package solver.solvercsp;

public class Variable{
    private Domaine domaine;
    private String name;
//    private

    public Variable(String name) {
        this.domaine = new IntDomaine();
        this.name = name;
    }

    public Variable(String name, Domaine domaine) {
        this.domaine = domaine;
        this.name = name;
    }

    public Domaine getDomaine() {
        return this.domaine;
    }

    public String getName() {
        return this.name;
    }

    public void infDomaine(Object val){
        this.domaine.infDomaine(val);
    }

    public void supDomaine(Object val){
        this.domaine.supDomaine(val);
    }

    public void diffDomaine(Object val){
        this.domaine.diffDomaine(val);
    }

    public void egalDomaine(Object val){
        this.domaine.egalDomaine(val);
    }
}