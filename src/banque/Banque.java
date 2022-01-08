package banque;

import simulation.*;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class Banque extends SED {
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

    public void nouveauClient(double heureArrivee){
        Client client = new Client(heureArrivee);
        Evenement arrivee = new Arriver(heureArrivee, this);
        this.ajouter(arrivee);
        this.fileAttente.ajouter(client);
    }

    public static void main(String[] args) {
        double dureePrevue ; int nbCaissiers; double tService; double tempsEntreArrivee;
        Scanner sc = new Scanner(System.in);
        System.out.print("dureePrevue : ");
        dureePrevue = sc.nextDouble();
        System.out.print("nbCaissiers : ");
        nbCaissiers = sc.nextInt();
        System.out.print("tService : ");
        tService = sc.nextDouble();
        System.out.print("tempsEntreArrivee : ");
        tempsEntreArrivee = sc.nextDouble();
        sc.close();

        Banque banque = new Banque(dureePrevue, nbCaissiers, tService, tempsEntreArrivee);
        banque.executer();

    }

}
