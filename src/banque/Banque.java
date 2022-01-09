package banque;

import simulation.*;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class Banque extends SED{
    private int nbCaissiers;
    private double tService;
    private double tempsEntreArrivee;
    private double dureePrevue;
    private Caissier[] caissiers;
    private FileAttente fileAttente;
    private Resultat resultat;

    public Banque(double dureePrevue, int nbCaissiers, double tService, double tempsEntreArrivee) {
        super();
        this.dureePrevue = dureePrevue;
        this.nbCaissiers = nbCaissiers;
        this.caissiers = new Caissier[nbCaissiers];
        for (int i = 0; i < nbCaissiers; i++){
            double tpsService = Poisson.next(tService);
            System.out.println("tpsService : " + tpsService);
            this.caissiers[i] = new Caissier(tpsService, this);
        }
        this.tService = tService;
        this.tempsEntreArrivee = tempsEntreArrivee;
        this.fileAttente = new FileAttente(this);
        this.resultat = new Resultat();
    }

    public Caissier unCaissierLibre() {
        for (int i = 0; i < caissiers.length; i++) {
            if (caissiers[i].estLibre())
                return caissiers[i];
        }
        return null;
    }

    public int getNbCaissiers() {
        return nbCaissiers;
    }

    public double getDureePrevue() {
        return dureePrevue;
    }

    public double getTempsEntreArrivee() {
        return tempsEntreArrivee;
    }

    public FileAttente getFileAttente() {
        return fileAttente;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public void nouveauClient(double heureArrivee){
        Evenement arrivee = new Arriver(heureArrivee, this);
        this.ajouter(arrivee);
    }

    @Override
    public void notifier(Evenement evenement) {

        if (evenement instanceof Arriver) {
            System.out.println("Client arrivee : " + evenement.getTemps());
            this.resultat.incrementNbClient();
            this.fileAttente.ajouter(new Client(evenement.getTemps()));

            //  A l'arriver d'un client on regarde si un caissier est libre
            Caissier caissier = this.unCaissierLibre();
            if (caissier != null){
                caissier.servir(this.fileAttente.retirer(), evenement.getTemps());
            }else{
                System.out.println("TU RESTE LA !!!");
            }
        }else if (evenement instanceof Depart){
            System.out.println("Client a fuis : " + evenement.getTemps());
            this.resultat.setDureeReelSimulation(evenement.getTemps());

            //  On verifie que la file n'est pas vide pour re adonner du travail au caissier
            if (!this.fileAttente.estVide()){
                Caissier caissier = this.unCaissierLibre();
                if (caissier != null){
                    caissier.servir(this.fileAttente.retirer(), evenement.getTemps());
                }
            }
        }
        this.getResultat().setLongueurMaxFileAttente(this.fileAttente.getLongueurMax());

        for (Caissier c: this.caissiers) {
            c.liberer(evenement.getTemps());
        }
    }

    @Override
    public void executer() {

        //  Enregistrer les arrivees
        double duree = 0;
        double tempsArrivee = Poisson.next();

        while (duree < dureePrevue) {
            if (duree > tempsArrivee) {
                this.nouveauClient(tempsArrivee);
                tempsArrivee += Poisson.next(tempsEntreArrivee);

            }
            duree+=0.001;
            this.ajouter(new Check(duree, this));
        }

        super.executer();

        System.out.println(this.fileAttente.size());

    }
}
