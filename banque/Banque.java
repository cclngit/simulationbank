package banque;

import simulation.SED;

public class Banque extends SED{
    protected static int nbCaissiers;
    protected int tempsEntreArrivee;
    protected float tempsDeService[];
    protected int dureeSimulation;
    protected Caissier c[];
    protected FileAttente fa;

    public Banque(int nbCaissiers, int tempsEntreArrivee, float[] tempsDeService, int dureeSimulation){
        Banque.nbCaissiers = nbCaissiers;
        this.tempsEntreArrivee = tempsEntreArrivee;
        this.dureeSimulation = dureeSimulation;
        c = new Caissier[nbCaissiers];
        for(int i=0; i < nbCaissiers; i++){
            c[i] = new Caissier(tempsDeService[i]);
        }
        fa = new FileAttente();
    }
    
    public Banque() {
    }

    public Caissier unCaussierLibre(){
        for(int i =0; i< nbCaissiers ; i++){
            if(c[i].estLibre())
                return c[i];
        }
        return null;
    }

    public static float getnbCaissier(){
        return nbCaissiers;
    }

    public float getdureeSimulation(){
        return dureeSimulation;
    }
}
