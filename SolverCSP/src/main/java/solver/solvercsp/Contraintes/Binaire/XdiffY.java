package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.Domaine;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

public class XdiffY extends Binaire{
    public XdiffY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public boolean evaluate(){
        System.out.println("XdiffY\n");
        //v1 != v2
        boolean filtre = false;
        IntDomaine d1 = (IntDomaine) super.var1.getDomaine();
        IntDomaine d2 = (IntDomaine) super.var2.getDomaine();
        IntDomaine tmp = new IntDomaine(0, 0);
        if ( d1.getCardDomaine() == 1 ){
            int value = d1.getMinDomaine();
            filtre = super.var2.diffDomaine(value);
            tmp = (IntDomaine) super.var2.getDomaine();
        }
        if ( d2.getCardDomaine() == 1 ){
            int value = d2.getMinDomaine();
            filtre = super.var1.diffDomaine(value);
            tmp = (IntDomaine) super.var1.getDomaine();
        }
        if(tmp.getDomain() == null){
            System.out.println("XdiffY : variable est nulle\n");
            throw new NullPointerException("La variable est nulle");
        }
        return filtre;
    }
}
