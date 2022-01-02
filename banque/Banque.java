package banque;


public class Banque {
    protected int nbCaissiers;
    protected int tempsEntreArrivee;
    protected int tempsDeService;
    protected int dureeSimulation;
    protected Caissier c[];
    protected FileAttente fa;

    public Banque(int nbCaissiers, int tempsEntreArrivee, int tempsDeService, int dureeSimulation){
        this.nbCaissiers = nbCaissiers;
        this.tempsDeService = tempsDeService;
        this.tempsEntreArrivee = tempsEntreArrivee;
        this.dureeSimulation = dureeSimulation;
        c = new Caissier[nbCaissiers];
        for(int i=0; i < nbCaissiers; i++){
            c[i] = new Caissier();
        }
        fa = new FileAttente();
    }
    
}
