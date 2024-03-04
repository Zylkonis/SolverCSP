package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

public class XequalsY extends Binaire{
    public XequalsY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public void evaluate(){
        //v1 == v2
        IntDomaine dx = (IntDomaine) this.var1.getDomaine();
        IntDomaine dy = (IntDomaine) this.var2.getDomaine();
        IntDomaine equals = new IntDomaine();
        int tmpminX = 0;
        int tmpmaxX = 0;
        int tmpminY = 0;
        int tmpmaxY = 0;
        int compteurX = 0;
        int compteurY = 0;
        while(tmpminX != -1001 || tmpminY != -1001){
            tmpminX =dx.getMinSousDomaine(compteurX);
            tmpmaxX = dx.getMaxSousDomaine(compteurX);
            tmpminY = dy.getMinSousDomaine(compteurY);
            tmpmaxY = dy.getMaxSousDomaine(compteurY);
            if(tmpminX>tmpminY){
                if(tmpminX>tmpmaxY){
                    compteurY += 1;
                } else {
                    dy.setMinSousDomain(compteurX, tmpminX);
                }
            } else {
                if(tmpmaxX>tmpminY){
                    if(tmpmaxX>tmpmaxY){
                        dy.setMaxSousDomain(compteurX, tm);
                    }
                    dx.setMinSousDomain(compteurY, tmpminY);
                } else {
                    compteurX += 1;
                }
            }

        }
    }
}
