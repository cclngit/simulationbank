package banque;

import java.util.Scanner;

public class Caissier {
    // protected int nbCaissiers; // nombre de caissiers // C EST LA BANQUE QUI CONNAIT LE NB DE CAISSIERS
    protected Client c; // le Client du Caissier
    protected float tempsMoyTraitement; // temps moyent de traitement du caissier
    protected float tauxOcuppattion;
    protected int nbClient;
    protected boolean libre;
    private Scanner sc;

    public Caissier(float tempsDeService) {
        sc = new Scanner(System.in);
        tempsDeService = sc.nextInt();
        sc.close();
    }

    public boolean estLibre() {

        return true;
    }

    public void servic(Client c) {

    }

    public void attendre() {

    }
}
