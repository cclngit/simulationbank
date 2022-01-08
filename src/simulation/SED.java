package simulation;

import java.util.LinkedList;
import banque.Banque;

public class SED extends LinkedList<Evenement>{
    private double temps;

    public SED() {

    }

    public void ajouter(Evenement e) { this.add(e);}  //Ajoute un evenement discret

    public double getTemps() {
        return temps; //return le temps 
    }

    public void executer() {
        while (this.size() != 0) { //tant que la liste n'est pas vide
            Evenement e = this.getFirst(); //le nouvel evenement est le
            this.removeFirst();
            this.temps = e.getHeure();
            e.lancer();
        }
    }

    public void notifierArrivee( double temps) {
    }

    public void notifierDepart( double temps) {
    }
}
