package simulation;

import java.util.LinkedList;
import banque.Banque;

public abstract class SED extends LinkedList<Evenement> implements EvenementEcouteur{

    public SED() {

    }

    public void ajouter(Evenement e) { this.add(e);}  //Ajoute un evenement discret

    public void executer() {
        while (this.isEmpty() == false) { //tant que la liste n'est pas vide
            Evenement evenement = this.pop(); //le nouvel evenement est le
            evenement.lancer();
        }
    }

    @Override
    public abstract void notifier(Evenement evenement);
}
