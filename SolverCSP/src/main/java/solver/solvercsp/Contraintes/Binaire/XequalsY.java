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
        boolean end = false;
        int tmpminX = 0;
        int tmpmaxX = 0;
        int tmpminY = 0;
        int tmpmaxY = 0;
        int compteurX = 0;
        int compteurY = 0;
        int compteurEquals = 0;
        while(!end){
            System.out.println("je suis dans la boucle equals\n");
            tmpminX = dx.getMinSousDomaine(compteurX);
            tmpmaxX = dx.getMaxSousDomaine(compteurX);
            tmpminY = dy.getMinSousDomaine(compteurY);
            tmpmaxY = dy.getMaxSousDomaine(compteurY);
            if(tmpminX == -1001 || tmpminY == -1001){
                end = true;
            } else {
                if(tmpminX>tmpminY){
                    if(tmpminX>tmpmaxY){
                        compteurY += 1;
                    } else if(tmpmaxX>tmpmaxY){
                        equals.addSousDomaine(compteurEquals,tmpminY,tmpmaxY);
                        compteurY += 1;
                        compteurEquals += 1;
                    } else { // if(tmpmaxX < tmpmaxY)
                        equals.addSousDomaine(compteurEquals, tmpminY, tmpmaxX);
                        compteurX += 1;
                        compteurEquals += 1;
                    }
                }else {
                    if(tmpminY > tmpmaxX){
                        compteurX += 1;
                    } else if(tmpmaxY > tmpmaxX){
                        equals.addSousDomaine(compteurEquals, tmpminY, tmpmaxX);
                        compteurX += 1;
                        compteurEquals += 1;
                    } else { // if tmpmaxX < tmpmaxY
                        equals.addSousDomaine(compteurEquals, tmpminY, tmpmaxY);
                        compteurY += 1;
                        compteurEquals += 1;
                    }
                }
            }

        }
        dx.changeDomain(equals, compteurEquals);
        dy.changeDomain(equals, compteurEquals);
    }
}
