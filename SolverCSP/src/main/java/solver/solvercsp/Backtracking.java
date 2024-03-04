package solver.solvercsp;

import solver.solvercsp.Contraintes.Contrainte;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Backtracking {
    private Map<String, Contrainte> contraintes;
    private int compteur = 0;

    public Backtracking(Map<String, Contrainte> contraintes){
        this.contraintes = contraintes;
        this.compteur = contraintes.size();
    }

    public void startSolve(){

    }
}
