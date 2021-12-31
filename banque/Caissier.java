package banque;

public class Caissier {
    // protected int nbCaissiers; // nombre de caissiers // C EST LA BANQUE QUI CONNAIT LE NB DE CAISSIERS
    protected Client c; // le Client du Caissier
    protected float tempsMoyTraitement; // temps moyent de traitement du caissier
    protected float tempsMoyArriver; // temps moyen d'arriver de Clients

    public Caissier(float tempsT, float tempsA) {
        // nbCaissiers = nbC;
        c = new Client();
        tempsMoyTraitement = tempsT;
        tempsMoyArriver = tempsA;
    }

    public float tempsMoyenService() {

        return 0;
    }

    public int nbClients() {

        return 0;
    }

    public float tauxOccupation() {

        return 0;
    }

    public boolean estLibre() {

        return true;
    }

    public void servic(Client c) {

    }

    public void attendre() {

    }
}
