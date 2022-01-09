package simulation;

import simulation.evenement.Evenement;

import java.util.LinkedList;

public abstract class SED extends LinkedList<Evenement> {

    public void executer(){
        Evenement evenement;
        while (!this.isEmpty()){
            evenement = this.pop();
            evenement.lancer();
        }
    }
}
