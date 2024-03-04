package solver.solvercsp;

public class Variable{
    private Domaine domain;
    private String name;
//    private

    public Variable(String name) {
        this.domain = new IntDomaine();
        this.name = name;
    }

    public Variable(String name, Domaine domain) {
        this.domain = domain;
        this.name = name;
    }

    public Domaine getDomain() {
        return this.domain;
    }

    public String getName() {
        return this.name;
    }

    public void infDomaine(Object val){
        this.domain.infDomaine(val);
    }

    public void supDomaine(Object val){
        this.domain.supDomaine(val);
    }

    public void diffDomaine(Object val){
        this.domain.diffDomaine(val);
    }

    public void egalDomaine(Object val){
        this.domain.egalDomaine(val);
    }
}