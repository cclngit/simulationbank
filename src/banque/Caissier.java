package banque;

import java.util.Scanner;

public class Caissier {
    protected double tms; // temps moyent de traitement du caissier
    protected double tauxOcuppattion;
    protected int nbClientServis;
    protected boolean libre;

    public Caissier(double tms, Banque banque) {
        this.tms = tms;
    }

    public boolean estLibre() {
        return libre;
    }

    public double getTauxOcuppattion() {
        return tauxOcuppattion;
    }

    public void servir(Client c) {
        this.libre = false;
    }

    public void liberer() {
        this.libre = true;
    }
}
