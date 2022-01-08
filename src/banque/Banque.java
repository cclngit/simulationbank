package banque;

import simulation.SED;

public class Banque extends SED {
    private int nbCaissiers;
    private double tService;
    private double tempsEntreArrivee;
    private double dureePrevue;
    private Caissier[] caissiers;

    protected FileAttente fileAttente;

    public Banque(double dureePrevue, int nbCaissiers, double tService, double tempsEntreArrivee) {
        super();
        this.dureePrevue = dureePrevue;
        this.nbCaissiers = nbCaissiers;
        this.caissiers = new Caissier[nbCaissiers];
        this.tService = tService;
        this.tempsEntreArrivee = tempsEntreArrivee;
    }

    public Caissier unCaussierLibre() {
        for (int i = 0; i < nbCaissiers; i++) {
            if (c[i].estLibre())
                return c[i];
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
}
