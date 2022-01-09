package simulation;

import java.util.ArrayList;

public abstract class Evenement {
    private double temps;
    private ArrayList<EvenementEcouteur> abonnes;

    public Evenement(double temps, SED sed) {
        this.temps = temps;
        this.abonnes = new ArrayList<>();
        sed.ajouter(this);
        this.souscrire(sed);
    }

    public double getTemps() {
        return this.temps;
    }

    public void souscrire(EvenementEcouteur abonne){
        this.abonnes.add(abonne);
    }

    public void lancer(){
        for (EvenementEcouteur abonne: this.abonnes) {
            abonne.notifier(this);
        }
    }

}
