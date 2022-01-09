package simulation.evenement;

import java.util.ArrayList;

/**
 * Classe permettant de modeliser de evenement
 *
 * @version 2022-01-09
 * @author ALTMANN
 */
public abstract class Evenement {
    private final double temps;
    private ArrayList<EvenementEcouteur> abonnes;

    public Evenement(double temps) {
        this.temps = temps;
        this.abonnes = new ArrayList<>();
    }

    /**
     * Souscrit à un evenement (ecoute l'evenement)
     *
     * @param abonne l'evenement à écouter
     *
     */
    public void souscrireUnAbonnement(EvenementEcouteur abonne){
        this.abonnes.add(abonne);
    }

    public double getTemps() {
        return temps;
    }

    /**
     * Lance l'evenement et notifie
     *
     */
    public void lancer() {
        for (EvenementEcouteur abonne: this.abonnes) {
            abonne.notifier(this);
        }
    }
}
