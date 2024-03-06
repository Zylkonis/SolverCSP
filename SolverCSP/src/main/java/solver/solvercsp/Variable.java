package solver.solvercsp;

public class Variable{
    private Domaine domaine;
    private final String nom;


    public Variable(String nom) {
        this.domaine = new IntDomaine();
        this.nom = nom;
    }

    public Variable(String name, Domaine domaine) {
        this.domaine = domaine;
        this.nom = name;
    }

    public Domaine getDomaine() {
        return this.domaine;
    }

    public String getNom() {
        return this.nom;
    }

    public boolean infDomaine(Object val){
        return this.domaine.infDomaine(val);
    }

    public boolean supDomaine(Object val){
        return this.domaine.supDomaine(val);
    }

    public boolean diffDomaine(Object val){
        return this.domaine.diffDomaine(val);
    }

    public boolean egalDomaine(Object val){
        return this.domaine.egalDomaine(val);
    }

    public Variable Doppelganger(){ return new Variable(this.getNom(), this.getDomaine()); }
}