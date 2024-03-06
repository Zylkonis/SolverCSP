package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

public class XequalsY extends Binaire{
    public XequalsY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public boolean evaluate(){
        //v1 == v2
        IntDomaine dx = (IntDomaine) super.var1.getDomaine();
        IntDomaine dy = (IntDomaine) super.var2.getDomaine();
        IntDomaine equals = new IntDomaine();
        boolean end = false;
        boolean filtre = false;
        int tmpminX;
        int tmpmaxX;
        int tmpminY;
        int tmpmaxY;
        int compteurX = 0;
        int compteurY = 0;
        int compteurEquals = 0;
        while(!end){
            tmpminX = dx.getMinSousDomaine(compteurX);
            tmpmaxX = dx.getMaxSousDomaine(compteurX);
            tmpminY = dy.getMinSousDomaine(compteurY);
            tmpmaxY = dy.getMaxSousDomaine(compteurY);
            if(tmpminX == -1001 || tmpminY == -1001){
                end = true;
            } else {
                if(tmpminX>tmpminY){
                    if(tmpminX>=tmpmaxY){
                        compteurY += 1;
                    } else if(tmpmaxX>tmpmaxY){
                        equals.addSousDomaine(compteurEquals,tmpminX,tmpmaxY);
                        filtre = true;
                        compteurY += 1;
                        compteurEquals += 1;
                    } else { // if(tmpmaxX < tmpmaxY)
                        equals.addSousDomaine(compteurEquals, tmpminX, tmpmaxX);
                        filtre = true;
                        compteurX += 1;
                        compteurEquals += 1;
                    }
                }else if(tmpminX<tmpminY){
                    if(tmpminY > tmpmaxX){
                        compteurX += 1;
                    } else if(tmpmaxY > tmpmaxX){
                        equals.addSousDomaine(compteurEquals, tmpminY, tmpmaxX);
                        filtre = true;
                        compteurX += 1;
                        compteurEquals += 1;
                    } else { // if tmpmaxX > tmpmaxY
                        equals.addSousDomaine(compteurEquals, tmpminY, tmpmaxY);
                        filtre = true;
                        compteurY += 1;
                        compteurEquals += 1;
                    }
                } else {
                    if(tmpminX==tmpmaxY){
                        equals.addSousDomaine(compteurEquals, tmpminY, tmpmaxY);
                        filtre = true;
                        compteurY += 1;
                        compteurEquals += 1;
                    } else if(tmpmaxX==tmpminY){
                        equals.addSousDomaine(compteurEquals, tmpminX, tmpmaxX);
                        filtre = true;
                        compteurX += 1;
                        compteurEquals += 1;
                    } else if(tmpmaxX > tmpmaxY){
                        equals.addSousDomaine(compteurEquals, tmpminX, tmpmaxY);
                        filtre = true;
                        compteurY += 1;
                        compteurEquals += 1;
                    } else if(tmpmaxX < tmpmaxY){
                        equals.addSousDomaine(compteurEquals, tmpminX, tmpmaxX);
                        filtre = true;
                        compteurX += 1;
                        compteurEquals += 1;
                    } else {
                        compteurX += 1;
                        compteurY += 1;
                    }

                }
            }

        }
        if(filtre){
            dx.changeDomain(equals, compteurEquals);
            dy.changeDomain(equals, compteurEquals);
        }
        return filtre;
    }

}
