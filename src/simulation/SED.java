package simulation;

import java.util.LinkedList;
import banque.Banque;

public class SED extends LinkedList<Evenement>{
    private double temps;

    public SED() {

    }

    public void ajouter(Evenement e) {
        this.add(e); //Ajout un evenement discret
    }

    public double getTemps() {
        return temps; //return le temps 
    }

    public void executer() {
        while (this.size() != 0) { //tant que la list n'est pas vide
            Evenement e = this.getFirst(); //
            this.removeFirst();
            this.temps = e.heure();
            e.traiter();
        }
    }
}
