package banque;

import simulation.Depart;

import java.util.ArrayList;

public class Caissier {
    protected double tms; // temps moyent de traitement du caissier
    protected double tauxOcuppattion;
    private ArrayList<Client> clientsServis;
    protected boolean libre;
    private Banque banque;
    private double tmpDebutService;

    public Caissier(double tms, Banque banque) {
        this.tms = tms;
        this.banque = banque;
        this.libre = true;
        this.clientsServis = new ArrayList<>();
    }

    public boolean estLibre() {
        return libre;
    }

    public double getTauxOcuppattion() {
        return tauxOcuppattion;
    }

    public void servir(Client client, double debutService) {
        this.libre = false;
        this.tmpDebutService = debutService;
        this.clientsServis.add(client);
    }

    public void liberer(double temps) {
        if (!this.estLibre() && temps > this.tmpDebutService + this.tms){
            this.libre = true;
            this.banque.notifier(new Depart(this.tmpDebutService + this.tms, this.banque));
        }
    }
}
