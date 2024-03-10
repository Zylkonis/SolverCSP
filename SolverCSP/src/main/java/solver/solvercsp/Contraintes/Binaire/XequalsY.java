package solver.solvercsp.Contraintes.Binaire;

import solver.solvercsp.ExceptionDomNull;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

public class XequalsY extends Binaire{
    public XequalsY(Variable v1, Variable v2){
        super(v1, v2);
    }

    @Override
    public boolean evaluate() throws ExceptionDomNull {
        System.out.println("XequalsY\n");
        //v1 == v2
        IntDomaine dx = (IntDomaine) super.var1.getDomaine();
        IntDomaine dy = (IntDomaine) super.var2.getDomaine();
        IntDomaine equals = new IntDomaine();
        boolean end = false;
        boolean filtre = false;
        boolean areEquals = false;
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
                        areEquals = true;
                    }
                }
            }
        }
        if(filtre){
            dx.changeDomain(equals);
            dy.changeDomain(equals);
        } else if (!areEquals) {
            System.out.println("XequalsY : variable est nulle\n");
            throw new ExceptionDomNull("La variable est nulle");
        }
        return filtre;
    }

}
