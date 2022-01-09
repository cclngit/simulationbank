package simulation.evenement;

import java.util.ArrayList;

public abstract class Evenement {
    private final double temps;
    private ArrayList<EvenementEcouteur> abonnes;

    public Evenement(double temps) {
        this.temps = temps;
        this.abonnes = new ArrayList<>();
    }

    public void souscrireUnAbonnement(EvenementEcouteur abonne){
        this.abonnes.add(abonne);
    }

    public double getTemps() {
        return temps;
    }

    public void lancer() {
        for (EvenementEcouteur abonne: this.abonnes) {
            abonne.notifier(this);
        }
    }
}
